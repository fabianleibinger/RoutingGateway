package com.routing.connector.routingservices.adapters;

import com.routing.connector.routingservices.requests.OpenTripPlannerRequest;
import com.routing.connector.routingservices.responses.RoutingResponse;

import java.net.http.HttpResponse;
import java.util.Optional;

/**
 * Adapter for OpenTripPlanner.
 */
public class OpenTripPlanner implements HttpRoutingService<OpenTripPlannerRequest>{

    @Override
    public Optional<RoutingResponse> computeRoute(OpenTripPlannerRequest otpRequest) {
        return Optional.empty();
    }

    @Override
    public Optional<HttpResponse<String>> receiveResponse(OpenTripPlannerRequest otpRequest) {
        return Optional.empty();
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getURL() {
        return null;
    }
}
