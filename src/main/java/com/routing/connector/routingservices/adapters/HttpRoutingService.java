package com.routing.connector.routingservices.adapters;

import com.routing.connector.routingservices.RoutingRequest;
import com.routing.connector.routingservices.RoutingResult;

import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.Optional;

/**
 * Interface for Routing Services that use Http. Must use RoutingRequest.
 */
public interface HttpRoutingService<RoutingServiceRequest> {

    HttpClient HTTP_CLIENT = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
    Integer OK_STATUS_CODE = 200;

    Optional<RoutingResult> computeRoute(RoutingRequest request);

    Optional<String> receiveResponse(RoutingServiceRequest request);

    String getName();
    String getURL();
}
