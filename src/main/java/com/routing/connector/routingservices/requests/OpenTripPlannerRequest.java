package com.routing.connector.routingservices.requests;

import com.routing.connector.routingservices.requests.parameters.OpenTripPlannerParameters.OpenTripPlannerParameters;

public class OpenTripPlannerRequest implements RoutingServiceRequest {

    private String routerId = "default";
    private OpenTripPlannerParameters parameters;

    public OpenTripPlannerRequest(OpenTripPlannerParameters parameters) {
        this.parameters = parameters;
    }

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
        return parameters;
    }

    public void setParameters(OpenTripPlannerParameters parameters) {
        this.parameters = parameters;
    }
}
