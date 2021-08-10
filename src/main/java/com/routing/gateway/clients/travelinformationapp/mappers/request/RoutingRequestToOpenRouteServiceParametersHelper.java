package com.routing.gateway.clients.travelinformationapp.mappers.request;

import com.google.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class RoutingRequestToOpenRouteServiceParametersHelper {
    public static List<Double[]> toCoordinates(LatLng origin, LatLng destination) {
        List<Double[]> coordinates = new ArrayList<>();
        coordinates.add(new Double[] {origin.lng, origin.lat});
        coordinates.add(new Double[] {destination.lng, destination.lat});
        return coordinates;
    }
}
