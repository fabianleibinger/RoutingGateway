package com.routing.gateway.routingservices.requests.parameters.openrouteserviceparameters;

public class OpenRouteServiceAlternativeRoutes {
    private Float share_factor;
    private Integer target_count;
    private Float weight_factor;

    public Float getShare_factor() {
        return share_factor;
    }

    public void setShare_factor(Float share_factor) {
        this.share_factor = share_factor;
    }

    public Integer getTarget_count() {
        return target_count;
    }

    public void setTarget_count(Integer target_count) {
        this.target_count = target_count;
    }

    public Float getWeight_factor() {
        return weight_factor;
    }

    public void setWeight_factor(Float weight_factor) {
        this.weight_factor = weight_factor;
    }
}
