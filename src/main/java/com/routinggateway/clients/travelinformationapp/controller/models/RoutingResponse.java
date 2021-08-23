package com.routinggateway.clients.travelinformationapp.controller.models;

import java.util.List;

/**
 * Routing response expected by travel information app client.
 */
public class RoutingResponse {
    List<RoutingResult> routes;

    public List<RoutingResult> getRoutes() {
        return routes;
    }

    public void setRoutes(List<RoutingResult> routes) {
        this.routes = routes;
    }
}
