package com.routing.gateway.clients.travelinformationapp.controller;

import com.routing.gateway.clients.travelinformationapp.adapters.OpenRouteService;
import com.routing.gateway.clients.travelinformationapp.adapters.OpenTripPlanner;
import com.routing.gateway.clients.travelinformationapp.adapters.Valhalla;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller for a travel information application that handles all requests related to routing.
 */
@RestController
@RequestMapping("routing")
public class RoutingController {
    /**
     * Returns the names of the available routing services.
     *
     * @return nameList
     */
    @GetMapping(path = "services")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public static List<String> getRoutingServices() {
        OpenRouteService openRouteService = new OpenRouteService();
        OpenTripPlanner openTripPlanner = new OpenTripPlanner();
        Valhalla valhalla = new Valhalla();

        List<String> routingServices = new ArrayList<>();
        routingServices.add(openRouteService.getName());
        routingServices.add(openTripPlanner.getName());
        routingServices.add(valhalla.getName());
        return routingServices;
    }
}
