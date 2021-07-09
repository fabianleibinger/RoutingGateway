package com.routing.connector.routingservices.adapters;

import com.routing.connector.models.MobilityPreferences;
import com.routing.connector.routingservices.responses.RoutingResponse;

import java.util.Optional;

/**
 * Interface for Routing Services.
 */
public interface IRoutingService {

    Optional<RoutingResponse> computeRoute(MobilityPreferences preferences);

    String getName();
    String getURL();

}
