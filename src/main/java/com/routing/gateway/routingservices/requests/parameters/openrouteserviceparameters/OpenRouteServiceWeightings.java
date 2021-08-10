package com.routing.gateway.routingservices.requests.parameters.openrouteserviceparameters;

public class OpenRouteServiceWeightings {
    private Float green;
    private Float quiet;
    private Integer steepness_difficulty;

    public Float getGreen() {
        return green;
    }

    public void setGreen(Float green) {
        this.green = green;
    }

    public Float getQuiet() {
        return quiet;
    }

    public void setQuiet(Float quiet) {
        this.quiet = quiet;
    }

    public Integer getSteepness_difficulty() {
        return steepness_difficulty;
    }

    public void setSteepness_difficulty(Integer steepness_difficulty) {
        this.steepness_difficulty = steepness_difficulty;
    }
}
