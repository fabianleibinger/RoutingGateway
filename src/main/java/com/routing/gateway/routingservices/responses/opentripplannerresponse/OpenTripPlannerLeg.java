package com.routing.gateway.routingservices.responses.opentripplannerresponse;

import java.util.ArrayList;
import java.util.List;

public class OpenTripPlannerLeg {
    private Integer startTime;
    private Integer endTime;
    private Integer departureDelay;
    private Integer arrivalDelay;
    private Boolean realTime;
    private Boolean isNonExactFrequency;
    private Integer headway;
    private Integer distance;
    private Boolean pathway;
    private String mode;
    private String route;
    private String agencyName;
    private String agencyUrl;
    private Integer agencyTimeZoneOffset;
    private String routeColor;
    private Integer routeType;
    private OpenTripPlannerAgencyAndId routeId;
    private String routeTextColor;
    private Boolean interlineWithPreviousLeg;
    private String tripShortName;
    private String tripBlockId;
    private String headsign;
    private String agencyId;
    private OpenTripPlannerAgencyAndId tripId;
    private String serviceDate;
    private OpenTripPlannerPlace from;
    private OpenTripPlannerPlace to;
    private List<OpenTripPlannerPlace> intermediateStops;
    private OpenTripPlannerEncodedPolylineBean legGeometry;
    private List<OpenTripPlannerWalkStep> steps;
    private List<OpenTripPlannerLocalizedAlert> alerts;
    private String routeShortName;
    private String routeLongName;
    private String boardRule;
    private String alightRule;
    private Boolean rentedBike;
    private Boolean transitLeg;
    private Integer duration;

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public Integer getDepartureDelay() {
        return departureDelay;
    }

    public void setDepartureDelay(Integer departureDelay) {
        this.departureDelay = departureDelay;
    }

    public Integer getArrivalDelay() {
        return arrivalDelay;
    }

    public void setArrivalDelay(Integer arrivalDelay) {
        this.arrivalDelay = arrivalDelay;
    }

    public Boolean getRealTime() {
        return realTime;
    }

    public void setRealTime(Boolean realTime) {
        this.realTime = realTime;
    }

    public Boolean getNonExactFrequency() {
        return isNonExactFrequency;
    }

    public void setNonExactFrequency(Boolean nonExactFrequency) {
        isNonExactFrequency = nonExactFrequency;
    }

    public Integer getHeadway() {
        return headway;
    }

    public void setHeadway(Integer headway) {
        this.headway = headway;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Boolean getPathway() {
        return pathway;
    }

    public void setPathway(Boolean pathway) {
        this.pathway = pathway;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getAgencyUrl() {
        return agencyUrl;
    }

    public void setAgencyUrl(String agencyUrl) {
        this.agencyUrl = agencyUrl;
    }

    public Integer getAgencyTimeZoneOffset() {
        return agencyTimeZoneOffset;
    }

    public void setAgencyTimeZoneOffset(Integer agencyTimeZoneOffset) {
        this.agencyTimeZoneOffset = agencyTimeZoneOffset;
    }

    public String getRouteColor() {
        return routeColor;
    }

    public void setRouteColor(String routeColor) {
        this.routeColor = routeColor;
    }

    public Integer getRouteType() {
        return routeType;
    }

    public void setRouteType(Integer routeType) {
        this.routeType = routeType;
    }

    public OpenTripPlannerAgencyAndId getRouteId() {
        if (this.routeId == null) {
            this.routeId = new OpenTripPlannerAgencyAndId();
        }
        return routeId;
    }

    public void setRouteId(OpenTripPlannerAgencyAndId routeId) {
        this.routeId = routeId;
    }

    public String getRouteTextColor() {
        return routeTextColor;
    }

    public void setRouteTextColor(String routeTextColor) {
        this.routeTextColor = routeTextColor;
    }

    public Boolean getInterlineWithPreviousLeg() {
        return interlineWithPreviousLeg;
    }

    public void setInterlineWithPreviousLeg(Boolean interlineWithPreviousLeg) {
        this.interlineWithPreviousLeg = interlineWithPreviousLeg;
    }

    public String getTripShortName() {
        return tripShortName;
    }

    public void setTripShortName(String tripShortName) {
        this.tripShortName = tripShortName;
    }

    public String getTripBlockId() {
        return tripBlockId;
    }

    public void setTripBlockId(String tripBlockId) {
        this.tripBlockId = tripBlockId;
    }

    public String getHeadsign() {
        return headsign;
    }

    public void setHeadsign(String headsign) {
        this.headsign = headsign;
    }

    public String getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    public OpenTripPlannerAgencyAndId getTripId() {
        if (this.tripId == null) {
            this.tripId = new OpenTripPlannerAgencyAndId();
        }
        return tripId;
    }

    public void setTripId(OpenTripPlannerAgencyAndId tripId) {
        this.tripId = tripId;
    }

    public String getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(String serviceDate) {
        this.serviceDate = serviceDate;
    }

    public OpenTripPlannerPlace getFrom() {
        return from;
    }

    public void setFrom(OpenTripPlannerPlace from) {
        this.from = from;
    }

    public OpenTripPlannerPlace getTo() {
        if (this.to == null) {
            this.to = new OpenTripPlannerPlace();
        }
        return to;
    }

    public void setTo(OpenTripPlannerPlace to) {
        this.to = to;
    }

    public List<OpenTripPlannerPlace> getIntermediateStops() {
        if (this.intermediateStops == null) {
            this.intermediateStops = new ArrayList<>();
        }
        return intermediateStops;
    }

    public void setIntermediateStops(List<OpenTripPlannerPlace> intermediateStops) {
        this.intermediateStops = intermediateStops;
    }

    public OpenTripPlannerEncodedPolylineBean getLegGeometry() {
        if (this.legGeometry == null) {
            this.legGeometry = new OpenTripPlannerEncodedPolylineBean();
        }
        return legGeometry;
    }

    public void setLegGeometry(OpenTripPlannerEncodedPolylineBean legGeometry) {
        this.legGeometry = legGeometry;
    }

    public List<OpenTripPlannerWalkStep> getSteps() {
        if (this.steps == null) {
            this.steps = new ArrayList<>();
        }
        return steps;
    }

    public void setSteps(List<OpenTripPlannerWalkStep> steps) {
        this.steps = steps;
    }

    public List<OpenTripPlannerLocalizedAlert> getAlerts() {
        if (this.alerts == null) {
            this.alerts = new ArrayList<>();
        }
        return alerts;
    }

    public void setAlerts(List<OpenTripPlannerLocalizedAlert> alerts) {
        this.alerts = alerts;
    }

    public String getRouteShortName() {
        return routeShortName;
    }

    public void setRouteShortName(String routeShortName) {
        this.routeShortName = routeShortName;
    }

    public String getRouteLongName() {
        return routeLongName;
    }

    public void setRouteLongName(String routeLongName) {
        this.routeLongName = routeLongName;
    }

    public String getBoardRule() {
        return boardRule;
    }

    public void setBoardRule(String boardRule) {
        this.boardRule = boardRule;
    }

    public String getAlightRule() {
        return alightRule;
    }

    public void setAlightRule(String alightRule) {
        this.alightRule = alightRule;
    }

    public Boolean getRentedBike() {
        return rentedBike;
    }

    public void setRentedBike(Boolean rentedBike) {
        this.rentedBike = rentedBike;
    }

    public Boolean getTransitLeg() {
        return transitLeg;
    }

    public void setTransitLeg(Boolean transitLeg) {
        this.transitLeg = transitLeg;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
