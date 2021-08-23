package com.routinggateway.clients.travelinformationapp.controller;

import com.google.maps.model.LatLng;
import com.routinggateway.clients.travelinformationapp.adapters.IRoutingService;
import com.routinggateway.clients.travelinformationapp.adapters.OpenRouteService;
import com.routinggateway.clients.travelinformationapp.adapters.OpenTripPlanner;
import com.routinggateway.clients.travelinformationapp.adapters.Valhalla;
import com.routinggateway.clients.travelinformationapp.controller.models.RoutingRequest;
import com.routinggateway.clients.travelinformationapp.controller.models.RoutingResponse;
import com.routinggateway.routingservices.requests.RoutingServiceRequest;
import com.routinggateway.routingservices.requests.StandardRoutingRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Controller that handles all requests related to routing.
 */
@RestController
@RequestMapping("routing")
public class RoutingController {

    /**
     * Returns routes for a routing request.
     *
     * @param request
     * @return response, that consists of one or more routing results
     */
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public static RoutingResponse receiveRoutes(RoutingRequest request) {
        LatLng origin = request.getOrigin();
        LatLng destination = request.getDestination();
        RoutingServiceRequest routingServiceRequest = null;
        IRoutingService routingService;

        String routingServiceName = request.getRoutingService();
        String openRouteServiceName = new OpenRouteService().getName();
        String openTripPlannerName = new OpenTripPlanner().getName();
        String valhallaName = new Valhalla().getName();
        if (routingServiceName.equals(openRouteServiceName)) {
            routingService = new OpenRouteService();
        } else if (routingServiceName.equals(openTripPlannerName)) {
            routingService = new OpenTripPlanner();
        } else if (routingServiceName.equals(valhallaName)) {
            routingService = new Valhalla();
        } else {
            // Fallback routing service
            routingService = new OpenRouteService();
        }

        StandardRoutingRequest standardRoutingRequest =
                new StandardRoutingRequest(origin, destination, routingServiceRequest, routingService);

        return null;
    }
}
