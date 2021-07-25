package com.routing.gateway.routingservices.requests.parameters.valhallaparameters;

import com.routing.gateway.routingservices.Parameters;

import java.util.ArrayList;
import java.util.List;

/**
 * Parameters for Valhalla.
 * Getters for complex types include instantiation if value equals null.
 */
public class ValhallaParameters extends Parameters {
    private List<ValhallaLocation> locations;
    private String costing;
    private ValhallaCostingOptions costing_options;
    private String units = "kilometers";
    //default "en-US"
    private String language;
    private String directions_type = "instructions";
    private List<ValhallaLocation> avoid_locations;
    private List<List<Double>> avoid_polygons;
    private ValhallaRoutingDateTime date_time;
    //default null
    private String out_format;
    private String id;
    private Boolean linear_references;

    public List<ValhallaLocation> getLocations() {
        if (this.locations == null) {
            this.locations = new ArrayList<>();
        }
        return locations;
    }

    public void setLocations(List<ValhallaLocation> locations) {
        this.locations = locations;
    }

    public String getCosting() {
        return costing;
    }

    public void setCosting(String costing) {
        this.costing = costing;
    }

    public ValhallaCostingOptions getCosting_options() {
        if (this.costing_options == null) {
            this.costing_options = new ValhallaCostingOptions();
        }
        return costing_options;
    }

    public void setCosting_options(ValhallaCostingOptions costing_options) {
        this.costing_options = costing_options;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDirections_type() {
        return directions_type;
    }

    public void setDirections_type(String directions_type) {
        this.directions_type = directions_type;
    }

    public List<ValhallaLocation> getAvoid_locations() {
        if (this.avoid_locations == null) {
            this.avoid_locations = new ArrayList<>();
        }
        return avoid_locations;
    }

    public void setAvoid_locations(List<ValhallaLocation> avoid_locations) {
        this.avoid_locations = avoid_locations;
    }

    public List<List<Double>> getAvoid_polygons() {
        if (this.avoid_polygons == null) {
            this.avoid_polygons = new ArrayList<>();
        }
        return avoid_polygons;
    }

    public void setAvoid_polygons(List<List<Double>> avoid_polygons) {
        this.avoid_polygons = avoid_polygons;
    }

    public ValhallaRoutingDateTime getDate_time() {
        if (this.date_time == null) {
            this.date_time = new ValhallaRoutingDateTime();
        }
        return date_time;
    }

    public void setDate_time(ValhallaRoutingDateTime date_time) {
        this.date_time = date_time;
    }

    public String getOut_format() {
        return out_format;
    }

    public void setOut_format(String out_format) {
        this.out_format = out_format;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getLinear_references() {
        return linear_references;
    }

    public void setLinear_references(Boolean linear_references) {
        this.linear_references = linear_references;
    }
}
