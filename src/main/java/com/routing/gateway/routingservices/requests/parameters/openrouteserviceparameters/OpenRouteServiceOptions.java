package com.routing.gateway.routingservices.requests.parameters.openrouteserviceparameters;

import java.util.ArrayList;
import java.util.List;

public class OpenRouteServiceOptions{
    private String avoid_borders;
    private List<Integer> avoid_countries;
    private List<String> avoid_features;
    private String avoid_polygons;
    private OpenRouteServiceProfileParams profile_params;
    private OpenRouteServiceRoundTrip round_trip;
    //default "hgv"
    private String vehicle_type;

    public String getAvoidBorders() {
        return avoid_borders;
    }

    public void setAvoidBorders(String avoid_borders) {
        this.avoid_borders = avoid_borders;
    }

    public List<Integer> getAvoidCountries() {
        if (this.avoid_countries == null) {
            this.avoid_countries = new ArrayList<>();
        }
        return avoid_countries;
    }

    public void setAvoidCountries(List<Integer> avoid_countries) {
        this.avoid_countries = avoid_countries;
    }

    public List<String> getAvoidFeatures() {
        if (this.avoid_features == null) {
            this.avoid_features = new ArrayList<>();
        }
        return avoid_features;
    }

    public void setAvoidFeatures(List<String> avoid_features) {
        this.avoid_features = avoid_features;
    }

    public String getAvoidPolygons() {
        return avoid_polygons;
    }

    public void setAvoidPolygons(String avoid_polygons) {
        this.avoid_polygons = avoid_polygons;
    }

    public OpenRouteServiceProfileParams getProfile_params() {
        if (this.profile_params == null) {
            this.profile_params = new OpenRouteServiceProfileParams();
        }
        return profile_params;
    }

    public void setProfileParams(OpenRouteServiceProfileParams profile_params) {
        this.profile_params = profile_params;
    }

    public OpenRouteServiceRoundTrip getRoundTrip() {
        if (this.round_trip == null) {
            this.round_trip = new OpenRouteServiceRoundTrip();
        }
        return round_trip;
    }

    public void setRoundTrip(OpenRouteServiceRoundTrip round_trip) {
        this.round_trip = round_trip;
    }

    public String getVehicleType() {
        return vehicle_type;
    }

    public void setVehicleType(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }
}
