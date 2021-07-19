package com.routing.gateway.routingservices.responses.openrouteserviceresponse;

import com.routing.gateway.routingservices.requests.parameters.Parameters;

import java.util.List;

public class OpenRouteServiceResponse extends Parameters {
    private List<Double> bbox;
    private OpenRouteServiceMetadata metadata;
    private OpenRouteServiceRoutes routes;
}
