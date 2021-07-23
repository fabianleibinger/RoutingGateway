package com.routing.gateway.routingservices;

import com.google.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

/**
 * Route expected by clients of this service.
 */
public class RoutingResult {

    private List<LatLng> polyline;
    private Double durationInMinutes;
    private Double distanceInMeters;
    private List<String> instructions;
    private List<String> warnings;
    private String date;
    private String arrivalTime;
    private String departureTime;
    private Integer numberOfChanges;
    private Double ascent;
    private Double descent;

    public RoutingResult
            (List<LatLng> polyline, Double durationInMinutes, Double distanceInMeters) {
        this.polyline = polyline;
        this.durationInMinutes = durationInMinutes;
        this.distanceInMeters = distanceInMeters;
    }

    public List<LatLng> getPolyline() {
        return polyline;
    }

    public void setPolyline(List<LatLng> polyline) {
        this.polyline = polyline;
    }

    public Double getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(Double durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public Double getDistanceInMeters() {
        return distanceInMeters;
    }

    public void setDistanceInMeters(Double distanceInMeters) {
        this.distanceInMeters = distanceInMeters;
    }

    public List<String> getInstructions() {
        if (this.instructions == null) {
            this.instructions = new ArrayList<>();
        }
        return instructions;
    }

    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }

    public List<String> getWarnings() {
        if (this.warnings == null) {
            this.warnings = new ArrayList<>();
        }
        return warnings;
    }

    public void setWarnings(List<String> warnings) {
        this.warnings = warnings;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public Integer getNumberOfChanges() {
        return numberOfChanges;
    }

    public void setNumberOfChanges(Integer numberOfChanges) {
        this.numberOfChanges = numberOfChanges;
    }

    public Double getAscent() {
        return ascent;
    }

    public void setAscent(Double ascent) {
        this.ascent = ascent;
    }

    public Double getDescent() {
        return descent;
    }

    public void setDescent(Double descent) {
        this.descent = descent;
    }
}
