package com.routing.gateway.clients.travelinformationapp.controller;

import com.google.maps.model.LatLng;

import java.util.List;

/**
 * A segment of a route corresponding to one mode of transport.
 */
public class RoutingResultSegment {
    private List<LatLng> polyline;
    private Double durationInMinutes;
    private Double distanceInMeters;
    private String modeOfTransport;
    private List<String> instructions;
    private List<String> warnings;
    private String departureTime;
    private String arrivalTime;
    private Double ascent;
    private Double descent;

    public RoutingResultSegment
            (List<LatLng> polyline, Double durationInMinutes, Double distanceInMeters, String modeOfTransport) {
        this.polyline = polyline;
        this.durationInMinutes = durationInMinutes;
        this.distanceInMeters = distanceInMeters;
        this.modeOfTransport = modeOfTransport;
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

    public String getModeOfTransport() {
        return modeOfTransport;
    }

    public void setModeOfTransport(String modeOfTransport) {
        this.modeOfTransport = modeOfTransport;
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

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
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
