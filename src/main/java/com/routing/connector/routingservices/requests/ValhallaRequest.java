package com.routing.connector.routingservices.requests;

public class ValhallaRequest implements RoutingServiceRequest {
    @Override
    public String serialize() {
        return "{\"locations\":[{\"lat\":42.358528,\"lon\":-83.271400,\"street\":\"Appleton\"},{\"lat\":42.996613,\"lon\":-78.749855,\"street\":\"Ranch Trail\"}],\"costing\":\"auto\",\"costing_options\":{\"auto\":{\"country_crossing_penalty\":2000.0}},\"units\":\"miles\",\"id\":\"my_work_route\"}";
    }
}
