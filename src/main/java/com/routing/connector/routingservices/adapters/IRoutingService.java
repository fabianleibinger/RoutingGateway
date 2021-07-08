package com.routing.connector.routingservices.adapters;

import com.routing.connector.models.MobilityPreferences;
import com.routing.connector.routingservices.responses.RoutingResponse;

public interface IRoutingService {

    RoutingResponse computeRoute(MobilityPreferences preferences);

    String getName();
    String getURL();

}
