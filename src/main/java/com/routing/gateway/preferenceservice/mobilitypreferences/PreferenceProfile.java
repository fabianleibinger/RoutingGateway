package com.routing.gateway.preferenceservice.mobilitypreferences;

import com.routing.gateway.routingservices.Parameters;

import java.util.ArrayList;
import java.util.List;

/**
 * Mobility preferences profile of a user.
 */
public class PreferenceProfile extends Parameters {
    private ConnectionPreferences connectionPreferences;
    //1-3
    private Integer cyclingPace;
    private List<String> demandedComfortFactors;
    //1-50
    private Integer levelOfIntermodality;
    private List<Link> links;
    //1-3
    private Integer luggageSize;
    //1-500
    private Float maxCyclingDistance;
    //1-50
    private Float maxWalkingDistance;
    private ModePreferences modePreferences;
    private Boolean noCyclingInBadWeather;
    private String profileName;
    private List<String> timeframe;
    //1-3
    private Integer walkingPace;
    private RouteOptimizationWeighting weighting;

    public ConnectionPreferences getConnectionPreferences() {
        if (this.connectionPreferences == null) {
            this.connectionPreferences = new ConnectionPreferences();
        }
        return connectionPreferences;
    }

    public void setConnectionPreferences(ConnectionPreferences connectionPreferences) {
        this.connectionPreferences = connectionPreferences;
    }

    public Integer getCyclingPace() {
        return cyclingPace;
    }

    public void setCyclingPace(Integer cyclingPace) {
        this.cyclingPace = cyclingPace;
    }

    public List<String> getDemandedComfortFactors() {
        if (this.demandedComfortFactors == null) {
            this.demandedComfortFactors = new ArrayList<>();
        }
        return demandedComfortFactors;
    }

    public void setDemandedComfortFactors(List<String> demandedComfortFactors) {
        this.demandedComfortFactors = demandedComfortFactors;
    }

    public Integer getLevelOfIntermodality() {
        return levelOfIntermodality;
    }

    public void setLevelOfIntermodality(Integer levelOfIntermodality) {
        this.levelOfIntermodality = levelOfIntermodality;
    }

    public List<Link> getLinks() {
        if (this.links == null) {
            this.links = new ArrayList<>();
        }
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public Integer getLuggageSize() {
        return luggageSize;
    }

    public void setLuggageSize(Integer luggageSize) {
        this.luggageSize = luggageSize;
    }

    public Float getMaxCyclingDistance() {
        return maxCyclingDistance;
    }

    public void setMaxCyclingDistance(Float maxCyclingDistance) {
        this.maxCyclingDistance = maxCyclingDistance;
    }

    public Float getMaxWalkingDistance() {
        return maxWalkingDistance;
    }

    public void setMaxWalkingDistance(Float maxWalkingDistance) {
        this.maxWalkingDistance = maxWalkingDistance;
    }

    public ModePreferences getModePreferences() {
        if (this.modePreferences == null) {
            this.modePreferences = new ModePreferences();
        }
        return modePreferences;
    }

    public void setModePreferences(ModePreferences modePreferences) {
        this.modePreferences = modePreferences;
    }

    public Boolean getNoCyclingInBadWeather() {
        return noCyclingInBadWeather;
    }

    public void setNoCyclingInBadWeather(Boolean noCyclingInBadWeather) {
        this.noCyclingInBadWeather = noCyclingInBadWeather;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public List<String> getTimeframe() {
        if (this.timeframe == null) {
            this.timeframe = new ArrayList<>();
        }
        return timeframe;
    }

    public void setTimeframe(List<String> timeframe) {
        this.timeframe = timeframe;
    }

    public Integer getWalkingPace() {
        return walkingPace;
    }

    public void setWalkingPace(Integer walkingPace) {
        this.walkingPace = walkingPace;
    }

    public RouteOptimizationWeighting getWeighting() {
        if (this.weighting == null) {
            this.weighting = new RouteOptimizationWeighting();
        }
        return weighting;
    }

    public void setWeighting(RouteOptimizationWeighting weighting) {
        this.weighting = weighting;
    }
}
