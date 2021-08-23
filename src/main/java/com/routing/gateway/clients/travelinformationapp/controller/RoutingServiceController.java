package com.routing.gateway.clients.travelinformationapp.controller;

import com.routing.gateway.clients.travelinformationapp.adapters.OpenRouteService;
import com.routing.gateway.clients.travelinformationapp.adapters.OpenTripPlanner;
import com.routing.gateway.clients.travelinformationapp.adapters.Valhalla;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller that handles all requests related to routing services.
 */
@RestController
@RequestMapping("routingServices")
public class RoutingServiceController {
    /**
     * Returns the names of the available routing services.
     *
     * @return nameList
     */
    @GetMapping(path = "names")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public static NameList getRoutingServices() {
        OpenRouteService openRouteService = new OpenRouteService();
        OpenTripPlanner openTripPlanner = new OpenTripPlanner();
        Valhalla valhalla = new Valhalla();

        List<String> routingServices = new ArrayList<>();
        routingServices.add(openRouteService.getName());
        routingServices.add(openTripPlanner.getName());
        routingServices.add(valhalla.getName());

        NameList routingServiceNames = new NameList();
        routingServiceNames.setNames(routingServices);
        return  routingServiceNames;
    }
}
