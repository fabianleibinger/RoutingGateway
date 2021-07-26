package com.routing.gateway.routingservices.responses.valhallaresponse;

import java.util.Date;

public class ValhallaTransitStop {
    private String type;
    private String onestop_id;
    private String name;
    private Date arrival_date_time;
    private Date departure_date_time;
    private Boolean is_parent_stop;
    private Boolean assumed_schedule;
    private Double lat;
    private Double lon;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOnestop_id() {
        return onestop_id;
    }

    public void setOnestop_id(String onestop_id) {
        this.onestop_id = onestop_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getArrival_date_time() {
        return arrival_date_time;
    }

    public void setArrival_date_time(Date arrival_date_time) {
        this.arrival_date_time = arrival_date_time;
    }

    public Date getDeparture_date_time() {
        return departure_date_time;
    }

    public void setDeparture_date_time(Date departure_date_time) {
        this.departure_date_time = departure_date_time;
    }

    public Boolean getIs_parent_stop() {
        return is_parent_stop;
    }

    public void setIs_parent_stop(Boolean is_parent_stop) {
        this.is_parent_stop = is_parent_stop;
    }

    public Boolean getAssumed_schedule() {
        return assumed_schedule;
    }

    public void setAssumed_schedule(Boolean assumed_schedule) {
        this.assumed_schedule = assumed_schedule;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }
}
