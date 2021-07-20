package com.routing.gateway.routingservices;

import com.routing.gateway.models.Coordinate;

import java.util.List;

public class RoutingResult {

    List<Coordinate> polyline;
    Double durationInMinutes;
    Double distanceInMeters;
    List<String> instructions;
    List<String> warnings;
    String arrivalTime;
    String departureTime;
    Double ascent;
    Double descent;

    public RoutingResult
            (List<Coordinate> polyline, Double durationInMinutes, Double distanceInMeters, List<String> instructions) {
        this.polyline = polyline;
        this.durationInMinutes = durationInMinutes;
        this.distanceInMeters = distanceInMeters;
        this.instructions = instructions;
    }

    public List<Coordinate> getPolyline() {
        return polyline;
    }

    public void setPolyline(List<Coordinate> polyline) {
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
        return instructions;
    }

    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }

    public List<String> getWarnings() {
        return warnings;
    }

    public void setWarnings(List<String> warnings) {
        this.warnings = warnings;
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
