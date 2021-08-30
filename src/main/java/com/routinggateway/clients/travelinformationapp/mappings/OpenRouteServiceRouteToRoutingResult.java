package com.routinggateway.clients.travelinformationapp.mappings;

import com.google.maps.model.EncodedPolyline;
import com.google.maps.model.LatLng;
import com.routinggateway.clients.travelinformationapp.controller.models.RoutingResult;
import com.routinggateway.clients.travelinformationapp.controller.models.RoutingResultSegment;
import com.routinggateway.routingservices.responses.openrouteserviceresponse.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Mapper.
 */
public class OpenRouteServiceRouteToRoutingResult {
    public static final Integer DURATION_TRANSFORMATION = 60;
    public static final Integer NUMBER_OF_TRANSFERS = 0;

    /**
     * Mapping.
     *
     * @param route OpenRouteServiceRoute
     * @return routing result
     */
    public RoutingResult map(OpenRouteServiceRoute route) {
        String encodedPolyline = route.getGeometry();
        OpenRouteServiceSummary summary = route.getSummary();
        Double durationInMinutes = summary.getDuration() / DURATION_TRANSFORMATION;
        Double distanceInMeters = summary.getDistance();
        String departureTime = route.getDeparture();
        String arrivalTime = route.getArrival();
        Integer numberOfTransfers = NUMBER_OF_TRANSFERS;
        List<RoutingResultSegment> segments = new ArrayList<>();

        for (OpenRouteServiceSegment segment : route.getSegments()) {
            RoutingResultSegment resultSegment =
                    mapToRoutingResultSegment(segment, encodedPolyline, route.getWarnings());
            segments.add(resultSegment);
        }

        RoutingResult result = new RoutingResult();
        result.setEncodedPolyline(encodedPolyline);
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
     * @param segment OpenRouteServiceSegment
     * @param completePolyline route polyline
     * @param routeWarnings route warnings list
     * @return routing result segment
     */
    private static RoutingResultSegment mapToRoutingResultSegment
            (OpenRouteServiceSegment segment, String completePolyline, List<OpenRouteServiceWarning> routeWarnings) {
        EncodedPolyline encodedPolyline;
        Double durationInMinutes = segment.getDuration() / DURATION_TRANSFORMATION;
        Double distanceInMeters = segment.getDistance();
        List<String> instructions = new ArrayList<>();
        List<String> warnings = new ArrayList<>();
        Double ascent = segment.getAscent();
        Double descent = segment.getDescent();

        EncodedPolyline completeEncodedPolyline = new EncodedPolyline(completePolyline);
        List<LatLng> polyPoints = completeEncodedPolyline.decodePath();
        List<LatLng> resultSegmentPolyline = new ArrayList<>();
        for (OpenRouteServiceStep step : segment.getSteps()) {
            List<Integer> wayPoints = step.getWay_points();
            for (Integer wayPoint : wayPoints) {
                resultSegmentPolyline.add(polyPoints.get(wayPoint));
            }
        }
        encodedPolyline = new EncodedPolyline(resultSegmentPolyline);

        for (OpenRouteServiceStep step : segment.getSteps()) {
            instructions.add(step.getInstruction());
        }
        for (OpenRouteServiceWarning warning : routeWarnings) {
            warnings.add(warning.getMessage());
        }

        RoutingResultSegment resultSegment = new RoutingResultSegment();
        resultSegment.setEncodedPolyline(encodedPolyline.getEncodedPath());
        resultSegment.setDurationInMinutes(durationInMinutes);
        resultSegment.setDistanceInMeters(distanceInMeters);
        resultSegment.setInstructions(instructions);
        resultSegment.setWarnings(warnings);
        resultSegment.setAscent(ascent);
        resultSegment.setDescent(descent);
        return resultSegment;
    }
}
