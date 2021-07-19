package com.routing.gateway.routingservices.responses.openrouteserviceresponse;

import java.util.ArrayList;
import java.util.List;

public class OpenRouteServiceManeuver {
    private Integer bearing_after;
    private Integer bearing_before;
    private List<Double> location;

    public Integer getBearing_after() {
        return bearing_after;
    }

    public void setBearing_after(Integer bearing_after) {
        this.bearing_after = bearing_after;
    }

    public Integer getBearing_before() {
        return bearing_before;
    }

    public void setBearing_before(Integer bearing_before) {
        this.bearing_before = bearing_before;
    }

    public List<Double> getLocation() {
        if (this.location == null) {
            this.location = new ArrayList<>();
        }
        return location;
    }

    public void setLocation(List<Double> location) {
        this.location = location;
    }
}
