package com.routing.gateway.routingservices;

import com.routing.gateway.models.Coordinate;

import java.util.List;

public class RoutingResult {

    List<Coordinate> polyline;
    double durationInMinutes;
    double distanceInMeters;

    public RoutingResult(List<Coordinate> polyline, double durationInMinutes, double distanceInMeters) {
        this.polyline = polyline;
        this.durationInMinutes = durationInMinutes;
        this.distanceInMeters = distanceInMeters;
    }

    public List<Coordinate> getPolyline() {
        return polyline;
    }

    public void setPolyline(List<Coordinate> polyline) {
        this.polyline = polyline;
    }

    public double getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(double durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public double getDistanceInMeters() {
        return distanceInMeters;
    }

    public void setDistanceInMeters(double distanceInMeters) {
        this.distanceInMeters = distanceInMeters;
    }
}
