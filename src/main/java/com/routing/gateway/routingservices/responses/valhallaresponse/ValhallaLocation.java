package com.routing.gateway.routingservices.responses.valhallaresponse;

import com.routing.gateway.routingservices.requests.parameters.valhallaparameters.ValhallaSearchFilter;

public class ValhallaLocation {
    private Double lat;
    private Double lon;
    private String type;
    private Integer heading;
    private Integer heading_tolerance;
    private String street;
    private Integer way_id;
    private Integer minimum_reachability;
    //default 0
    private Integer radius;
    private Boolean rank_candidates;
    private String preferred_side;
    private Double display_lat;
    private Double display_lon;
    private Integer search_cutoff;
    //default 5
    private Integer node_snap_tolerance;
    private Double street_side_tolerance;
    private Double street_side_max_distance;
    private ValhallaSearchFilter search_filter;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getHeading() {
        return heading;
    }

    public void setHeading(Integer heading) {
        this.heading = heading;
    }

    public Integer getHeading_tolerance() {
        return heading_tolerance;
    }

    public void setHeading_tolerance(Integer heading_tolerance) {
        this.heading_tolerance = heading_tolerance;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getWay_id() {
        return way_id;
    }

    public void setWay_id(Integer way_id) {
        this.way_id = way_id;
    }

    public Integer getMinimum_reachability() {
        return minimum_reachability;
    }

    public void setMinimum_reachability(Integer minimum_reachability) {
        this.minimum_reachability = minimum_reachability;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    public Boolean getRank_candidates() {
        return rank_candidates;
    }

    public void setRank_candidates(Boolean rank_candidates) {
        this.rank_candidates = rank_candidates;
    }

    public String getPreferred_side() {
        return preferred_side;
    }

    public void setPreferred_side(String preferred_side) {
        this.preferred_side = preferred_side;
    }

    public Double getDisplay_lat() {
        return display_lat;
    }

    public void setDisplay_lat(Double display_lat) {
        this.display_lat = display_lat;
    }

    public Double getDisplay_lon() {
        return display_lon;
    }

    public void setDisplay_lon(Double display_lon) {
        this.display_lon = display_lon;
    }

    public Integer getSearch_cutoff() {
        return search_cutoff;
    }

    public void setSearch_cutoff(Integer search_cutoff) {
        this.search_cutoff = search_cutoff;
    }

    public Integer getNode_snap_tolerance() {
        return node_snap_tolerance;
    }

    public void setNode_snap_tolerance(Integer node_snap_tolerance) {
        this.node_snap_tolerance = node_snap_tolerance;
    }

    public Double getStreet_side_tolerance() {
        return street_side_tolerance;
    }

    public void setStreet_side_tolerance(Double street_side_tolerance) {
        this.street_side_tolerance = street_side_tolerance;
    }

    public Double getStreet_side_max_distance() {
        return street_side_max_distance;
    }

    public void setStreet_side_max_distance(Double street_side_max_distance) {
        this.street_side_max_distance = street_side_max_distance;
    }

    public ValhallaSearchFilter getSearch_filter() {
        if(this.search_filter == null) {
            this.search_filter = new ValhallaSearchFilter();
        }
        return search_filter;
    }

    public void setSearch_filter(ValhallaSearchFilter search_filter) {
        this.search_filter = search_filter;
    }
}

