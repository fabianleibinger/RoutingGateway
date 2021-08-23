package com.routinggateway.routingservices.requests;

import com.routinggateway.clients.travelinformationapp.adapters.IRoutingService;

/**
 * Standardized request for routing services.
 */
public class StandardRoutingRequest {

    RoutingServiceRequest request;
    IRoutingService routingService;

    public StandardRoutingRequest
            (RoutingServiceRequest request, IRoutingService routingService) {
        this.request = request;
        this.routingService = routingService;
    }

    public RoutingServiceRequest getRequest() {
        return request;
    }

    public void setRequest(RoutingServiceRequest request) {
        this.request = request;
    }
}
