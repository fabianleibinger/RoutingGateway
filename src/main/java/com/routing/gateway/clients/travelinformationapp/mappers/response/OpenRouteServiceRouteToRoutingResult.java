package com.routing.gateway.clients.travelinformationapp.mappers.response;

import com.google.maps.model.EncodedPolyline;
import com.google.maps.model.LatLng;
import com.routing.gateway.clients.travelinformationapp.controller.RoutingResultNew;
import com.routing.gateway.clients.travelinformationapp.controller.RoutingResultSegmentNew;
import com.routing.gateway.routingservices.responses.openrouteserviceresponse.*;
import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Maps;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface OpenRouteServiceRouteToRoutingResult {
    @Maps(withCustom = OpenRouteServiceRouteMapper.class)
    RoutingResultNew asRoutingResult(OpenRouteServiceRoute route);

    class OpenRouteServiceRouteMapper{
        private static final Integer DURATION_TRANSFORMATION = 60;

        public RoutingResultNew asRoutingResult(OpenRouteServiceRoute route) {
            RoutingResultNew result = new RoutingResultNew();

            result.setEncodedPolyline(route.getGeometry());
            result.setArrivalTime(route.getArrival());
            result.setDepartureTime(route.getDeparture());

            OpenRouteServiceSummary summary = route.getSummary();
            result.setDistanceInMeters(summary.getDistance());
            result.setDurationInMinutes(summary.getDuration() / DURATION_TRANSFORMATION);

            for (OpenRouteServiceSegment segment : route.getSegments()) {
                RoutingResultSegmentNew resultSegment = new RoutingResultSegmentNew();

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
}
