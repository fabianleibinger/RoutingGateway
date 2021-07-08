package com.routing.connector.models;

public record Coordinate(double latitude, double longitude) {

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
