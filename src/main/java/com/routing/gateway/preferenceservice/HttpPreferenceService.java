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
    private final Duration SECONDS_UNTIL_TIMEOUT = Duration.ofSeconds(35);
    private HttpClient httpClient;

    public HttpPreferenceService() {
        this.httpClient = HttpClient.newBuilder().build();
    }

    public Optional<String> getRequest() {
        return null;
    }

    public Optional<String> postRequest(String path, Map<String, String> headers, String body) {
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(URI.create(this.getCompleteURL(path)))
                .timeout(SECONDS_UNTIL_TIMEOUT)
                .POST(HttpRequest.BodyPublishers.ofString(body));
        headers.forEach(requestBuilder::header);
        HttpRequest request = requestBuilder.build();

        try {
            HttpResponse<String> response = this.httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            System.out.println(response.body());
            return Optional.of(response.body());
        } catch (IOException | InterruptedException e) {
            System.out.println("Failed to reach preference service.");
            return Optional.empty();
        }
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
