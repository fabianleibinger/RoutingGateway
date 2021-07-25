package com.routing.gateway.routingservices.responses.opentripplannerresponse;

import com.routing.gateway.routingservices.Parameters;

/**
 * Response information of a request to OpenTripPlanner.
 */
public class OpenTripPlannerResponse extends Parameters {
    private Object requestParameters;
    private OpenTripPlannerDebugOutput debugOutput;
    private OpenTripPlannerTripPlan plan;
    private OpenTripPlannerError error;

    public Object getRequestParameters() {
        if (this.requestParameters == null) {
            this.requestParameters = new Object();
        }
        return requestParameters;
    }

    public void setRequestParameters(Object requestParameters) {
        this.requestParameters = requestParameters;
    }

    public OpenTripPlannerDebugOutput getDebugOutput() {
        if (this.debugOutput == null) {
            this.debugOutput = new OpenTripPlannerDebugOutput();
        }
        return debugOutput;
    }

    public void setDebugOutput(OpenTripPlannerDebugOutput debugOutput) {
        this.debugOutput = debugOutput;
    }

    public OpenTripPlannerTripPlan getPlan() {
        if (this.plan == null) {
            this.plan = new OpenTripPlannerTripPlan();
        }
        return plan;
    }

    public void setPlan(OpenTripPlannerTripPlan plan) {
        this.plan = plan;
    }

    public OpenTripPlannerError getError() {
        if (this.error == null) {
            this.error = new OpenTripPlannerError();
        }
        return error;
    }

    public void setError(OpenTripPlannerError error) {
        this.error = error;
    }
}
