package com.routinggateway.clients.travelinformationapp.adapters;

import com.google.gson.Gson;
import com.routinggateway.clients.travelinformationapp.controller.models.RoutingRequest;
import com.routinggateway.clients.travelinformationapp.controller.models.RoutingResponse;
import com.routinggateway.clients.travelinformationapp.controller.models.RoutingResult;
import com.routinggateway.clients.travelinformationapp.controller.models.RoutingResultSegment;
import com.routinggateway.clients.travelinformationapp.mappings.OpenRouteServiceRouteToRoutingResult;
import com.routinggateway.routingservices.requests.OpenRouteServiceRequest;
import com.routinggateway.routingservices.requests.parameters.openrouteserviceparameters.OpenRouteServiceParameters;
import com.routinggateway.routingservices.responses.openrouteserviceresponse.*;
import org.nomin.NominMapper;
import org.nomin.core.Nomin;

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
     * Returns a routing response for a routing request according to mobility preferences.
     *
     * @param request RoutingRequest
     * @return Optional RoutingResponse
     */
    @Override
    public Optional<RoutingResponse> receiveRoutesForPreference(RoutingRequest request) {
        NominMapper mapping = new Nomin("mappings/RoutingRequestToOpenRouteServiceParameters.groovy");
        OpenRouteServiceParameters parameters = mapping.map(request, OpenRouteServiceParameters.class);

        OpenRouteServiceRequest orsRequest = new OpenRouteServiceRequest();
        orsRequest.setParameters(parameters);

        List<RoutingResult> routeList = new ArrayList<>();

        // Add routes for preferredModes
        List<String> preferredModes = request.getPreferenceProfile().getModePreferences().getPreferredModes();
        this.addToRouteListAccordingToModeList(preferredModes, orsRequest, request, routeList);

        // Add routes for neutral modes
        if (routeList.isEmpty()) {
            List<String> neutralModes = request.getPreferenceProfile().getModePreferences().getNeutralModes();
            this.addToRouteListAccordingToModeList(preferredModes, orsRequest, request, routeList);
        }

        // Add routes for accessibility
        if (request.getUserProfile().getAccessibility()) {
            orsRequest.setProfile("wheelchair");
            this.addResultsToRouteList(orsRequest, routeList);
        }

        if (!routeList.isEmpty()) {
            System.out.println("Returned routes for preference successfully.");
            return Optional.of(new RoutingResponse(routeList));
        }
        return Optional.empty();
    }

    /**
     * Adds routes to the routeList that match a mode preference list.
     *
     * @param modes preferred modes
     * @param orsRequest OpenRouteServiceRequest
     * @param routingRequest
     * @param routeList List RoutingResult
     */
    public void addToRouteListAccordingToModeList(List<String> modes,
                                                  OpenRouteServiceRequest orsRequest,
                                                  RoutingRequest routingRequest,
                                                  List<RoutingResult> routeList) {
        if (modes.stream().anyMatch(s -> s.equals("car")) && routingRequest.getUserProfile().getPrivateCarAvailable()) {
            orsRequest.setProfile("driving-car");
            this.addResultsToRouteList(orsRequest, routeList);
        }
        if (modes.stream().anyMatch(s -> s.equals("bike")) && routingRequest.getUserProfile().getPrivateBicycleAvailable()) {
            orsRequest.setProfile("cycling-regular");
            this.addResultsToRouteList(orsRequest, routeList);
        }
        if (modes.stream().anyMatch(s -> s.equals("walk"))) {
            orsRequest.setProfile("foot-walking");
            this.addResultsToRouteList(orsRequest, routeList);
        }
    }

    /**
     * Receives an optional list of results for a request.
     * Adds it to a list of routes including the mode.
     *
     * @param request OpenRouteServiceRequest
     * @param routeList List RoutingResult
     */
    public void addResultsToRouteList(OpenRouteServiceRequest request, List<RoutingResult> routeList) {
        Optional<List<RoutingResult>> resultList = this.computeRoutes(request);
        if (resultList.isPresent()) {
            for (RoutingResult result : resultList.get()) {
                // Add mode to result segments.
                for (RoutingResultSegment segment : result.getSegments()) {
                    segment.setModeOfTransport(request.getProfile());
                }
                routeList.add(result);
            }
        }
    }

    /**
     * Returns a routing result for a Openrouteservice request.
     *
     * @param request RoutingRequest
     * @return Optional List RoutingResult
     */
    @Override
    public Optional<List<RoutingResult>> computeRoutes(OpenRouteServiceRequest request) {
        Optional<String> responseOptional = this.receiveResponse(request);
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
