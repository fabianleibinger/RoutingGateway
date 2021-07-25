package com.routing.gateway.routingservices.responses.opentripplannerresponse;

import java.util.ArrayList;
import java.util.List;

public class OpenTripPlannerWalkStep {
    private Integer distance;
    private String relativeDirection;
    private String streetName;
    private String absoluteDirection;
    private String exit;
    private Boolean stayOn;
    private Boolean area;
    private Boolean bogusName;
    private Integer lon;
    private Integer lat;
    private List<OpenTripPlannerLocalizedAlert> alerts;
    private String elevation;

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public String getRelativeDirection() {
        return relativeDirection;
    }

    public void setRelativeDirection(String relativeDirection) {
        this.relativeDirection = relativeDirection;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getAbsoluteDirection() {
        return absoluteDirection;
    }

    public void setAbsoluteDirection(String absoluteDirection) {
        this.absoluteDirection = absoluteDirection;
    }

    public String getExit() {
        return exit;
    }

    public void setExit(String exit) {
        this.exit = exit;
    }

    public Boolean getStayOn() {
        return stayOn;
    }

    public void setStayOn(Boolean stayOn) {
        this.stayOn = stayOn;
    }

    public Boolean getArea() {
        return area;
    }

    public void setArea(Boolean area) {
        this.area = area;
    }

    public Boolean getBogusName() {
        return bogusName;
    }

    public void setBogusName(Boolean bogusName) {
        this.bogusName = bogusName;
    }

    public Integer getLon() {
        return lon;
    }

    public void setLon(Integer lon) {
        this.lon = lon;
    }

    public Integer getLat() {
        return lat;
    }

    public void setLat(Integer lat) {
        this.lat = lat;
    }

    public List<OpenTripPlannerLocalizedAlert> getAlerts() {
        if (this.alerts == null) {
            this.alerts = new ArrayList<>();
        }
        return alerts;
    }

    public void setAlerts(List<OpenTripPlannerLocalizedAlert> alerts) {
        this.alerts = alerts;
    }

    public String getElevation() {
        return elevation;
    }

    public void setElevation(String elevation) {
        this.elevation = elevation;
    }
}
