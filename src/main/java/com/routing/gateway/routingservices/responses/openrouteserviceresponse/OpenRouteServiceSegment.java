package com.routing.gateway.routingservices.responses.openrouteserviceresponse;

import java.util.ArrayList;
import java.util.List;

public class OpenRouteServiceSegment {
    private Double ascent;
    private Double avgspeed;
    private Double descent;
    private Double detourfactor;
    private Double distance;
    private Double duration;
    private Double percentage;
    private List<OpenRouteServiceStep> steps;

    public Double getAscent() {
        return ascent;
    }

    public void setAscent(Double ascent) {
        this.ascent = ascent;
    }

    public Double getAvgspeed() {
        return avgspeed;
    }

    public void setAvgspeed(Double avgspeed) {
        this.avgspeed = avgspeed;
    }

    public Double getDescent() {
        return descent;
    }

    public void setDescent(Double descent) {
        this.descent = descent;
    }

    public Double getDetourfactor() {
        return detourfactor;
    }

    public void setDetourfactor(Double detourfactor) {
        this.detourfactor = detourfactor;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public List<OpenRouteServiceStep> getSteps() {
        if (this.steps == null) {
            this.steps = new ArrayList<>();
        }
        return steps;
    }

    public void setSteps(List<OpenRouteServiceStep> steps) {
        this.steps = steps;
    }
}
