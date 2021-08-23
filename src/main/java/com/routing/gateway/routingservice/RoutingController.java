package com.routing.gateway.routingservice;

import com.routing.gateway.clients.travelinformationapp.controller.NameList;
import com.routing.gateway.clients.travelinformationapp.controller.RoutingServiceController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for a travel information application that handles all requests related to routing.
 */
@RestController
@RequestMapping("routing")
public class RoutingController {
    /**
     * Returns the names of the available routing services or throws BadGatewayException.
     *
     * @return nameList
     */
    @GetMapping(path = "services")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public static NameList getRoutingServices() {
        //TODO call correct controller moved to different service
        return RoutingServiceController.getRoutingServices();
    }
}
