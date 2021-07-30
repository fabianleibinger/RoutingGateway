package com.routing.gateway.routingservices.requests;

import com.routing.gateway.routingservices.requests.parameters.openrouteserviceparameters.OpenRouteServiceParameters;

/**
 * Request information for Openrouteservice.
 * Includes parameters.
 */
public class OpenRouteServiceRequest implements RoutingServiceRequest {

    private static final String AUTHORIZATION = "5b3ce3597851110001cf6248540f077434854eeda3fb744c240bc46f";
    private String profile;
    private OpenRouteServiceParameters parameters;

    @Override
    public String serialize() {
        return parameters.toJson();
    }

    public String getAuthorization() {
        return AUTHORIZATION;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public OpenRouteServiceParameters getParameters() {
        if (this.parameters == null) {
            this.parameters = new OpenRouteServiceParameters();
        }
        return parameters;
    }

    public void setParameters(OpenRouteServiceParameters parameters) {
        this.parameters = parameters;
    }
}

