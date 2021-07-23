package com.routing.gateway.routingservices.responses.opentripplannerresponse;

public class OpenTripPlannerEncodedPolylineBean {
    private String points;
    private String level;
    private Integer length;

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
