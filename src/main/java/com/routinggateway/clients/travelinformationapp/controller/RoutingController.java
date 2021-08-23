package com.routinggateway.clients.travelinformationapp.controller;

import com.routinggateway.clients.travelinformationapp.controller.models.RoutingResponse;
import com.routinggateway.routingservices.requests.RoutingRequest;
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
        return null;
    }
}
