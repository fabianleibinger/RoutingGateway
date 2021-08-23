package com.routinggateway.routingservices.requests;

import com.google.maps.model.LatLng;
import com.routinggateway.clients.travelinformationapp.adapters.IRoutingService;
import com.routinggateway.clients.travelinformationapp.controller.models.RoutingResult;

import java.util.List;
import java.util.Optional;

/**
 * Standardized request for routing services.
 */
public class RoutingRequest {

    //TODO: Add origin and destination to request in Adapter classes
    //TODO: Maybe remove origin destination
    private LatLng origin;
    private LatLng destination;
    RoutingServiceRequest request;
    IRoutingService routingService;

    public RoutingRequest
            (LatLng origin, LatLng destination, RoutingServiceRequest request, IRoutingService routingService) {
        this.origin = origin;
        this.destination = destination;
        this.request = request;
        this.routingService = routingService;
    }

    public Optional<List<RoutingResult>> send() {
        return this.routingService.computeRoute(this);
    }

    public LatLng getOrigin() {
        return origin;
    }

    public void setOrigin(LatLng origin) {
        this.origin = origin;
    }

    public LatLng getDestination() {
        return destination;
    }

    public void setDestination(LatLng destination) {
        this.destination = destination;
    }

    public RoutingServiceRequest getRequest() {
        return request;
    }

    public void setRequest(RoutingServiceRequest request) {
        this.request = request;
    }
}
