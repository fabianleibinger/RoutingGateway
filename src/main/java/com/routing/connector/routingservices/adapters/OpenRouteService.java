package com.routing.connector.routingservices.adapters;

import com.routing.connector.models.MobilityPreferences;
import com.routing.connector.routingservices.responses.RoutingResponse;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;
import java.time.Duration;

public class OpenRouteService implements IRoutingService {

    private static final String NAME = "Openrouteservice";
    private static final String URL = "api.openrouteservice.org/v2/directions";
    private static final HttpClient HTTP_CLIENT = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
    private static final Integer OK_STATUS_CODE = 200;

    public String getURLWithPath(String pathSegment) {
        return URL + "/" + pathSegment;
    }

    public HttpResponse<String> postRequest() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(getURLWithPath("driving-car")))
                .timeout(Duration.ofMinutes(2))
                .header("Authorization", )
                .POST(HttpRequest.BodyPublishers.ofFile(Paths.get("file.json")))
                .build();
    }

    @Override
    public RoutingResponse computeRoute(MobilityPreferences preferences) {
        return null;
    }

    @Override
    public String getName() {
        return "null";
    }

    @Override
    public String getURL() {
        return null;
    }
}
