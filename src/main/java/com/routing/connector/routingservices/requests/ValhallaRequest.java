package com.routing.connector.routingservices.requests;

public class ValhallaRequest implements RoutingServiceRequest<String> {
    @Override
    public String toCorrectFormat() {
        return "{}";
    }
}
