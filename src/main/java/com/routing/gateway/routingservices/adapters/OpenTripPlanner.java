package com.routing.gateway.routingservices.adapters;

import com.google.gson.Gson;
import com.routing.gateway.routingservices.RoutingResult;
import com.routing.gateway.routingservices.requests.OpenTripPlannerRequest;
import com.routing.gateway.routingservices.RoutingRequest;
import com.routing.gateway.routingservices.responses.opentripplannerresponse.OpenTripPlannerResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

/**
 * Adapter for OpenTripPlanner.
 */
public class OpenTripPlanner implements IRoutingService<OpenTripPlannerRequest, OpenTripPlannerResponse> {
    private static final String NAME = "OpenTripPlanner";
    private static final String URL = "http://se-elsbeere:8090/otp/routers/";

    @Override
    public Optional<List<RoutingResult>> computeRoute(RoutingRequest request) {
        Optional<String> responseOptional;
        if (request.getRequest().getClass() == OpenTripPlannerRequest.class) {
            responseOptional = this.receiveResponse((OpenTripPlannerRequest) request.getRequest());
        } else {
            System.out.println("Wrong RoutingRequest type provided.");
            return Optional.empty();
        }
        if (responseOptional.isPresent()) {
            String response = responseOptional.get();
            OpenTripPlannerResponse responseObject = new Gson().fromJson(response, OpenTripPlannerResponse.class);
            return Optional.of(extractRoutingResult(responseObject));
        }
        return Optional.empty();
    }

    /**
     * Sends GET request to OpenTripPlanner and tries to receive a HTTP response.
     * @param otpRequest for OpenTripPlanner
     * @return HTTP Response that includes a XML route or empty object.
     */
    @Override
    public Optional<String> receiveResponse(OpenTripPlannerRequest otpRequest) {
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(buildURI(otpRequest.getRouterId(), otpRequest.serialize()))
                .header("Content-Type", "application/json")
                .header("User-Agent",
                        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.97 Safari/537.36")
                .header("Cache-Control", "no-cache")
                .timeout(Duration.ofSeconds(35))
                .GET()
                .build();
        try {
            HttpResponse<String> response = HTTP_CLIENT.send(getRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            System.out.println(response.body());
            if (response.statusCode() == OK_STATUS_CODE) {
                return Optional.of(response.body());
            } else {
                System.out.println("Status Code " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Couldn't receive response.");
        }
        return Optional.empty();
    }

    /**
     * Returns a list of routes from the openTripPlannerResponse.
     * @param openTripPlannerResponse
     * @return routes List of RoutingResult
     */
    @Override
    public List<RoutingResult> extractRoutingResult(OpenTripPlannerResponse openTripPlannerResponse) {
        List<RoutingResult> routes = new ArrayList<>();

        Double durationInMinutes;
        Double distanceInMeters;
        String date = Integer.toString(openTripPlannerResponse.getPlan().getDate());

        return routes;
    }

    /**
     * Adds a path variable and a String query to the URL.
     *
     * @param pathSegment
     * @return URI including pathSegment and "plan" path
     */
    public URI buildURI(String pathSegment, String query) {
        String url = URL + pathSegment + "/plan" + query;
        return URI.create(url);
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
