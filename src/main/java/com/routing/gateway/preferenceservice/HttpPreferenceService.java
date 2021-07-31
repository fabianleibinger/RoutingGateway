package com.routing.gateway.preferenceservice;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Map;
import java.util.Optional;

public class HttpPreferenceService {
    private static final String BASE_URL = "https://regiomove.fzi.de/backend/";
    private final Integer OK_STATUS_CODE = 200;
    private final Integer OK_STATUS_CODE_POST = 201;
    private final Duration SECONDS_UNTIL_TIMEOUT = Duration.ofSeconds(35);
    private HttpClient httpClient;

    public HttpPreferenceService() {
        this.httpClient = HttpClient.newBuilder().build();
    }

    public Optional<String> getRequest(String path, Map<String, String> headers) {
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(URI.create(this.getCompleteURL(path)))
                .timeout(SECONDS_UNTIL_TIMEOUT)
                .GET();
        headers.forEach(requestBuilder::header);
        HttpRequest request = requestBuilder.build();

        return this.sendRequest(request);
    }

    public Optional<String> postRequest(String path, Map<String, String> headers, String body) {
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(URI.create(this.getCompleteURL(path)))
                .timeout(SECONDS_UNTIL_TIMEOUT)
                .POST(HttpRequest.BodyPublishers.ofString(body));
        headers.forEach(requestBuilder::header);
        HttpRequest request = requestBuilder.build();

        return this.sendRequest(request);
    }

    public Optional<String> putRequest(String path, Map<String, String> headers, String body) {
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(URI.create(this.getCompleteURL(path)))
                .timeout(SECONDS_UNTIL_TIMEOUT)
                .PUT(HttpRequest.BodyPublishers.ofString(body));
        headers.forEach(requestBuilder::header);
        HttpRequest request = requestBuilder.build();

        return this.sendRequest(request);
    }

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
