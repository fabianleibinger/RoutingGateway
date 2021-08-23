package com.routinggateway.routingservices.requests;

import com.google.maps.model.LatLng;
import com.routinggateway.clients.travelinformationapp.adapters.IRoutingService;
import com.routinggateway.clients.travelinformationapp.controller.models.RoutingResult;

import java.util.List;
import java.util.Optional;

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
