package com.routing.gateway.routingservices.requests;

import com.routing.gateway.routingservices.requests.parameters.opentripplannerparameters.OpenTripPlannerParameters;

public class OpenTripPlannerRequest implements RoutingServiceRequest {

    private String routerId = "default";
    private OpenTripPlannerParameters parameters;

    @Override
    public String serialize() {
        return parameters.toQueryString();
    }

    public String getRouterId() {
        return routerId;
    }

    public void setRouterId(String routerId) {
        this.routerId = routerId;
    }

    public OpenTripPlannerParameters getParameters() {
        if (this.parameters == null) {
            this.parameters = new OpenTripPlannerParameters();
        }
        return parameters;
    }

    public void setParameters(OpenTripPlannerParameters parameters) {
        this.parameters = parameters;
    }
}
