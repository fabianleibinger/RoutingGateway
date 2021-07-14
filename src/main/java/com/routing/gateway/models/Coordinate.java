package com.routing.gateway.models;

/**
 * Coordinate consists of latitude and longitude.
 */
public record Coordinate(double latitude, double longitude) {

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
