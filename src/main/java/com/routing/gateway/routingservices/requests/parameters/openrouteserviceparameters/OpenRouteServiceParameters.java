package com.routing.gateway.routingservices.requests.parameters.openrouteserviceparameters;

import com.routing.gateway.routingservices.Parameters;

import java.util.ArrayList;
import java.util.List;

/**
 * Parameters for OpenRouteService.
 * Getters for complex types include instantiation if value equals null.
 */
public class OpenRouteServiceParameters extends Parameters {

    private List<Double[]> coordinates;
    private OpenRouteServiceAlternativeRoutes alternative_routes;
    private List<String> attributes;
    private List<Float[]> bearings;
    //default false
    private Boolean continue_straight;
    private Boolean elevation;
    private List<String> extra_info;
    //default false
    private Boolean geometry_simplify;
    private String id;
    //default true
    private Boolean instructions;
    //default "text"
    private String instructions_format;
    //default "en"
    private String language;
    //default false
    private Boolean maneuvers;
    private OpenRouteServiceOptions options;
    //default "recommended"
    private String preference;
    //default false
    private Boolean roundabout_exits;
    private List<Integer> skip_segments;
    private Boolean suppress_warnings;
    //default "m"
    private String units;
    //default true
    private Boolean geometry;
    private Integer maximum_speed;

    public List<Double[]> getCoordinates() {
        if (this.coordinates == null) {
            this.coordinates = new ArrayList<>();
        }
        return coordinates;
    }

    public void setCoordinates(List<Double[]> coordinates) {
        this.coordinates = coordinates;
    }

    public OpenRouteServiceAlternativeRoutes getAlternativeRoutes() {
        if (this.alternative_routes == null) {
            this.alternative_routes = new OpenRouteServiceAlternativeRoutes();
        }
        return alternative_routes;
    }

    public void setAlternativeRoutes(OpenRouteServiceAlternativeRoutes alternative_routes) {
        this.alternative_routes = alternative_routes;
    }

    public List<String> getAttributes() {
        if (this.attributes == null) {
            this.attributes = new ArrayList<>();
        }
        return attributes;
    }

    public void setAttributes(List<String> attributes) {
        this.attributes = attributes;
    }

    public List<Float[]> getBearings() {
        if (this.bearings == null) {
            this.bearings = new ArrayList<>();
        }
        return bearings;
    }

    public void setBearings(List<Float[]> bearings) {
        this.bearings = bearings;
    }

    public Boolean isContinueStraight() {
        return continue_straight;
    }

    public void setContinueStraight(Boolean continue_straight) {
        this.continue_straight = continue_straight;
    }

    public Boolean isElevation() {
        return elevation;
    }

    public void setElevation(Boolean elevation) {
        this.elevation = elevation;
    }

    public List<String> getExtraInfo() {
        if (this.extra_info == null) {
            this.extra_info = new ArrayList<>();
        }
        return extra_info;
    }

    public void setExtraInfo(List<String> extra_info) {
        this.extra_info = extra_info;
    }

    public Boolean isGeometrySimplify() {
        return geometry_simplify;
    }

    public void setGeometrySimplify(Boolean geometry_simplify) {
        this.geometry_simplify = geometry_simplify;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean isInstructions() {
        return instructions;
    }

    public void setInstructions(Boolean instructions) {
        this.instructions = instructions;
    }

    public String getInstructionsFormat() {
        return instructions_format;
    }

    public void setInstructionsFormat(String instructions_format) {
        this.instructions_format = instructions_format;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Boolean isManeuvers() {
        return maneuvers;
    }

    public void setManeuvers(Boolean maneuvers) {
        this.maneuvers = maneuvers;
    }

    public OpenRouteServiceOptions getOptions() {
        if (this.options == null) {
            this.options = new OpenRouteServiceOptions();
        }
        return options;
    }

    public void setOptions(OpenRouteServiceOptions options) {
        this.options = options;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public List<Integer> getSkipSegments() {
        if (this.skip_segments == null) {
            this.skip_segments = new ArrayList<>();
        }
        return skip_segments;
    }

    public void setSkipSegments(List<Integer> skip_segments) {
        this.skip_segments = skip_segments;
    }

    public Boolean isSuppressWarnings() {
        return suppress_warnings;
    }

    public void setSuppressWarnings(Boolean suppress_warnings) {
        this.suppress_warnings = suppress_warnings;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public Boolean isRoundaboutExits() {
        return roundabout_exits;
    }

    public void setRoundaboutExits(Boolean roundabout_exits) {
        this.roundabout_exits = roundabout_exits;
    }

    public Integer getMaximumSpeed() {
        return maximum_speed;
    }

    public void setMaximumSpeed(Integer maximum_speed) {
        this.maximum_speed = maximum_speed;
    }

    public Boolean isGeometry() {
        return geometry;
    }

    public void setGeometry(Boolean geometry) {
        this.geometry = geometry;
    }
}
