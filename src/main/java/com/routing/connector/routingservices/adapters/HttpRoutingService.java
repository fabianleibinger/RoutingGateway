package com.routing.connector.routingservices.adapters;

import com.routing.connector.routingservices.requests.RoutingRequest;
import com.routing.connector.routingservices.responses.RoutingResponse;

import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.util.Optional;

/**
 * Interface for Routing Services that use Http. Must use RoutingRequest.
 */
public interface HttpRoutingService<RoutingServiceRequest> {

    Optional<RoutingResponse> computeRoute(RoutingRequest request);

    Optional<HttpResponse<String>> receiveResponse(RoutingServiceRequest request) throws URISyntaxException;

    String getName();
    String getURL();
}
