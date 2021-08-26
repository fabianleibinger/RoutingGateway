package com.routinggateway.routingservices.responses.opentripplannerresponse;

import java.util.ArrayList;
import java.util.List;

public class OpenTripPlannerDebugOutput {
    private Double precalculationTime;
    private Double pathCalculationTime;
    private List<Double> pathTimes;
    private Double renderingTime;
    private Double totalTime;
    private Boolean timedOut;

    public Double getPrecalculationTime() {
        return precalculationTime;
    }

    public void setPrecalculationTime(Double precalculationTime) {
        this.precalculationTime = precalculationTime;
    }

    public Double getPathCalculationTime() {
        return pathCalculationTime;
    }

    public void setPathCalculationTime(Double pathCalculationTime) {
        this.pathCalculationTime = pathCalculationTime;
    }

    public List<Double> getPathTimes() {
        if (this.pathTimes == null) {
            this.pathTimes = new ArrayList<>();
        }
        return pathTimes;
    }

    public void setPathTimes(List<Double> pathTimes) {
        this.pathTimes = pathTimes;
    }

    public Double getRenderingTime() {
        return renderingTime;
    }

    public void setRenderingTime(Double renderingTime) {
        this.renderingTime = renderingTime;
    }

    public Double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Double totalTime) {
        this.totalTime = totalTime;
    }

    public Boolean getTimedOut() {
        return timedOut;
    }

    public void setTimedOut(Boolean timedOut) {
        this.timedOut = timedOut;
    }
}
