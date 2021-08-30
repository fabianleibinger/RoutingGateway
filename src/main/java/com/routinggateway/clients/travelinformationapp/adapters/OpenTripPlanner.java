package com.routinggateway.clients.travelinformationapp.adapters;

import com.google.gson.Gson;
import com.routinggateway.clients.travelinformationapp.controller.models.RoutingRequest;
import com.routinggateway.clients.travelinformationapp.controller.models.RoutingResponse;
import com.routinggateway.clients.travelinformationapp.controller.models.RoutingResult;
import com.routinggateway.clients.travelinformationapp.mappings.OpenTripPlannerItineraryToRoutingResult;
import com.routinggateway.routingservices.requests.OpenTripPlannerRequest;
import com.routinggateway.routingservices.requests.parameters.opentripplannerparameters.OpenTripPlannerParameters;
import com.routinggateway.routingservices.responses.opentripplannerresponse.*;
import org.nomin.NominMapper;
import org.nomin.core.Nomin;

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

    /**
     * Returns a routing response for a routing request according to mobility preferences.
     *
     * @param request RoutingRequest
     * @return Optional RoutingResponse
     */
    @Override
    public Optional<RoutingResponse> receiveRoutesForPreference(RoutingRequest request) {
        NominMapper nomin = new Nomin("mappings/RoutingRequestToOpenTripPlannerParameters.groovy");
        OpenTripPlannerParameters parameters = nomin.map(request, OpenTripPlannerParameters.class);

        OpenTripPlannerRequest otpRequest = new OpenTripPlannerRequest();
        otpRequest.setParameters(parameters);

        Optional<List<RoutingResult>> routes = this.computeRoutes(otpRequest);

        if (routes.isPresent()) {
            System.out.println("Returned routes for preference successfully.");
            return Optional.of(new RoutingResponse(routes.get()));
        }
        return Optional.empty();
    }

    /**
     * Returns a routing result for a OpenTripPlanner request.
     *
     * @param request RoutingRequest
     * @return Optional List RoutingResult
     */
    @Override
    public Optional<List<RoutingResult>> computeRoutes(OpenTripPlannerRequest request) {
        Optional<String> response = this.receiveResponse(request);
        if (response.isPresent()) {
            OpenTripPlannerResponse responseObject = new Gson().fromJson(response.get(), OpenTripPlannerResponse.class);
            List<RoutingResult> routingResults = this.extractRoutingResult(responseObject);
            if (!routingResults.isEmpty()) {
                return Optional.of(routingResults);
            } else {
                System.out.println("No routes found for the given request");
            }
        }
        return Optional.empty();
    }

    /**
     * Sends GET request to OpenTripPlanner and tries to receive a HTTP response.
     *
     * @param otpRequest for OpenTripPlanner
     * @return Optional String: response body that includes a route.
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
     * Returns a list of routes from the openTripPlannerResponse. List might be empty.
     *
     * @param openTripPlannerResponse
     * @return routes List of RoutingResult
     */
    @Override
    public List<RoutingResult> extractRoutingResult(OpenTripPlannerResponse openTripPlannerResponse) {
        OpenTripPlannerItineraryToRoutingResult mapper = new OpenTripPlannerItineraryToRoutingResult();

        List<RoutingResult> routes = new ArrayList<>();
        for (OpenTripPlannerItinerary itinerary : openTripPlannerResponse.getPlan().getItineraries()) {
            routes.add(mapper.map(itinerary));
        }
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
