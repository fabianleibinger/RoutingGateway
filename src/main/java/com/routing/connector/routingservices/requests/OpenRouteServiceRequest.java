package com.routing.connector.routingservices.requests;

import com.routing.connector.routingservices.parameters.OpenRouteServiceParameters.OpenRouteServiceParameters;

/**
 * Request information for Openrouteservice.
 * Includes parameters.
 */
public class OpenRouteServiceRequest implements RoutingServiceRequest<String> {

    private static final String AUTHORIZATION = "5b3ce3597851110001cf6248540f077434854eeda3fb744c240bc46f";
    private String profile;
    private OpenRouteServiceParameters parameters;

    public OpenRouteServiceRequest(String profile,
                                   OpenRouteServiceParameters parameters) {
        this.profile = profile;
        this.parameters = parameters;
    }

    @Override
    public String toCorrectFormat() {
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
        return parameters;
    }

    public void setParameters(OpenRouteServiceParameters parameters) {
        this.parameters = parameters;
    }
}

