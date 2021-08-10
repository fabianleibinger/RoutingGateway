package com.routing.gateway.clients.travelinformationapp.adapters;

import com.google.gson.Gson;
import com.google.maps.model.EncodedPolyline;
import com.google.maps.model.LatLng;
import com.routing.gateway.clients.travelinformationapp.controller.RoutingResult;
import com.routing.gateway.clients.travelinformationapp.controller.RoutingResultSegment;
import com.routing.gateway.routingservices.requests.OpenTripPlannerRequest;
import com.routing.gateway.routingservices.requests.RoutingRequest;
import com.routing.gateway.routingservices.responses.opentripplannerresponse.*;

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
     * Returns a routing result for a OpenTripPlanner request.
     * @param request RoutingRequest
     * @return Optional List RoutingResult
     */
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
     * @param openTripPlannerResponse
     * @return routes List of RoutingResult
     */
    @Override
    public List<RoutingResult> extractRoutingResult(OpenTripPlannerResponse openTripPlannerResponse) {
        List<RoutingResult> routes = new ArrayList<>();
        for (OpenTripPlannerItinerary itinerary : openTripPlannerResponse.getPlan().getItineraries()) {
            List<LatLng> polyline = new ArrayList<>();
            Double durationInMinutes = (double) itinerary.getDuration() / 60;
            Double distanceInMeters = 0.0;
            List<String> instructions = new ArrayList<>();
            List<String> warnings = new ArrayList<>();
            String departureTime = String.valueOf(itinerary.getStartTime());
            String arrivalTime = String.valueOf(itinerary.getEndTime());
            Integer numberOfTransfers = itinerary.getTransfers();
            Double ascent = (double) itinerary.getElevationGained();
            Double descent = (double) itinerary.getElevationLost();
            List<RoutingResultSegment> segments = new ArrayList<>();
            for (OpenTripPlannerLeg leg : itinerary.getLeg()) {
                RoutingResultSegment segment = this.extractRoutingResultSegment(leg);
                segments.add(segment);
                distanceInMeters += segment.getDistanceInMeters();
                for (LatLng latLng : segment.getPolyline()) {
                    polyline.add(latLng);
                }
                for (String instruction : segment.getInstructions()) {
                    instructions.add(instruction);
                }
                for (String warning : segment.getWarnings()) {
                    warnings.add(warning);
                }
            }
            RoutingResult route = new RoutingResult(polyline, durationInMinutes, distanceInMeters);
            route.setInstructions(instructions);
            route.setWarnings(warnings);
            route.setDepartureTime(departureTime);
            route.setArrivalTime(arrivalTime);
            route.setNumberOfTransfers(numberOfTransfers);
            route.setAscent(ascent);
            route.setDescent(descent);
            route.setSegments(segments);
        }
        return routes;
    }

    /**
     * Returns a route segment from the openTripPlannerLeg.
     * @param leg openTripPlannerLeg
     * @return RoutingResultSegment
     */
    public RoutingResultSegment extractRoutingResultSegment(OpenTripPlannerLeg leg) {
        EncodedPolyline encodedPolyline = new EncodedPolyline(leg.getLegGeometry().getPoints());
        List<LatLng> polyline = encodedPolyline.decodePath();
        Double durationInMinutes = (double) leg.getDuration() / 60;
        Double distanceInMeters = (double) leg.getDistance();
        String modeOfTransport = leg.getMode();
        List<String> instructions = new ArrayList<>();
        for (OpenTripPlannerWalkStep step : leg.getSteps()) {
            instructions.add
                    (step.getRelativeDirection() + " on " + step.getStreetName() + " for " + step.getDistance());
        }
        List<String> warnings = new ArrayList<>();
        for (OpenTripPlannerLocalizedAlert alert : leg.getAlerts()) {
            warnings.add(alert.getAlertHeaderText());
        }
        String departureTime = String.valueOf(leg.getStartTime());
        String arrivalTime = String.valueOf(leg.getEndTime());
        RoutingResultSegment segment = new RoutingResultSegment
                (polyline, durationInMinutes, distanceInMeters, modeOfTransport);
        segment.setInstructions(instructions);
        segment.setWarnings(warnings);
        segment.setDepartureTime(departureTime);
        segment.setArrivalTime(arrivalTime);
        return segment;
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
