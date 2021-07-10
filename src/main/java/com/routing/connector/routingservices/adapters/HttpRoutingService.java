package com.routing.connector.routingservices.adapters;

import com.routing.connector.routingservices.responses.RoutingResponse;

import java.net.http.HttpResponse;
import java.util.Optional;

/**
 * Interface for Routing Services that use Http. Must use RoutingRequest.
 */
public interface HttpRoutingService<RoutingRequest> {

    Optional<RoutingResponse> computeRoute(RoutingRequest request);

    Optional<HttpResponse<String>> receiveResponse(RoutingRequest request);

    String getName();
    String getURL();
}
