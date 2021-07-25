package com.routing.gateway.routingservices.responses.openrouteserviceresponse;

import com.routing.gateway.routingservices.Parameters;

import java.util.ArrayList;
import java.util.List;

/**
 * Response information of a successful request to OpenRouteService.
 */
public class OpenRouteServiceResponse extends Parameters {
    private List<Double> bbox;
    private OpenRouteServiceMetadata metadata;
    private List<OpenRouteServiceRoute> routes;

    public List<Double> getBbox() {
        if (this.bbox == null) {
            this.bbox = new ArrayList<>();
        }
        return bbox;
    }

    public void setBbox(List<Double> bbox) {
        this.bbox = bbox;
    }

    public OpenRouteServiceMetadata getMetadata() {
        if (this.metadata == null) {
            this.metadata = new OpenRouteServiceMetadata();
        }
        return metadata;
    }

    public void setMetadata(OpenRouteServiceMetadata metadata) {
        this.metadata = metadata;
    }

    public List<OpenRouteServiceRoute> getRoutes() {
        if (this.routes == null) {
            this.routes = new ArrayList<>();
        }
        return routes;
    }

    public void setRoutes(List<OpenRouteServiceRoute> routes) {
        this.routes = routes;
    }
}
