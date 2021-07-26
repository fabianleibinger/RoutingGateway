package com.routing.gateway.routingservices.responses.valhallaresponse;

public class ValhallaSummary {
    private Double time;
    private Double length;
    private Double min_lat;
    private Double min_lon;
    private Double max_lat;
    private Double max_lon;

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getMin_lat() {
        return min_lat;
    }

    public void setMin_lat(Double min_lat) {
        this.min_lat = min_lat;
    }

    public Double getMin_lon() {
        return min_lon;
    }

    public void setMin_lon(Double min_lon) {
        this.min_lon = min_lon;
    }

    public Double getMax_lat() {
        return max_lat;
    }

    public void setMax_lat(Double max_lat) {
        this.max_lat = max_lat;
    }

    public Double getMax_lon() {
        return max_lon;
    }

    public void setMax_lon(Double max_lon) {
        this.max_lon = max_lon;
    }
}
