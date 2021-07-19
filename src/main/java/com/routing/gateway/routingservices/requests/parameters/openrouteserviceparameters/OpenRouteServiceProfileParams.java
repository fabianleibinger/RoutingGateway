package com.routing.gateway.routingservices.requests.parameters.openrouteserviceparameters;

public class OpenRouteServiceProfileParams {
    private OpenRouteServiceRestrictions restrictions;
    private OpenRouteServiceWeightings weightings;

    public OpenRouteServiceRestrictions getRestrictions() {
        if (this.restrictions == null) {
            this.restrictions = new OpenRouteServiceRestrictions();
        }
        return restrictions;
    }

    public void setRestrictions(OpenRouteServiceRestrictions restrictions) {
        this.restrictions = restrictions;
    }

    public OpenRouteServiceWeightings getWeightings() {
        if (this.weightings == null) {
            this.weightings = new OpenRouteServiceWeightings();
        }
        return weightings;
    }

    public void setWeightings(OpenRouteServiceWeightings weightings) {
        this.weightings = weightings;
    }
}
