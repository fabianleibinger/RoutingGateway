package com.routing.gateway.routingservices.requests.parameters.openrouteserviceparameters;

public class OpenRouteServiceRestrictions {
    private Float axleload;
    //default false
    private Boolean hazmat;
    private Float height;
    private Float length;
    //default 6
    private Integer maximum_incline;
    //default 0.6f
    private Float maximum_sloped_kerb;
    private Float minimum_width;
    //default "good"
    private String smoothness_type;
    //default "cobblestone:flattened"
    private String surface_type;
    //default "grade1"
    private String track_type;
    private Float weight;
    private Float width;

    public Float getAxleload() {
        return axleload;
    }

    public void setAxleload(Float axleload) {
        this.axleload = axleload;
    }

    public Boolean isHazmat() {
        return hazmat;
    }

    public void setHazmat(Boolean hazmat) {
        this.hazmat = hazmat;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public Integer getMaximumIncline() {
        return maximum_incline;
    }

    public void setMaximumIncline(Integer maximum_incline) {
        this.maximum_incline = maximum_incline;
    }

    public Float getMaximumSlopedKerb() {
        return maximum_sloped_kerb;
    }

    public void setMaximumSlopedKerb(Float maximum_sloped_kerb) {
        this.maximum_sloped_kerb = maximum_sloped_kerb;
    }

    public Float getMinimumWidth() {
        return minimum_width;
    }

    public void setMinimumWidth(Float minimum_width) {
        this.minimum_width = minimum_width;
    }

    public String getSmoothnessType() {
        return smoothness_type;
    }

    public void setSmoothnessType(String smoothness_type) {
        this.smoothness_type = smoothness_type;
    }

    public String getSurfaceType() {
        return surface_type;
    }

    public void setSurfaceType(String surface_type) {
        this.surface_type = surface_type;
    }

    public String getTrackType() {
        return track_type;
    }

    public void setTrackType(String track_type) {
        this.track_type = track_type;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }
}
