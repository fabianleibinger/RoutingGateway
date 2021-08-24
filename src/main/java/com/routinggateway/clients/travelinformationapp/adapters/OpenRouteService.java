package com.routinggateway.clients.travelinformationapp.adapters;

import com.google.gson.Gson;
import com.routinggateway.clients.travelinformationapp.controller.models.RoutingRequest;
import com.routinggateway.clients.travelinformationapp.controller.models.RoutingResponse;
import com.routinggateway.clients.travelinformationapp.controller.models.RoutingResult;
import com.routinggateway.clients.travelinformationapp.controller.models.RoutingResultSegment;
import com.routinggateway.clients.travelinformationapp.mappings.OpenRouteServiceRouteToRoutingResult;
import com.routinggateway.routingservices.requests.OpenRouteServiceRequest;
import com.routinggateway.routingservices.requests.StandardRoutingRequest;
import com.routinggateway.routingservices.responses.openrouteserviceresponse.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Adapter for Openrouteservice.
 */
public class OpenRouteService implements IRoutingService<OpenRouteServiceRequest, OpenRouteServiceResponse> {

    private static final String NAME = "Openrouteservice";
    private static final String URL = "https://api.openrouteservice.org/v2/directions/";
    private static final HttpClient HTTP_CLIENT = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
    private static final Integer OK_STATUS_CODE = 200;

    @Override
    public Optional<RoutingResponse> receiveRoutesForPreference(RoutingRequest request) {
        return Optional.empty();
    }

    /**
     * Returns a routing result for a Openrouteservice request.
     *
     * @param request RoutingRequest
     * @return Optional List RoutingResult
     */
    @Override
    public Optional<List<RoutingResult>> computeRoutes(StandardRoutingRequest request) {
        OpenRouteServiceRequest orsRequest;
        if (request.getRequest().getClass() == OpenRouteServiceRequest.class) {
            orsRequest = (OpenRouteServiceRequest) request.getRequest();
        } else {
            System.out.println("Wrong RoutingRequest type provided.");
            return Optional.empty();
        }
        Optional<String> responseOptional = this.receiveResponse(orsRequest);
        if (responseOptional.isPresent()) {
            String response = responseOptional.get();
            OpenRouteServiceResponse responseObject = new Gson().fromJson(response, OpenRouteServiceResponse.class);
            List<RoutingResult> routingResults = this.extractRoutingResult(responseObject);
            if (!routingResults.isEmpty()) {
                // Add mode to RoutingResultSegments
                for (RoutingResult result : routingResults) {
                    for (RoutingResultSegment segment : result.getSegments()) {
                        segment.setModeOfTransport(orsRequest.getProfile());
                    }
                }
                return Optional.of(routingResults);
            } else {
                System.out.println("No routes found for the given request");
            }
        }
        return Optional.empty();
    }

    /**
     * Sends POST request to Openrouteservice and tries to receive a HTTP response.
     *
     * @param openRouteServiceRequest for Openrouteservice
     * @return Optional String: response body that includes a route.
     */
    @Override
    public Optional<String> receiveResponse(OpenRouteServiceRequest openRouteServiceRequest) {
        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(buildURI(openRouteServiceRequest.getProfile()))
                .header("Content-Type", "application/json")
                .header("authorization", openRouteServiceRequest.getAuthorization())
                .timeout(Duration.ofSeconds(35))
                .POST(HttpRequest.BodyPublishers.ofString(openRouteServiceRequest.serialize()))
                .build();
        try {
            HttpResponse<String> response = HTTP_CLIENT.send(postRequest, HttpResponse.BodyHandlers.ofString());
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
     * Returns a list of routes from the openRouteServiceResponse. List might be empty.
     *
     * @param openRouteServiceResponse
     * @return routes List of RoutingResult
     */
    @Override
    public List<RoutingResult> extractRoutingResult(OpenRouteServiceResponse openRouteServiceResponse) {
        List<RoutingResult> routes = new ArrayList<>();
        for (OpenRouteServiceRoute route : openRouteServiceResponse.getRoutes()) {
            RoutingResult result = OpenRouteServiceRouteToRoutingResult.map(route);
            routes.add(result);
        }
        return routes;
    }

    /**
     * Adds a path variable to the URL.
     *
     * @param pathSegment
     * @return URI including pathSegment
     */
    public URI buildURI(String pathSegment) {
        String url = URL + pathSegment;
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
