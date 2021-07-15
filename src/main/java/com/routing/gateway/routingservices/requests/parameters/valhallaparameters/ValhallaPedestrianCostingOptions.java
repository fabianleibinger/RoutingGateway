package com.routing.gateway.routingservices.requests.parameters.valhallaparameters;

public class ValhallaPedestrianCostingOptions extends ValhallaVehicleBaseCostingOptions {
    //default 5.1
    public Double walking_speed;
    //default 1.0
    public Double walkway_factor;
    //default 2.0
    public Double alley_factor;
    //default 5.0
    public Double driveway_factor;
    public Double step_penalty;
    //default 0
    public Double use_living_streets;
    //default 0.5
    public Double use_tracks;
    //default 0
    public Double service_penalty;
    //default 1
    public Double service_factor;
    //default 1.0
    public Double max_hiking_difficulty;
    //default 120
    public Double bss_return_cost;
    public Double bss_return_penalty;

    public Double getWalking_speed() {
        return walking_speed;
    }

    public void setWalking_speed(Double walking_speed) {
        this.walking_speed = walking_speed;
    }

    public Double getWalkway_factor() {
        return walkway_factor;
    }

    public void setWalkway_factor(Double walkway_factor) {
        this.walkway_factor = walkway_factor;
    }

    public Double getAlley_factor() {
        return alley_factor;
    }

    public void setAlley_factor(Double alley_factor) {
        this.alley_factor = alley_factor;
    }

    public Double getDriveway_factor() {
        return driveway_factor;
    }

    public void setDriveway_factor(Double driveway_factor) {
        this.driveway_factor = driveway_factor;
    }

    public Double getStep_penalty() {
        return step_penalty;
    }

    public void setStep_penalty(Double step_penalty) {
        this.step_penalty = step_penalty;
    }

    public Double getUse_living_streets() {
        return use_living_streets;
    }

    public void setUse_living_streets(Double use_living_streets) {
        this.use_living_streets = use_living_streets;
    }

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

    public Double getService_factor() {
        return service_factor;
    }

    public void setService_factor(Double service_factor) {
        this.service_factor = service_factor;
    }

    public Double getMax_hiking_difficulty() {
        return max_hiking_difficulty;
    }

    public void setMax_hiking_difficulty(Double max_hiking_difficulty) {
        this.max_hiking_difficulty = max_hiking_difficulty;
    }

    public Double getBss_return_cost() {
        return bss_return_cost;
    }

    public void setBss_return_cost(Double bss_return_cost) {
        this.bss_return_cost = bss_return_cost;
    }

    public Double getBss_return_penalty() {
        return bss_return_penalty;
    }

    public void setBss_return_penalty(Double bss_return_penalty) {
        this.bss_return_penalty = bss_return_penalty;
    }
}
