package com.routinggateway.routingservices.responses.opentripplannerresponse;

import java.util.ArrayList;
import java.util.List;

public class OpenTripPlannerItinerary {
    private Double duration;
    private Double startTime;
    private Double endTime;
    private Double walkTime;
    private Double transitTime;
    private Double waitingTime;
    private Double walkDistance;
    private Boolean walkLimitExceeded;
    private Double elevationLost;
    private Double elevationGained;
    private Integer transfers;
    private Object fare;
    private List<OpenTripPlannerLeg> legs;
    private Boolean tooSloped;

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Double getStartTime() {
        return startTime;
    }

    public void setStartTime(Double startTime) {
        this.startTime = startTime;
    }

    public Double getEndTime() {
        return endTime;
    }

    public void setEndTime(Double endTime) {
        this.endTime = endTime;
    }

    public Double getWalkTime() {
        return walkTime;
    }

    public void setWalkTime(Double walkTime) {
        this.walkTime = walkTime;
    }

    public Double getTransitTime() {
        return transitTime;
    }

    public void setTransitTime(Double transitTime) {
        this.transitTime = transitTime;
    }

    public Double getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(Double waitingTime) {
        this.waitingTime = waitingTime;
    }

    public Double getWalkDistance() {
        return walkDistance;
    }

    public void setWalkDistance(Double walkDistance) {
        this.walkDistance = walkDistance;
    }

    public Boolean getWalkLimitExceeded() {
        return walkLimitExceeded;
    }

    public void setWalkLimitExceeded(Boolean walkLimitExceeded) {
        this.walkLimitExceeded = walkLimitExceeded;
    }

    public Double getElevationLost() {
        return elevationLost;
    }

    public void setElevationLost(Double elevationLost) {
        this.elevationLost = elevationLost;
    }

    public Double getElevationGained() {
        return elevationGained;
    }

    public void setElevationGained(Double elevationGained) {
        this.elevationGained = elevationGained;
    }

    public Integer getTransfers() {
        return transfers;
    }

    public void setTransfers(Integer transfers) {
        this.transfers = transfers;
    }

    public Object getFare() {
        if (this.fare == null) {
            this.fare = new Object();
        }
        return fare;
    }

    public void setFare(Object fare) {
        this.fare = fare;
    }

    public List<OpenTripPlannerLeg> getLegs() {
        if (this.legs == null) {
            this.legs = new ArrayList<>();
        }
        return legs;
    }

    public void setLegs(List<OpenTripPlannerLeg> legs) {
        this.legs = legs;
    }

    public Boolean getTooSloped() {
        return tooSloped;
    }

    public void setTooSloped(Boolean tooSloped) {
        this.tooSloped = tooSloped;
    }
}
