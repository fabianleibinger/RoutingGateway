package com.routing.gateway.routingservices.requests.parameters.valhallaparameters;

public class ValhallaSearchFilter {
    //default false
    private Boolean exclude_tunnel;
    //default false
    private Boolean exclude_bridge;
    //default false
    private Boolean exclude_ramp;
    //default true
    private Boolean exclude_closures;
    //default "service_other"
    private String min_road_class;
    //default "motorway"
    private String max_road_class;

    public Boolean getExclude_tunnel() {
        return exclude_tunnel;
    }

    public void setExclude_tunnel(Boolean exclude_tunnel) {
        this.exclude_tunnel = exclude_tunnel;
    }

    public Boolean getExclude_bridge() {
        return exclude_bridge;
    }

    public void setExclude_bridge(Boolean exclude_bridge) {
        this.exclude_bridge = exclude_bridge;
    }

    public Boolean getExclude_ramp() {
        return exclude_ramp;
    }

    public void setExclude_ramp(Boolean exclude_ramp) {
        this.exclude_ramp = exclude_ramp;
    }

    public Boolean getExclude_closures() {
        return exclude_closures;
    }

    public void setExclude_closures(Boolean exclude_closures) {
        this.exclude_closures = exclude_closures;
    }

    public String getMin_road_class() {
        return min_road_class;
    }

    public void setMin_road_class(String min_road_class) {
        this.min_road_class = min_road_class;
    }

    public String getMax_road_class() {
        return max_road_class;
    }

    public void setMax_road_class(String max_road_class) {
        this.max_road_class = max_road_class;
    }
}
