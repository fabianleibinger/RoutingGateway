package com.routing.gateway.routingservices.requests.parameters.valhallaparameters;

public class ValhallaMotorScooterCostingOptions extends ValhallaVehicleBaseCostingOptions {
    //default 0.5
    public Double use_tracks;
    //default 15
    public Double service_penalty;
    //default 0.1
    public Double use_living_streets;
    //default 0.5
    public Double use_hills;
    //default 0.5
    public Double use_primary;
    //default 45
    public Double top_speed;

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

    public Double getUse_hills() {
        return use_hills;
    }

    public void setUse_hills(Double use_hills) {
        this.use_hills = use_hills;
    }

    public Double getUse_primary() {
        return use_primary;
    }

    public void setUse_primary(Double use_primary) {
        this.use_primary = use_primary;
    }

    public Double getTop_speed() {
        return top_speed;
    }

    public void setTop_speed(Double top_speed) {
        this.top_speed = top_speed;
    }
}
