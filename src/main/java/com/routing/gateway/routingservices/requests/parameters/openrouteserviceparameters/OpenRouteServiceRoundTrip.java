package com.routing.gateway.routingservices.requests.parameters.openrouteserviceparameters;

public class OpenRouteServiceRoundTrip {
    private Float length;
    private Integer points;
    private Integer seed;

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getSeed() {
        return seed;
    }

    public void setSeed(Integer seed) {
        this.seed = seed;
    }
}
