package com.routing.gateway.routingservices.adapters;

import com.google.gson.Gson;
import com.google.maps.model.EncodedPolyline;
import com.google.maps.model.LatLng;
import com.routing.gateway.routingservices.RoutingResult;
import com.routing.gateway.routingservices.requests.OpenRouteServiceRequest;
import com.routing.gateway.routingservices.RoutingRequest;
import com.routing.gateway.routingservices.responses.openrouteserviceresponse.OpenRouteServiceResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

/**
 * Adapter for Openrouteservice.
 */
public class OpenRouteService implements IRoutingService<OpenRouteServiceRequest> {

    private static final String NAME = "Openrouteservice";
    private static final String URL = "https://api.openrouteservice.org/v2/directions/";
    private static final HttpClient HTTP_CLIENT = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
    private static final Integer OK_STATUS_CODE = 200;

    /**
     * Returns a routing result for a routing request.
     * @param request RoutingRequest
     * @return Optional<RoutingResult>
     */
    @Override
    //TODO: Parse to RoutingResult
    public Optional<RoutingResult> computeRoute(RoutingRequest request) {
        Optional<String> responseOptional;
        if (request.getRequest().getClass() == OpenRouteServiceRequest.class) {
            responseOptional = this.receiveResponse((OpenRouteServiceRequest) request.getRequest());
        } else {
            System.out.println("Wrong RoutingRequest type provided.");
            return Optional.empty();
        }
        if (responseOptional.isPresent()) {
            String response = responseOptional.get();
            OpenRouteServiceResponse responseObject = new Gson().fromJson(response, OpenRouteServiceResponse.class);
            System.out.println(responseObject.getRoutes().get(0).getGeometry());
            EncodedPolyline polyline = new EncodedPolyline(responseObject.getRoutes().get(0).getGeometry());
            List<LatLng> coordinates = polyline.decodePath();
            System.out.println(coordinates);
        }
        return Optional.empty();
    }

    /**
     * Sends POST request to Openrouteservice and tries to receive a HTTP response.
     * @param orsRequest for Openrouteservice
     * @return HTTP Response that includes a JSON route or empty object.
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
