package com.routinggateway.clients.travelinformationapp.mappings.nominhelpers;

import com.routinggateway.clients.travelinformationapp.controller.models.LatLng;
import com.routinggateway.clients.travelinformationapp.controller.models.preferences.ModePreferences;
import com.routinggateway.routingservices.requests.parameters.valhallaparameters.ValhallaLocation;

import java.util.ArrayList;
import java.util.List;

public class HelperRoutingRequestToValhallaParameters {
    public static List<ValhallaLocation> toLocations(LatLng origin, LatLng destination) {
        List<ValhallaLocation> locations = new ArrayList<>();

        ValhallaLocation startLocation = new ValhallaLocation();
        startLocation.setLat(origin.getLat());
        startLocation.setLon(origin.getLng());
        locations.add(startLocation);

        ValhallaLocation endLocation = new ValhallaLocation();
        endLocation.setLat(destination.getLat());
        endLocation.setLon(destination.getLng());
        locations.add(endLocation);

        return locations;
    }
}
