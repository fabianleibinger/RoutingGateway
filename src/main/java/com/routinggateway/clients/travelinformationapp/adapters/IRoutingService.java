package com.routinggateway.clients.travelinformationapp.adapters;

import com.routinggateway.clients.travelinformationapp.controller.models.RoutingRequest;
import com.routinggateway.clients.travelinformationapp.controller.models.RoutingResponse;
import com.routinggateway.clients.travelinformationapp.controller.models.RoutingResult;

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
     * Returns a response including routes for a request by a travel information app.
     * @param request RoutingRequest
     * @return Optional RoutingResponse
     */
    Optional<RoutingResponse> receiveRoutesForPreference(RoutingRequest request);

    /**
     * Returns routing results for a routing request.
     *
     * @param request StandardRoutingRequest
     * @return Optional List RoutingResult
     */
    Optional<List<RoutingResult>> computeRoutes(RoutingServiceRequest request);

    /**
     * Sends HTTP request to the Routing Service and tries to receive a HTTP response.
     *
     * @param request service-specific RoutingServiceRequest
     * @return Optional String: response body that includes a route.
     */
    Optional<String> receiveResponse(RoutingServiceRequest request);

    /**
     * Returns a list of routes from the RoutingServiceResponse. List might be empty.
     *
     * @param response RoutingSercviceResponse
     * @return List RoutingResult
     */
    List<RoutingResult> extractRoutingResult(RoutingServiceResponse response);

    String getName();

    String getURL();
}
