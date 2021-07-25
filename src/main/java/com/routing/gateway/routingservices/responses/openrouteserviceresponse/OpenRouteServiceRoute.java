package com.routing.gateway.routingservices.responses.openrouteserviceresponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenRouteServiceRoute {
    private String arrival;
    private List<Double> bbox;
    private String departure;
    private Map<String, OpenRouteServiceExtra> extras;
    private String geometry;
    private List<OpenRouteServiceSegment> segments;
    private OpenRouteServiceSummary summary;
    private List<OpenRouteServiceWarning> warnings;
    private List<Integer> way_points;

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public List<Double> getBbox() {
        if (this.bbox == null) {
            this.bbox = new ArrayList<>();
        }
        return bbox;
    }

    public void setBbox(List<Double> bbox) {
        this.bbox = bbox;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public Map<String, OpenRouteServiceExtra> getExtras() {
        if (this.extras == null) {
            this.extras = new HashMap<>();
        }
        return extras;
    }

    public void setExtras(Map<String, OpenRouteServiceExtra> extras) {
        this.extras = extras;
    }

    public List<OpenRouteServiceSegment> getSegments() {
        if (this.segments == null) {
            this.segments = new ArrayList<>();
        }
        return segments;
    }

    public String getGeometry() {
        return geometry;
    }

    public void setGeometry(String geometry) {
        this.geometry = geometry;
    }

    public void setSegments(List<OpenRouteServiceSegment> segments) {
        this.segments = segments;
    }

    public OpenRouteServiceSummary getSummary() {
        if (this.summary == null) {
            this.summary = new OpenRouteServiceSummary();
        }
        return summary;
    }

    public void setSummary(OpenRouteServiceSummary summary) {
        this.summary = summary;
    }

    public List<OpenRouteServiceWarning> getWarnings() {
        if (this.warnings == null) {
            this.warnings = new ArrayList<>();
        }
        return warnings;
    }

    public void setWarnings(List<OpenRouteServiceWarning> warnings) {
        this.warnings = warnings;
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
