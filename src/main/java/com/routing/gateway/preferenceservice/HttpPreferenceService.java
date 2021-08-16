package com.routing.gateway.preferenceservice;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Map;
import java.util.Optional;

/**
 * Http endpoint of the preference service.
 */
public class HttpPreferenceService {
    private static final String BASE_URL = "https://regiomove.fzi.de/backend/";
    private final Integer OK_STATUS_CODE = 200;
    private final Integer OK_STATUS_CODE_POST = 201;
    private final Integer OK_STATUS_CODE_DELETE = 204;
    private final Duration SECONDS_UNTIL_TIMEOUT = Duration.ofSeconds(35);
    private HttpClient httpClient;

    public HttpPreferenceService() {
        this.httpClient = HttpClient.newBuilder().build();
    }

    /**
     * Sends a GET request to the preference service.
     * @param path
     * @param headers
     * @return Optional String response body
     */
    public Optional<String> getRequest(String path, Map<String, String> headers) {
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(URI.create(this.getCompleteURL(path)))
                .timeout(SECONDS_UNTIL_TIMEOUT)
                .GET();
        headers.forEach(requestBuilder::header);
        HttpRequest request = requestBuilder.build();

        return this.sendRequest(request);
    }

    /**
     * Sends a POST request to the preference service.
     * @param path
     * @param headers
     * @param body
     * @return Optional String response body
     */
    public Optional<String> postRequest(String path, Map<String, String> headers, String body) {
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(URI.create(this.getCompleteURL(path)))
                .timeout(SECONDS_UNTIL_TIMEOUT)
                .POST(HttpRequest.BodyPublishers.ofString(body));
        headers.forEach(requestBuilder::header);
        HttpRequest request = requestBuilder.build();

        return this.sendRequest(request);
    }

    /**
     * Sends a PUT request to the preference service.
     * @param path
     * @param headers
     * @param body
     * @return Optional String response body
     */
    public Optional<String> putRequest(String path, Map<String, String> headers, String body) {
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(URI.create(this.getCompleteURL(path)))
                .timeout(SECONDS_UNTIL_TIMEOUT)
                .PUT(HttpRequest.BodyPublishers.ofString(body));
        headers.forEach(requestBuilder::header);
        HttpRequest request = requestBuilder.build();

        return this.sendRequest(request);
    }

    /**
     * Returns a response to a http request.
     * @param request
     * @return Optional String response body
     */
    private Optional<String> sendRequest(HttpRequest request) {
        try {
            HttpResponse<String> response = this.httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response status code: " + response.statusCode());
            if (response.statusCode() == OK_STATUS_CODE || response.statusCode() == OK_STATUS_CODE_POST) {
                return Optional.of(response.body());
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Failed to reach preference service.");
        }
        return Optional.empty();
    }

    /**
     * Sends a DELETE request to the preference service.
     * @param path
     * @param headers
     * @return Optional String response body
     */
    public Optional<String> deleteRequest(String path, Map<String, String> headers) {
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(URI.create(this.getCompleteURL(path)))
                .timeout(SECONDS_UNTIL_TIMEOUT)
                .DELETE();
        headers.forEach(requestBuilder::header);
        HttpRequest request = requestBuilder.build();
        try {
            HttpResponse<String> response = this.httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response status code: " + response.statusCode());
            if (response.statusCode() == OK_STATUS_CODE_DELETE) {
                return Optional.of(response.body());
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Failed to reach preference service.");
        }
        return Optional.empty();
    }

    /**
     * Returns a URL including BASE_URL and a path.
     * @param path
     * @return String URL
     */
    public String getCompleteURL(String path) {
        return BASE_URL + path;
    }

    public String getBaseURL() {
        return BASE_URL;
    }

    public Integer getOkStatusCode() {
        return OK_STATUS_CODE;
    }

    public HttpClient getHttpClient() {
        return httpClient;
    }

    public void setHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }
}
