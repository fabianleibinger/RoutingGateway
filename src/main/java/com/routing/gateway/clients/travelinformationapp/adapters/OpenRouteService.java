package com.routing.gateway.clients.travelinformationapp.adapters;

import com.google.gson.Gson;
import com.routing.gateway.clients.travelinformationapp.controller.RoutingResult;
import com.routing.gateway.clients.travelinformationapp.controller.RoutingResultNew;
import com.routing.gateway.clients.travelinformationapp.mappers.response.OpenRouteServiceRouteToRoutingResult;
import com.routing.gateway.routingservices.requests.OpenRouteServiceRequest;
import com.routing.gateway.routingservices.requests.RoutingRequest;
import com.routing.gateway.routingservices.responses.openrouteserviceresponse.*;
import fr.xebia.extras.selma.Selma;

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

    /**
     * Returns a routing result for a Openrouteservice request.
     * @param request RoutingRequest
     * @return Optional List RoutingResult
     */
    @Override
    public Optional<List<RoutingResult>> computeRoute(RoutingRequest request) {
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
                return Optional.of(routingResults);
            } else {
                System.out.println("No routes found for the given request");
            }
        }
        return Optional.empty();
    }

    /**
     * Sends POST request to Openrouteservice and tries to receive a HTTP response.
     * @param orsRequest for Openrouteservice
     * @return Optional String: response body that includes a route.
     */
    @Override
    public Optional<String> receiveResponse(OpenRouteServiceRequest orsRequest) {
        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(buildURI(orsRequest.getProfile()))
                .header("Content-Type", "application/json")
                .header("authorization", orsRequest.getAuthorization())
                .timeout(Duration.ofSeconds(35))
                .POST(HttpRequest.BodyPublishers.ofString(orsRequest.serialize()))
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
     * @param openRouteServiceResponse
     * @return routes List of RoutingResult
     */
    @Override
    public List<RoutingResult> extractRoutingResult(OpenRouteServiceResponse openRouteServiceResponse) {
        List<RoutingResult> routes = new ArrayList<>();
        for (OpenRouteServiceRoute route : openRouteServiceResponse.getRoutes()) {
            OpenRouteServiceRouteToRoutingResult mapper = Selma.builder(OpenRouteServiceRouteToRoutingResult.class).build();
            RoutingResultNew result = mapper.asRoutingResult(route);
            System.out.println(result.toJson());
            /*OpenRouteServiceSummary summary = route.getSummary();
            EncodedPolyline encodedPolyline = new EncodedPolyline(route.getGeometry());
            List<LatLng> polyline = encodedPolyline.decodePath();
            Double durationInMinutes = summary.getDuration() / 60;
            Double distanceInMeters = summary.getDistance();
            List<String> instructions = new ArrayList<>();
            for (OpenRouteServiceSegment segment : route.getSegments()) {
                for (OpenRouteServiceStep step : segment.getSteps()) {
                    instructions.add(step.getInstruction());
                }
            }
            List<String> warnings = new ArrayList<>();
            for (OpenRouteServiceWarning warning : route.getWarnings()) {
                warnings.add(warning.getMessage());
            }
            Double ascent = summary.getAscent();
            Double descent = summary.getDescent();

            RoutingResult result = new RoutingResult(polyline, durationInMinutes, distanceInMeters);
            result.setInstructions(instructions);
            result.setWarnings(warnings);
            result.setAscent(ascent);
            result.setDescent(descent);
            routes.add(result);*/
        }
        return routes;
    }

    /**
     * Adds a path variable to the URL.
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
