package com.routing.connector.routingservices.adapters;

import com.routing.connector.routingservices.requests.OpenRouteServiceRequest;
import com.routing.connector.routingservices.responses.RoutingResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Optional;

/**
 * Adapter for Openrouteservice.
 */
public class OpenRouteService implements HttpRoutingService<OpenRouteServiceRequest> {

    private static final String NAME = "Openrouteservice";
    private static final String URL = "https://api.openrouteservice.org/v2/directions";
    private static final HttpClient HTTP_CLIENT = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
    private static final Integer OK_STATUS_CODE = 200;

    @Override
    public Optional<RoutingResponse> computeRoute(OpenRouteServiceRequest request) {
        return null;
    }

    /**
     * Sends POST request to Openrouteservice and tries to receive a HTTP response.
     * @param orsRequest for Openrouteservice
     * @return HTTP Response that includes a JSON route or empty object.
     */
    @Override
    public Optional<HttpResponse<String>> receiveResponse(OpenRouteServiceRequest orsRequest) {
        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(URI.create(getURLWithPath(orsRequest.getProfile())))
                .header("Content-Type", "application/json")
                .header("authorization", orsRequest.getAuthorization())
                .timeout(Duration.ofSeconds(35))
                .POST(HttpRequest.BodyPublishers.ofString(orsRequest.toCorrectBodyFormat()))
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

    /**
     * Adds a path variable to the URL specifying the mode.
     * @param pathSegment
     * @return URL including pathSegment
     */
    public String getURLWithPath(String pathSegment) {
        return URL + "/" + pathSegment;
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
