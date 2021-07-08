package com.routing.connector.routingservices.adapters;

import com.routing.connector.models.MobilityPreferences;
import com.routing.connector.routingservices.requests.OpenRouteServiceRequest;
import com.routing.connector.routingservices.responses.RoutingResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Optional;

public class OpenRouteService implements IRoutingService {

    private static final String NAME = "Openrouteservice";
    private static final String URL = "https://api.openrouteservice.org/v2/directions";
    private static final HttpClient HTTP_CLIENT = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
    private static final Integer OK_STATUS_CODE = 200;

    /**
     * Adds a path variable to the URL specifying the mode.
     * @param pathSegment
     * @return URL
     */
    public String getURLWithPath(String pathSegment) {
        return URL + "/" + pathSegment;
    }

    /**
     * Sends POST request to Openrouteservice and tries to receive a HTTP response.
     * @param parameters for Openrouteservice
     * @return HTTP Response that includes a JSON route.
     */
    public Optional<HttpResponse<String>> receiveResponse(OpenRouteServiceRequest parameters) {
        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(URI.create(getURLWithPath(parameters.getProfile())))
                .header("Content-Type", "application/json")
                .header("authorization", parameters.getAuthorization())
                .timeout(Duration.ofSeconds(35))
                .POST(HttpRequest.BodyPublishers.ofString(parameters.toCorrectFormat()))
                .build();
        try {
            HttpResponse<String> response = HTTP_CLIENT.send(postRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            System.out.println(response.body());
            return Optional.of(response);
        } catch (IOException | InterruptedException e) {
            System.out.println("Couldn't receive response.");
            return Optional.empty();
        }
    }

    @Override
    public Optional<RoutingResponse> computeRoute(MobilityPreferences preferences) {
        return null;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getURL() {
        return URL;
    }
}
