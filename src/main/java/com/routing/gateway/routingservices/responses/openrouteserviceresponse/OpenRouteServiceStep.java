package com.routing.gateway.routingservices.responses.openrouteserviceresponse;

import java.util.ArrayList;
import java.util.List;

public class OpenRouteServiceStep {
    private Double distance;
    private Double duration;
    private List<Integer> exit_bearings;
    private Integer exit_number;
    private String instruction;
    private OpenRouteServiceManeuver maneuver;
    private String name;
    private Integer type;
    private List<Integer> way_points;

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

    public List<Integer> getExit_bearings() {
        if (this.exit_bearings == null) {
            this.exit_bearings = new ArrayList<>();
        }
        return exit_bearings;
    }

    public void setExit_bearings(List<Integer> exit_bearings) {
        this.exit_bearings = exit_bearings;
    }

    public Integer getExit_number() {
        return exit_number;
    }

    public void setExit_number(Integer exit_number) {
        this.exit_number = exit_number;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public OpenRouteServiceManeuver getManeuver() {
        if (this.maneuver == null) {
            this.maneuver = new OpenRouteServiceManeuver();
        }
        return maneuver;
    }

    public void setManeuver(OpenRouteServiceManeuver maneuver) {
        this.maneuver = maneuver;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<Integer> getWay_points() {
        if (this.way_points == null) {
            this.way_points = new ArrayList<>();
        }
        return way_points;
    }

    public void setWay_points(List<Integer> way_points) {
        this.way_points = way_points;
    }
}
