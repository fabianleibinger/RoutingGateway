package com.routinggateway.clients.travelinformationapp.mappings;

import com.google.maps.model.EncodedPolyline;
import com.google.maps.model.LatLng;
import com.routinggateway.clients.travelinformationapp.controller.models.RoutingResult;
import com.routinggateway.clients.travelinformationapp.controller.models.RoutingResultSegment;
import com.routinggateway.routingservices.responses.openrouteserviceresponse.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Mapper
 */
public class OpenRouteServiceRouteToRoutingResult {
    public static final Integer DURATION_TRANSFORMATION = 60;
    public static final Integer NUMBER_OF_TRANSFERS = 0;

    public static RoutingResult map(OpenRouteServiceRoute route) {
        RoutingResult result = new RoutingResult();

        result.setEncodedPolyline(route.getGeometry());
        result.setDepartureTime(route.getDeparture());
        result.setArrivalTime(route.getArrival());

        OpenRouteServiceSummary summary = route.getSummary();
        result.setDistanceInMeters(summary.getDistance());
        result.setDurationInMinutes(summary.getDuration() / DURATION_TRANSFORMATION);
        result.setNumberOfTransfers(NUMBER_OF_TRANSFERS);

        for (OpenRouteServiceSegment segment : route.getSegments()) {
            RoutingResultSegment resultSegment = new RoutingResultSegment();

            // ResultSegment encodedPolyline
            EncodedPolyline encodedPolyline = new EncodedPolyline(route.getGeometry());
            List<LatLng> completePolyline = encodedPolyline.decodePath();
            List<LatLng> resultSegmentPolyline = new ArrayList<>();
            for (OpenRouteServiceStep step : segment.getSteps()) {
                List<Integer> wayPoints = step.getWay_points();
                for (Integer wayPoint : wayPoints) {
                    resultSegmentPolyline.add(completePolyline.get(wayPoint));
                }
            }
            EncodedPolyline polyline = new EncodedPolyline(resultSegmentPolyline);
            resultSegment.setEncodedPolyline(polyline.getEncodedPath());

            resultSegment.setDurationInMinutes(segment.getDuration() / DURATION_TRANSFORMATION);
            resultSegment.setDistanceInMeters(segment.getDistance());
            for (OpenRouteServiceStep step : segment.getSteps()) {
                resultSegment.getInstructions().add(step.getInstruction());
            }
            for (OpenRouteServiceWarning warning : route.getWarnings()) {
                resultSegment.getWarnings().add(warning.getMessage());
            }
            resultSegment.setAscent(segment.getAscent());
            resultSegment.setDescent(segment.getDescent());

            result.getSegments().add(resultSegment);
        }

        return result;
    }
}
