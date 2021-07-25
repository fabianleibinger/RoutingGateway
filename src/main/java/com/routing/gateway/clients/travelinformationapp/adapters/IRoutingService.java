package com.routing.gateway.clients.travelinformationapp.adapters;

import com.routing.gateway.clients.travelinformationapp.controller.RoutingRequest;
import com.routing.gateway.clients.travelinformationapp.controller.RoutingResult;

import java.net.http.HttpClient;
import java.util.List;
import java.util.Optional;

/**
 * Interface for Routing Services. Must use RoutingRequest.
 */
public interface IRoutingService<RoutingServiceRequest, RoutingServiceResponse> {

    HttpClient HTTP_CLIENT = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
    Integer OK_STATUS_CODE = 200;

    Optional<List<RoutingResult>> computeRoute(RoutingRequest request);

    Optional<String> receiveResponse(RoutingServiceRequest request);

    List<RoutingResult> extractRoutingResult(RoutingServiceResponse response);

    String getName();
    String getURL();
}
