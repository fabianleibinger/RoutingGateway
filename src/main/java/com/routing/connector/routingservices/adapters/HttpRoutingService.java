package com.routing.connector.routingservices.adapters;

import com.routing.connector.models.MobilityPreferences;
import com.routing.connector.routingservices.responses.RoutingResponse;

import java.net.http.HttpResponse;
import java.util.Optional;

/**
 * Interface for Routing Services that use Http. Must use RoutingRequest.
 */
public interface HttpRoutingService<RoutingRequest> {

    public Optional<HttpResponse<String>> receiveResponse(RoutingRequest request);

    Optional<RoutingResponse> computeRoute(RoutingRequest request);

    String getName();
    String getURL();
}
