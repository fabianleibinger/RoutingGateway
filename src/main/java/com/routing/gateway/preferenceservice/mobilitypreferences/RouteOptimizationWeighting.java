package com.routing.gateway.preferenceservice.mobilitypreferences;

import com.routing.gateway.routingservices.Parameters;

import java.util.ArrayList;
import java.util.List;

public class RouteOptimizationWeighting extends Parameters {
    //0-100
    private Float comfort;
    //0-100
    private Float duration;
    //0-100
    private Float environment;
    private List<Link> links;
    //0-100
    private Float price;

    public Float getComfort() {
        return comfort;
    }

    public void setComfort(Float comfort) {
        this.comfort = comfort;
    }

    public Float getDuration() {
        return duration;
    }

    public void setDuration(Float duration) {
        this.duration = duration;
    }

    public Float getEnvironment() {
        return environment;
    }

    public void setEnvironment(Float environment) {
        this.environment = environment;
    }

    public List<Link> getLinks() {
        if (this.links == null) {
            this.links = new ArrayList<>();
        }
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
