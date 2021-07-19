package com.routing.gateway.preferenceservice;

import java.net.http.HttpClient;
import java.util.Optional;

public class HttpService {
    private String baseURL = "https://api.openrouteservice.org/v2/directions/";
    private HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
    private Integer OkStatusCode;

    public Optional<String> getRequest() {
        return null;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public HttpClient getHttpClient() {
        return httpClient;
    }

    public void setHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public Integer getOkStatusCode() {
        return OkStatusCode;
    }

    public void setOkStatusCode(Integer okStatusCode) {
        OkStatusCode = okStatusCode;
    }
}
