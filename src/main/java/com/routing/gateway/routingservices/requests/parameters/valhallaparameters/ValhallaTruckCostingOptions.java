package com.routing.gateway.routingservices.requests.parameters.valhallaparameters;

public class ValhallaTruckCostingOptions {
    //default 15
    public Double toll_booth_cost;
    //default 300
    public Double ferry_cost;
    //default 1.0
    public Double use_highways;
    //default 0.5
    public Double use_tolls;
    //default 0.1
    public Double use_living_streets;
    //default 0
    public Double use_tracks;
    //default 1
    public Double service_factor;
    //default 140
    public Double top_speed;
    public Boolean ignore_closures;
    //default 9.0
    public Double closure_factor;
    //default 15
    public Double service_penalty;
    public Double height;
    public Double width;
    public Double length;
    public Double weight;
    public Double axle_load;
    public Double hazmat;

    public Double getToll_booth_cost() {
        return toll_booth_cost;
    }

    public void setToll_booth_cost(Double toll_booth_cost) {
        this.toll_booth_cost = toll_booth_cost;
    }

    public Double getFerry_cost() {
        return ferry_cost;
    }

    public void setFerry_cost(Double ferry_cost) {
        this.ferry_cost = ferry_cost;
    }

    public Double getUse_highways() {
        return use_highways;
    }

    public void setUse_highways(Double use_highways) {
        this.use_highways = use_highways;
    }

    public Double getUse_tolls() {
        return use_tolls;
    }

    public void setUse_tolls(Double use_tolls) {
        this.use_tolls = use_tolls;
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

    public Double getService_factor() {
        return service_factor;
    }

    public void setService_factor(Double service_factor) {
        this.service_factor = service_factor;
    }

    public Double getTop_speed() {
        return top_speed;
    }

    public void setTop_speed(Double top_speed) {
        this.top_speed = top_speed;
    }

    public Boolean isIgnore_closures() {
        return ignore_closures;
    }

    public void setIgnore_closures(Boolean ignore_closures) {
        this.ignore_closures = ignore_closures;
    }

    public Double getClosure_factor() {
        return closure_factor;
    }

    public void setClosure_factor(Double closure_factor) {
        this.closure_factor = closure_factor;
    }

    public Double getService_penalty() {
        return service_penalty;
    }

    public void setService_penalty(Double service_penalty) {
        this.service_penalty = service_penalty;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getAxle_load() {
        return axle_load;
    }

    public void setAxle_load(Double axle_load) {
        this.axle_load = axle_load;
    }

    public Double getHazmat() {
        return hazmat;
    }

    public void setHazmat(Double hazmat) {
        this.hazmat = hazmat;
    }
}
