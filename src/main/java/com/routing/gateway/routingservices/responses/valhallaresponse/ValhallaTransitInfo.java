package com.routing.gateway.routingservices.responses.valhallaresponse;

import java.util.ArrayList;
import java.util.List;

public class ValhallaTransitInfo {
    private String onestop_id;
    private String short_name;
    private String long_name;
    private String headsign;
    private String color;
    private String text_color;
    private String description;
    private String operator_onestop_id;
    private String operator_name;
    private String operator_url;
    private List<ValhallaTransitStop> transit_stops;

    public String getOnestop_id() {
        return onestop_id;
    }

    public void setOnestop_id(String onestop_id) {
        this.onestop_id = onestop_id;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String getLong_name() {
        return long_name;
    }

    public void setLong_name(String long_name) {
        this.long_name = long_name;
    }

    public String getHeadsign() {
        return headsign;
    }

    public void setHeadsign(String headsign) {
        this.headsign = headsign;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getText_color() {
        return text_color;
    }

    public void setText_color(String text_color) {
        this.text_color = text_color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOperator_onestop_id() {
        return operator_onestop_id;
    }

    public void setOperator_onestop_id(String operator_onestop_id) {
        this.operator_onestop_id = operator_onestop_id;
    }

    public String getOperator_name() {
        return operator_name;
    }

    public void setOperator_name(String operator_name) {
        this.operator_name = operator_name;
    }

    public String getOperator_url() {
        return operator_url;
    }

    public void setOperator_url(String operator_url) {
        this.operator_url = operator_url;
    }

    public List<ValhallaTransitStop> getTransit_stops() {
        if (this.transit_stops == null) {
            this.transit_stops = new ArrayList<>();
        }
        return transit_stops;
    }

    public void setTransit_stops(List<ValhallaTransitStop> transit_stops) {
        this.transit_stops = transit_stops;
    }
}
