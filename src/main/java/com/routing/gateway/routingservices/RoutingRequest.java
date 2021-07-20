package com.routing.gateway.routingservices;

import com.routing.gateway.models.Coordinate;
import com.routing.gateway.routingservices.adapters.IRoutingService;
import com.routing.gateway.routingservices.requests.RoutingServiceRequest;

import java.util.Optional;

public class RoutingRequest {
    private Coordinate origin;
    private Coordinate destination;
    RoutingServiceRequest request;
    IRoutingService routingService;

    public RoutingRequest
            (Coordinate origin, Coordinate destination, RoutingServiceRequest request, IRoutingService routingService) {
        this.origin = origin;
        this.destination = destination;
        this.request = request;
        this.routingService = routingService;
    }

    public Optional<RoutingResult> send() {
        return this.routingService.computeRoute(this);
    }

    public Coordinate getOrigin() {
        return origin;
    }

    public void setOrigin(Coordinate origin) {
        this.origin = origin;
    }

    public Coordinate getDestination() {
        return destination;
    }

    public void setDestination(Coordinate destination) {
        this.destination = destination;
    }

    public RoutingServiceRequest getRequest() {
        return request;
    }

    public void setRequest(RoutingServiceRequest request) {
        this.request = request;
    }
}
