package com.routinggateway.clients.travelinformationapp.mappings.nominhelpers;

import com.routinggateway.clients.travelinformationapp.controller.models.LatLng;

import java.util.ArrayList;
import java.util.List;

public class HelperRoutingRequestToOpenRouteServiceParameters {
    public static List<Double[]> toCoordinates(LatLng origin, LatLng destination) {
        List<Double[]> coordinates = new ArrayList<>();
        coordinates.add(new Double[] {origin.getLng(), origin.getLat()});
        coordinates.add(new Double[] {destination.getLng(), destination.getLat()});
        return coordinates;
    }
}
