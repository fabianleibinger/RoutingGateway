package com.routing.gateway.routingservices.requests.parameters.valhallaparameters;

public abstract class ValhallaVehicleBaseCostingOptions {
    //default 5
    private Double maneuver_penalty;
    //default 30
    private Double gate_cost;
    //default 600
    private Double country_crossing_cost;
    //default 0
    private Double country_crossing_penalty;
    //default false
    private Boolean shortest;
    //default 0.5
    private Double use_ferry;

    public Double getManeuver_penalty() {
        return maneuver_penalty;
    }

    public void setManeuver_penalty(Double maneuver_penalty) {
        this.maneuver_penalty = maneuver_penalty;
    }

    public Double getGate_cost() {
        return gate_cost;
    }

    public void setGate_cost(Double gate_cost) {
        this.gate_cost = gate_cost;
    }

    public Double getCountry_crossing_cost() {
        return country_crossing_cost;
    }

    public void setCountry_crossing_cost(Double country_crossing_cost) {
        this.country_crossing_cost = country_crossing_cost;
    }

    public Double getCountry_crossing_penalty() {
        return country_crossing_penalty;
    }

    public void setCountry_crossing_penalty(Double country_crossing_penalty) {
        this.country_crossing_penalty = country_crossing_penalty;
    }

    public Boolean getShortest() {
        return shortest;
    }

    public void setShortest(Boolean shortest) {
        this.shortest = shortest;
    }

    public Double getUse_ferry() {
        return use_ferry;
    }

    public void setUse_ferry(Double use_ferry) {
        this.use_ferry = use_ferry;
    }
}
