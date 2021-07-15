package com.routing.gateway.routingservices.requests;

import com.routing.gateway.routingservices.requests.parameters.valhallaparameters.ValhallaParameters;

/**
 * Request information for Valhalla.
 * Includes parameters.
 */
public class ValhallaRequest implements RoutingServiceRequest {

    private ValhallaParameters parameters;

    public ValhallaRequest(ValhallaParameters parameters) {
        this.parameters = parameters;
    }

    @Override
    public String serialize() {
        return parameters.toJson();
    }

    public ValhallaParameters getParameters() {
        return parameters;
    }

    public void setParameters(ValhallaParameters parameters) {
        this.parameters = parameters;
    }
}
