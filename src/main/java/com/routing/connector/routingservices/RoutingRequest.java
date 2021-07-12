package com.routing.connector.routingservices;

import com.routing.connector.models.Coordinate;
import com.routing.connector.routingservices.requests.RoutingServiceRequest;

public class RoutingRequest {
    private Coordinate origin;
    private Coordinate destination;
    RoutingServiceRequest request;

    public RoutingRequest(Coordinate origin, Coordinate destination, RoutingServiceRequest request) {
        this.origin = origin;
        this.destination = destination;
        this.request = request;
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
