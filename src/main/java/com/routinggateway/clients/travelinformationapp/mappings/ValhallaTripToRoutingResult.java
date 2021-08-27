package com.routinggateway.clients.travelinformationapp.mappings;

import com.google.maps.model.EncodedPolyline;
import com.google.maps.model.LatLng;
import com.routinggateway.clients.travelinformationapp.controller.models.RoutingResult;
import com.routinggateway.clients.travelinformationapp.controller.models.RoutingResultSegment;
import com.routinggateway.routingservices.responses.valhallaresponse.ValhallaLeg;
import com.routinggateway.routingservices.responses.valhallaresponse.ValhallaManeuver;
import com.routinggateway.routingservices.responses.valhallaresponse.ValhallaSummary;
import com.routinggateway.routingservices.responses.valhallaresponse.ValhallaTrip;

import java.util.ArrayList;
import java.util.List;

/**
 * Mapper.
 */
public class ValhallaTripToRoutingResult {
    public static final Integer DISTANCE_TRANSFORMATION = 1000;

    /**
     * Mapping.
     *
     * @param trip ValhallaTrip
     * @return routing result
     */
    public static RoutingResult map(ValhallaTrip trip) {
        EncodedPolyline encodedPolyline;
        ValhallaSummary summary = trip.getSummary();
        Double durationInMinutes = summary.getTime();
        Double distanceInMeters = summary.getLength() * DISTANCE_TRANSFORMATION;
        String departureTime = "";
        String arrivalTime = "";
        // TODO make work
        Integer numberOfTransfers = 0;
        List<RoutingResultSegment> segments = new ArrayList<>();

        List<LatLng> polyline = new ArrayList<>();
        List<ValhallaLeg> legs = trip.getLegs();
        for (int i = 0; i < legs.size(); i++) {
            RoutingResultSegment segment = mapToRoutingResultSegment(legs.get(i));
            segments.add(segment);

            EncodedPolyline googlePolyline = new EncodedPolyline(segment.getEncodedPolyline());
            List<LatLng> polyPoints = googlePolyline.decodePath();
            polyline.addAll(polyPoints);
            if (i == 0) {
                departureTime = segment.getDepartureTime();
            }
            if (i == (legs.size() - 1) ) {
                arrivalTime = segment.getArrivalTime();
            }
        }
        encodedPolyline = new EncodedPolyline(polyline);

        RoutingResult result = new RoutingResult();
        result.setEncodedPolyline(encodedPolyline.getEncodedPath());
        result.setDurationInMinutes(durationInMinutes);
        result.setDistanceInMeters(distanceInMeters);
        result.setDepartureTime(departureTime);
        result.setArrivalTime(arrivalTime);
        result.setNumberOfTransfers(numberOfTransfers);
        result.setSegments(segments);
        return result;
    }

    /**
     * Inner Mapping.
     *
     * @param leg ValhallaLeg
     * @return routing result segment
     */
    private static RoutingResultSegment mapToRoutingResultSegment(ValhallaLeg leg) {
        String encodedPolyline = leg.getShape();
        ValhallaSummary summary = leg.getSummary();
        Double durationInMinutes = summary.getTime();
        Double distanceInMeters = summary.getLength() * DISTANCE_TRANSFORMATION;
        String modeOfTransport = "";
        List<String> instructions = new ArrayList<>();
        String departureTime = "";
        String arrivalTime = "";

        List<ValhallaManeuver> maneuvers = leg.getManeuvers();
        for (int i = 0; i < maneuvers.size(); i++) {
            modeOfTransport += maneuvers.get(i).getTravel_mode();
            instructions.add(maneuvers.get(i).getInstruction());
            if (i == 0) {
                departureTime = String.valueOf(maneuvers.get(i).getTime());
            }
            if (i == (maneuvers.size() - 1) ) {
                arrivalTime = String.valueOf(maneuvers.get(i).getTime());
            }
        }

        RoutingResultSegment segment = new RoutingResultSegment();
        segment.setEncodedPolyline(encodedPolyline);
        segment.setDurationInMinutes(durationInMinutes);
        segment.setDistanceInMeters(distanceInMeters);
        segment.setModeOfTransport(modeOfTransport);
        segment.setInstructions(instructions);
        segment.setDepartureTime(departureTime);
        segment.setArrivalTime(arrivalTime);
        return segment;
    }
}
