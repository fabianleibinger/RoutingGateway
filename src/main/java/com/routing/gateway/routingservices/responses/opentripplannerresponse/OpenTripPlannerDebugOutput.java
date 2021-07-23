package com.routing.gateway.routingservices.responses.opentripplannerresponse;

import java.util.ArrayList;
import java.util.List;

public class OpenTripPlannerDebugOutput {
    private Integer precalculationTime;
    private Integer pathCalculationTime;
    private List<Integer> pathTimes;
    private Integer renderingTime;
    private Integer totalTime;
    private Boolean timedOut;

    public Integer getPrecalculationTime() {
        return precalculationTime;
    }

    public void setPrecalculationTime(Integer precalculationTime) {
        this.precalculationTime = precalculationTime;
    }

    public Integer getPathCalculationTime() {
        return pathCalculationTime;
    }

    public void setPathCalculationTime(Integer pathCalculationTime) {
        this.pathCalculationTime = pathCalculationTime;
    }

    public List<Integer> getPathTimes() {
        if (this.pathTimes == null) {
            this.pathTimes = new ArrayList<>();
        }
        return pathTimes;
    }

    public void setPathTimes(List<Integer> pathTimes) {
        this.pathTimes = pathTimes;
    }

    public Integer getRenderingTime() {
        return renderingTime;
    }

    public void setRenderingTime(Integer renderingTime) {
        this.renderingTime = renderingTime;
    }

    public Integer getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Integer totalTime) {
        this.totalTime = totalTime;
    }

    public Boolean getTimedOut() {
        return timedOut;
    }

    public void setTimedOut(Boolean timedOut) {
        this.timedOut = timedOut;
    }
}
