package com.routing.connector.routingservices.adapters;

import java.net.http.HttpResponse;
import java.util.Optional;

/**
 * HTTP interface for Routing Services. Must use RoutingRequest.
 */
public interface HttpRoutingService<RoutingRequest> extends IRoutingService {

    public Optional<HttpResponse<String>> receiveResponse(RoutingRequest request);

}
