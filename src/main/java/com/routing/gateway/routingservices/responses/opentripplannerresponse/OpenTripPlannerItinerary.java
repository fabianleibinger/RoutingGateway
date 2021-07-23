package com.routing.gateway.routingservices.responses.opentripplannerresponse;

import java.util.ArrayList;
import java.util.List;

public class OpenTripPlannerItinerary {
    private Integer duration;
    private Integer startTime;
    private Integer endTime;
    private Integer walkTime;
    private Integer transitTime;
    private Integer waitingTime;
    private Integer walkDistance;
    private Boolean walkLimitExceeded;
    private Integer elevationLost;
    private Integer elevationGained;
    private Integer transfers;
    private Object fare;
    private List<OpenTripPlannerLeg> leg;
    private Boolean tooSloped;

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public Integer getWalkTime() {
        return walkTime;
    }

    public void setWalkTime(Integer walkTime) {
        this.walkTime = walkTime;
    }

    public Integer getTransitTime() {
        return transitTime;
    }

    public void setTransitTime(Integer transitTime) {
        this.transitTime = transitTime;
    }

    public Integer getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(Integer waitingTime) {
        this.waitingTime = waitingTime;
    }

    public Integer getWalkDistance() {
        return walkDistance;
    }

    public void setWalkDistance(Integer walkDistance) {
        this.walkDistance = walkDistance;
    }

    public Boolean getWalkLimitExceeded() {
        return walkLimitExceeded;
    }

    public void setWalkLimitExceeded(Boolean walkLimitExceeded) {
        this.walkLimitExceeded = walkLimitExceeded;
    }

    public Integer getElevationLost() {
        return elevationLost;
    }

    public void setElevationLost(Integer elevationLost) {
        this.elevationLost = elevationLost;
    }

    public Integer getElevationGained() {
        return elevationGained;
    }

    public void setElevationGained(Integer elevationGained) {
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

    public List<OpenTripPlannerLeg> getLeg() {
        if (this.leg == null) {
            this.leg = new ArrayList<>();
        }
        return leg;
    }

    public void setLeg(List<OpenTripPlannerLeg> leg) {
        this.leg = leg;
    }

    public Boolean getTooSloped() {
        return tooSloped;
    }

    public void setTooSloped(Boolean tooSloped) {
        this.tooSloped = tooSloped;
    }
}
