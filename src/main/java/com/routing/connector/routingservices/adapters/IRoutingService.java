package com.routing.connector.routingservices.adapters;

import com.routing.connector.routingservices.requests.RoutingRequest;
import com.routing.connector.routingservices.responses.RoutingResponse;

import java.util.Optional;

public interface IRoutingService {

    RoutingResponse computeRoute(RoutingRequest request);

    String getName();
    String getURL();

}
