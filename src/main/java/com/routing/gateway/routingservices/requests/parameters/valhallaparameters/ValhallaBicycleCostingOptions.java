package com.routing.gateway.routingservices.requests.parameters.valhallaparameters;

public class ValhallaBicycleCostingOptions extends ValhallaVehicleBaseCostingOptions {
    public String bicycle_type = "hybrid";
    public Double cycling_speed;
    //default 0.5
    public Double use_roads;
    //default 0.5
    public Double use_hills;
    //default 0.25
    public Double avoid_bad_surfaces;
    //default 120
    public Double bss_return_cost;
    public Double bss_return_penalty;
    //default 0.5
    public Double use_living_streets;

    public String getBicycle_type() {
        return bicycle_type;
    }

    public void setBicycle_type(String bicycle_type) {
        this.bicycle_type = bicycle_type;
    }

    public Double getCycling_speed() {
        return cycling_speed;
    }

    public void setCycling_speed(Double cycling_speed) {
        this.cycling_speed = cycling_speed;
    }

    public Double getUse_roads() {
        return use_roads;
    }

    public void setUse_roads(Double use_roads) {
        this.use_roads = use_roads;
    }

    public Double getUse_hills() {
        return use_hills;
    }

    public void setUse_hills(Double use_hills) {
        this.use_hills = use_hills;
    }

    public Double getAvoid_bad_surfaces() {
        return avoid_bad_surfaces;
    }

    public void setAvoid_bad_surfaces(Double avoid_bad_surfaces) {
        this.avoid_bad_surfaces = avoid_bad_surfaces;
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

    public Double getUse_living_streets() {
        return use_living_streets;
    }

    public void setUse_living_streets(Double use_living_streets) {
        this.use_living_streets = use_living_streets;
    }
}
