package com.routinggateway.clients.travelinformationapp.controller;

import com.routinggateway.clients.travelinformationapp.adapters.IRoutingService;
import com.routinggateway.clients.travelinformationapp.adapters.OpenRouteService;
import com.routinggateway.clients.travelinformationapp.adapters.OpenTripPlanner;
import com.routinggateway.clients.travelinformationapp.adapters.Valhalla;
import com.routinggateway.clients.travelinformationapp.controller.models.RoutingRequest;
import com.routinggateway.clients.travelinformationapp.controller.models.RoutingResponse;
import com.routinggateway.exceptions.BadGatewayException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Controller that handles all requests related to routing.
 */
@RestController
@RequestMapping("routing")
public class RoutingController {
    public static final IRoutingService FALLBACK_ROUTING_SERVICE = new OpenRouteService();
    private static IRoutingService routingService;

    /**
     * Returns routes for a routing request or throws BadGatewayException.
     *
     * @param request
     * @return response, that consists of one or more routing results
     */
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public static RoutingResponse receiveRoutes(@RequestBody RoutingRequest request) {
        // Choosing the requested Routing Service
        String routingServiceName = request.getRoutingService();
        if (routingServiceName.equals(new OpenRouteService().getName())) {
            routingService = new OpenRouteService();
        } else if (routingServiceName.equals(new OpenTripPlanner().getName())) {
            routingService = new OpenTripPlanner();
        } else if (routingServiceName.equals(new Valhalla().getName())) {
            routingService = new Valhalla();
        } else {
            // Fallback routing service
            routingService = FALLBACK_ROUTING_SERVICE;
        }

        Optional<RoutingResponse> response = routingService.receiveRoutesForPreference(request);
        if (response.isPresent()) {
            return response.get();
        } else {
            throw new BadGatewayException("Failed to receive Routes");
        }
    }
}
