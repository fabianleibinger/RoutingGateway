package com.routing.gateway.routingservices.requests;

import com.routing.gateway.routingservices.requests.parameters.valhallaparameters.ValhallaParameters;

/**
 * Request information for Valhalla.
 * Includes parameters.
 */
public class ValhallaRequest implements RoutingServiceRequest {

    private ValhallaParameters parameters;

    @Override
    public String serialize() {
        return parameters.toJson();
    }

    public ValhallaParameters getParameters() {
        if (this.parameters == null) {
            this.parameters = new ValhallaParameters();
        }
        return parameters;
    }

    public void setParameters(ValhallaParameters parameters) {
        this.parameters = parameters;
    }
}
