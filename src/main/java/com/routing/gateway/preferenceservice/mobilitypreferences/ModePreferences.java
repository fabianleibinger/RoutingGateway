package com.routing.gateway.preferenceservice.mobilitypreferences;

import com.routing.gateway.routingservices.Parameters;

import java.util.ArrayList;
import java.util.List;

public class ModePreferences extends Parameters {
    private List<String> excludedModes;
    private List<Link> links;
    private List<String> neutralModes;
    private List<String> preferredModes;

    public List<String> getExcludedModes() {
        if (this.excludedModes == null) {
            this.excludedModes = new ArrayList<>();
        }
        return excludedModes;
    }

    public void setExcludedModes(List<String> excludedModes) {
        this.excludedModes = excludedModes;
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

    public List<String> getNeutralModes() {
        if (this.neutralModes == null) {
            this.neutralModes = new ArrayList<>();
        }
        return neutralModes;
    }

    public void setNeutralModes(List<String> neutralModes) {
        this.neutralModes = neutralModes;
    }

    public List<String> getPreferredModes() {
        if (this.preferredModes == null) {
            this.preferredModes = new ArrayList<>();
        }
        return preferredModes;
    }

    public void setPreferredModes(List<String> preferredModes) {
        this.preferredModes = preferredModes;
    }
}
