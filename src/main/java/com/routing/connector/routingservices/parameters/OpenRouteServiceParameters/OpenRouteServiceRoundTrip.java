package com.routing.connector.routingservices.parameters.OpenRouteServiceParameters;

import com.routing.connector.routingservices.parameters.JsonParameters;

public class OpenRouteServiceRoundTrip extends JsonParameters {
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