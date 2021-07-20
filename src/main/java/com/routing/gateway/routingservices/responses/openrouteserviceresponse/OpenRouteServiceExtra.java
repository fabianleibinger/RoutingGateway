package com.routing.gateway.routingservices.responses.openrouteserviceresponse;

import java.util.ArrayList;
import java.util.List;

public class OpenRouteServiceExtra {
    private List<OpenRouteServiceExtraSummary> summary;
    private List<List<Long>> values;

    public List<OpenRouteServiceExtraSummary> getSummary() {
        if (this.summary == null) {
            this.summary = new ArrayList<>();
        }
        return summary;
    }

    public void setSummary(List<OpenRouteServiceExtraSummary> summary) {
        this.summary = summary;
    }

    public List<List<Long>> getValues() {
        if (this.values == null) {
            this.values = new ArrayList<>();
        }
        return values;
    }

    public void setValues(List<List<Long>> values) {
        this.values = values;
    }
}
