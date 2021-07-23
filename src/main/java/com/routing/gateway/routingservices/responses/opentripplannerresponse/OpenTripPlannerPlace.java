package com.routing.gateway.routingservices.responses.opentripplannerresponse;

public class OpenTripPlannerPlace {
    private String name;
    private OpenTripPlannerAgencyAndId stopId;
    private String stopCode;
    private String platformCode;
    private Integer lon;
    private Integer lat;
    private Integer arrival;
    private Integer departure;
    private String orig;
    private String zoneId;
    private Integer stopIndex;
    private Integer stopSequence;
    private String vertexType;
    private String bikeShareId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OpenTripPlannerAgencyAndId getStopId() {
        if (this.stopId == null) {
            this.stopId = new OpenTripPlannerAgencyAndId();
        }
        return stopId;
    }

    public void setStopId(OpenTripPlannerAgencyAndId stopId) {
        this.stopId = stopId;
    }

    public String getStopCode() {
        return stopCode;
    }

    public void setStopCode(String stopCode) {
        this.stopCode = stopCode;
    }

    public String getPlatformCode() {
        return platformCode;
    }

    public void setPlatformCode(String platformCode) {
        this.platformCode = platformCode;
    }

    public Integer getLon() {
        return lon;
    }

    public void setLon(Integer lon) {
        this.lon = lon;
    }

    public Integer getLat() {
        return lat;
    }

    public void setLat(Integer lat) {
        this.lat = lat;
    }

    public Integer getArrival() {
        return arrival;
    }

    public void setArrival(Integer arrival) {
        this.arrival = arrival;
    }

    public Integer getDeparture() {
        return departure;
    }

    public void setDeparture(Integer departure) {
        this.departure = departure;
    }

    public String getOrig() {
        return orig;
    }

    public void setOrig(String orig) {
        this.orig = orig;
    }

    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public Integer getStopIndex() {
        return stopIndex;
    }

    public void setStopIndex(Integer stopIndex) {
        this.stopIndex = stopIndex;
    }

    public Integer getStopSequence() {
        return stopSequence;
    }

    public void setStopSequence(Integer stopSequence) {
        this.stopSequence = stopSequence;
    }

    public String getVertexType() {
        return vertexType;
    }

    public void setVertexType(String vertexType) {
        this.vertexType = vertexType;
    }

    public String getBikeShareId() {
        return bikeShareId;
    }

    public void setBikeShareId(String bikeShareId) {
        this.bikeShareId = bikeShareId;
    }
}
