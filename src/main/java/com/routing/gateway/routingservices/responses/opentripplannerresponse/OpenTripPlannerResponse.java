package com.routing.gateway.routingservices.responses.opentripplannerresponse;

import com.routing.gateway.routingservices.requests.parameters.Parameters;

/**
 * Response information of a request to OpenTripPlanner.
 */
public class OpenTripPlannerResponse extends Parameters {
    private Object requestParameters;
    private OpenTripPlannerDebugOutput debugOutput;
    private OpenTripPlannerTripPlan plan;
    private OpenTripPlannerError error;
}
