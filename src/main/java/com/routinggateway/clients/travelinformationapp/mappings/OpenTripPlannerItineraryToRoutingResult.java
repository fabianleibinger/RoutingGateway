package com.routinggateway.clients.travelinformationapp.mappings;

import com.google.maps.model.EncodedPolyline;
import com.google.maps.model.LatLng;
import com.routinggateway.clients.travelinformationapp.controller.models.RoutingResult;
import com.routinggateway.clients.travelinformationapp.controller.models.RoutingResultSegment;
import com.routinggateway.routingservices.responses.opentripplannerresponse.OpenTripPlannerItinerary;
import com.routinggateway.routingservices.responses.opentripplannerresponse.OpenTripPlannerLeg;
import com.routinggateway.routingservices.responses.opentripplannerresponse.OpenTripPlannerLocalizedAlert;
import com.routinggateway.routingservices.responses.opentripplannerresponse.OpenTripPlannerWalkStep;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Mapper
 */
public class OpenTripPlannerItineraryToRoutingResult {
    public static final Integer DURATION_TRANSFORMATION = 60;
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");

    public static RoutingResult map(OpenTripPlannerItinerary itinerary) {
        EncodedPolyline encodedPolyline;
        Double durationInMinutes = ((double) itinerary.getDuration()) / DURATION_TRANSFORMATION;
        Double distanceInMeters = 0.0;
        String departureTime = String.valueOf(itinerary.getStartTime());
        String arrivalTime = String.valueOf(itinerary.getEndTime());
        Integer numberOfTransfers = itinerary.getTransfers();
        List<RoutingResultSegment> segments = new ArrayList<>();

        List<LatLng> polyline = new ArrayList<>();
        for (OpenTripPlannerLeg leg : itinerary.getLegs()) {
            RoutingResultSegment segment = extractRoutingResultSegment(leg);
            segments.add(segment);
            distanceInMeters += segment.getDistanceInMeters();

            EncodedPolyline googlePolyline = new EncodedPolyline(segment.getEncodedPolyline());
            List<LatLng> polyPoints = googlePolyline.decodePath();
            polyline.addAll(polyPoints);
        }
        encodedPolyline = new EncodedPolyline(polyline);

        RoutingResult route = new RoutingResult();
        route.setEncodedPolyline(encodedPolyline.getEncodedPath());
        route.setDurationInMinutes(durationInMinutes);
        route.setDistanceInMeters(distanceInMeters);
        route.setDepartureTime(departureTime);
        route.setArrivalTime(arrivalTime);
        route.setNumberOfTransfers(numberOfTransfers);
        route.setSegments(segments);
        return route;
    }

    /**
     * Returns a route segment from the openTripPlannerLeg.
     *
     * @param leg openTripPlannerLeg
     * @return RoutingResultSegment
     */
    private static RoutingResultSegment extractRoutingResultSegment(OpenTripPlannerLeg leg) {
        String encodedPolyline = leg.getLegGeometry().getPoints();
        Double durationInMinutes = leg.getDuration() / DURATION_TRANSFORMATION;
        Double distanceInMeters = leg.getDistance();
        String modeOfTransport = leg.getMode();
        List<String> instructions = new ArrayList<>();
        for (OpenTripPlannerWalkStep step : leg.getSteps()) {
            instructions.add
                    (step.getRelativeDirection() + " on " +
                            step.getStreetName() + " in " +
                            DECIMAL_FORMAT.format(step.getDistance()) + " m.");
        }
        List<String> warnings = new ArrayList<>();
        for (OpenTripPlannerLocalizedAlert alert : leg.getAlerts()) {
            warnings.add(alert.getAlertHeaderText());
        }
        String departureTime = String.valueOf(leg.getStartTime());
        String arrivalTime = String.valueOf(leg.getEndTime());

        RoutingResultSegment segment = new RoutingResultSegment();
        segment.setEncodedPolyline(encodedPolyline);
        segment.setDurationInMinutes(durationInMinutes);
        segment.setDistanceInMeters(distanceInMeters);
        segment.setModeOfTransport(modeOfTransport);
        segment.setInstructions(instructions);
        segment.setWarnings(warnings);
        segment.setDepartureTime(departureTime);
        segment.setArrivalTime(arrivalTime);
        return segment;
    }
}
