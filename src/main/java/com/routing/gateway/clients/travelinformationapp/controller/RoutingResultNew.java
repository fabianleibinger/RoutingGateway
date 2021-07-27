package com.routing.gateway.clients.travelinformationapp.controller;

import com.google.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class RoutingResultNew {
    //Covers the hole trip.
    private List<LatLng> polyline;
    private Double durationInMinutes;
    private Double distanceInMeters;
    private String departureTime;
    private String arrivalTime;
    private Integer numberOfTransfers;
    //Covers segments of the trip.
    private List<RoutingResultSegment> segments;

    public RoutingResultNew
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

    public Integer getNumberOfTransfers() {
        return numberOfTransfers;
    }

    public void setNumberOfTransfers(Integer numberOfTransfers) {
        this.numberOfTransfers = numberOfTransfers;
    }

    public List<RoutingResultSegment> getSegments() {
        if (this.segments == null) {
            this.segments = new ArrayList<>();
        }
        return segments;
    }

    public void setSegments(List<RoutingResultSegment> segments) {
        this.segments = segments;
    }
}
