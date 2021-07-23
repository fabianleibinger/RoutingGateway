package com.routing.gateway.routingservices.responses.opentripplannerresponse;

import java.util.ArrayList;
import java.util.List;

public class OpenTripPlannerTripPlan {
    private Integer date;
    private OpenTripPlannerPlace from;
    private OpenTripPlannerPlace to;
    private List<OpenTripPlannerItinerary> itineraries;

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public OpenTripPlannerPlace getFrom() {
        if (this.from == null) {
            this.from = new OpenTripPlannerPlace();
        }
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

    public List<OpenTripPlannerItinerary> getItineraries() {
        if (this.itineraries == null) {
            this.itineraries = new ArrayList<>();
        }
        return itineraries;
    }

    public void setItineraries(List<OpenTripPlannerItinerary> itineraries) {
        this.itineraries = itineraries;
    }
}
