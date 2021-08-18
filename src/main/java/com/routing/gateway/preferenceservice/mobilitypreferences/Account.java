package com.routing.gateway.preferenceservice.mobilitypreferences;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String fullname;
    private List<Link> links;
    private String platform;
    private String role;
    private String username;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
