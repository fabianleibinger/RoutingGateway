package com.routinggateway.clients.travelinformationapp.controller.models;

import java.util.List;

/**
 * Routing response expected by travel information app client.
 */
public class RoutingResponse {
    List<RoutingResultNew> routes;

    public List<RoutingResultNew> getRoutes() {
        return routes;
    }

    public void setRoutes(List<RoutingResultNew> routes) {
        this.routes = routes;
    }
}
