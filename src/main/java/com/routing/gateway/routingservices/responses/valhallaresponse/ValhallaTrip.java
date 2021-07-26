package com.routing.gateway.routingservices.responses.valhallaresponse;

import java.util.ArrayList;
import java.util.List;

public class ValhallaTrip {
    private Integer status;
    private String status_message;
    private String units;
    private String language;
    private List<ValhallaLocation> locations;
    private ValhallaSummary summary;
    private List<ValhallaLeg> legs;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatus_message() {
        return status_message;
    }

    public void setStatus_message(String status_message) {
        this.status_message = status_message;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<ValhallaLocation> getLocations() {
        if (this.locations == null) {
            this.locations = new ArrayList<>();
        }
        return locations;
    }

    public void setLocations(List<ValhallaLocation> locations) {
        this.locations = locations;
    }

    public ValhallaSummary getSummary() {
        if (this.summary == null) {
            this.summary = new ValhallaSummary();
        }
        return summary;
    }

    public void setSummary(ValhallaSummary summary) {
        this.summary = summary;
    }

    public List<ValhallaLeg> getLegs() {
        if (this.legs == null) {
            this.legs = new ArrayList<>();
        }
        return legs;
    }

    public void setLegs(List<ValhallaLeg> legs) {
        this.legs = legs;
    }
}
