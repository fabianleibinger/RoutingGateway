package com.routinggateway.clients.travelinformationapp.adapters;

import com.google.gson.Gson;
import com.google.maps.model.EncodedPolyline;
import com.google.maps.model.LatLng;
import com.routinggateway.clients.travelinformationapp.controller.models.RoutingRequest;
import com.routinggateway.clients.travelinformationapp.controller.models.RoutingResponse;
import com.routinggateway.clients.travelinformationapp.controller.models.RoutingResult;
import com.routinggateway.clients.travelinformationapp.controller.models.RoutingResultSegment;
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

        Optional<List<RoutingResult>> resultList = this.computeRoutes(otpRequest);

        if (resultList.isPresent()) {
            System.out.println("Returned routes for preference successfully.");
            return Optional.of(new RoutingResponse(resultList.get()));
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
        List<RoutingResult> routes = new ArrayList<>();
        for (OpenTripPlannerItinerary itinerary : openTripPlannerResponse.getPlan().getItineraries()) {
            EncodedPolyline encodedPolyline;
            Double durationInMinutes = ((double) itinerary.getDuration()) / 60;
            Double distanceInMeters = 0.0;
            String departureTime = String.valueOf(itinerary.getStartTime());
            String arrivalTime = String.valueOf(itinerary.getEndTime());
            Integer numberOfTransfers = itinerary.getTransfers();
            List<RoutingResultSegment> segments = new ArrayList<>();

            List<LatLng> polyline = new ArrayList<>();
            for (OpenTripPlannerLeg leg : itinerary.getLeg()) {
                RoutingResultSegment segment = this.extractRoutingResultSegment(leg);
                segments.add(segment);
                distanceInMeters += segment.getDistanceInMeters();

                EncodedPolyline googlePolyline = new EncodedPolyline(segment.getEncodedPolyline());
                List<LatLng> polyPoints = googlePolyline.decodePath();
                polyline.addAll(polyPoints);
            }
            encodedPolyline = new EncodedPolyline(polyline);

            RoutingResult route = new RoutingResult();
            route.setEncodedPolyline(encodedPolyline.getEncodedPath());
            route.setDurationInMinutes(durationInMinutes);
            route.setDistanceInMeters(distanceInMeters);
            route.setDepartureTime(departureTime);
            route.setArrivalTime(arrivalTime);
            route.setNumberOfTransfers(numberOfTransfers);
            route.setSegments(segments);
            routes.add(route);
        }
        return routes;
    }

    /**
     * Returns a route segment from the openTripPlannerLeg.
     *
     * @param leg openTripPlannerLeg
     * @return RoutingResultSegment
     */
    public RoutingResultSegment extractRoutingResultSegment(OpenTripPlannerLeg leg) {
        String encodedPolyline = leg.getLegGeometry().getPoints();
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

        RoutingResultSegment segment = new RoutingResultSegment();
        segment.setEncodedPolyline(encodedPolyline);
        segment.setDurationInMinutes(durationInMinutes);
        segment.setDistanceInMeters(distanceInMeters);
        segment.setModeOfTransport(modeOfTransport);
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
