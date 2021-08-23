package com.routinggateway.clients.travelinformationapp.controller.models.preferences;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPreferences {
    private List<Link> links;
    //in minutes
    private Integer maxConnectingTime;
    private Integer maxNumOfChanges;
    //in minutes
    private Integer minConnectingTime;
    private Boolean minimizeChanges;

    public List<Link> getLinks() {
        if (this.links == null) {
            this.links = new ArrayList<>();
        }
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public Integer getMaxConnectingTime() {
        return maxConnectingTime;
    }

    public void setMaxConnectingTime(Integer maxConnectingTime) {
        this.maxConnectingTime = maxConnectingTime;
    }

    public Integer getMaxNumOfChanges() {
        return maxNumOfChanges;
    }

    public void setMaxNumOfChanges(Integer maxNumOfChanges) {
        this.maxNumOfChanges = maxNumOfChanges;
    }

    public Integer getMinConnectingTime() {
        return minConnectingTime;
    }

    public void setMinConnectingTime(Integer minConnectingTime) {
        this.minConnectingTime = minConnectingTime;
    }

    public Boolean getMinimizeChanges() {
        return minimizeChanges;
    }

    public void setMinimizeChanges(Boolean minimizeChanges) {
        this.minimizeChanges = minimizeChanges;
    }
}
