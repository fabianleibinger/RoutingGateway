package com.routing.gateway.clients.travelinformationapp.adapters;

import com.routing.gateway.routingservices.requests.RoutingRequest;
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

    /**
     * Returns a routing result for a routing request.
     * @param request RoutingRequest
     * @return Optional List RoutingResult
     */
    Optional<List<RoutingResult>> computeRoute(RoutingRequest request);

    /**
     * Sends HTTP request to the Routing Service and tries to receive a HTTP response.
     * @param request RoutingServiceRequest
     * @return Optional String: response body that includes a route.
     */
    Optional<String> receiveResponse(RoutingServiceRequest request);

    /**
     * Returns a list of routes from the RoutingServiceResponse. List might be empty.
     * @param response RoutingSercviceResponse
     * @return List RoutingResult
     */
    List<RoutingResult> extractRoutingResult(RoutingServiceResponse response);

    String getName();
    String getURL();
}
