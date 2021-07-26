package com.routing.gateway.routingservices.responses.valhallaresponse;

import java.util.ArrayList;
import java.util.List;

public class ValhallaLeg {
    private String shape;
    private ValhallaSummary summary;
    private List<ValhallaManeuver> maneuvers;

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public ValhallaSummary getSummary() {
        if (this.summary == null) {
            this.summary = new ValhallaSummary();
        }
        return summary;
    }

    public void setSummary(ValhallaSummary summary) {
        this.summary = summary;
    }

    public List<ValhallaManeuver> getManeuvers() {
        if (this.maneuvers == null) {
            this.maneuvers = new ArrayList<>();
        }
        return maneuvers;
    }

    public void setManeuvers(List<ValhallaManeuver> maneuvers) {
        this.maneuvers = maneuvers;
    }
}
