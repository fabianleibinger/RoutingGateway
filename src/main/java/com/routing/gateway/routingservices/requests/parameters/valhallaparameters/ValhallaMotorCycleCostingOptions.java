package com.routing.gateway.routingservices.requests.parameters.valhallaparameters;

public class ValhallaMotorCycleCostingOptions extends ValhallaVehicleBaseCostingOptions {
    //default 0.5
    public Double use_tracks;
    //default 15
    public Double service_penalty;
    //default 0.1
    public Double use_living_streets;
    //default 0.0
    public Double use_trails;

    public Double getUse_tracks() {
        return use_tracks;
    }

    public void setUse_tracks(Double use_tracks) {
        this.use_tracks = use_tracks;
    }

    public Double getService_penalty() {
        return service_penalty;
    }

    public void setService_penalty(Double service_penalty) {
        this.service_penalty = service_penalty;
    }

    public Double getUse_living_streets() {
        return use_living_streets;
    }

    public void setUse_living_streets(Double use_living_streets) {
        this.use_living_streets = use_living_streets;
    }

    public Double getUse_trails() {
        return use_trails;
    }

    public void setUse_trails(Double use_trails) {
        this.use_trails = use_trails;
    }
}
