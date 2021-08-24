package com.routinggateway.clients.travelinformationapp.controller.models;

import com.routinggateway.clients.travelinformationapp.controller.models.preferences.PreferenceProfile;
import com.routinggateway.clients.travelinformationapp.controller.models.preferences.UserProfile;

/**
 * Routing request body for the travel information app client.
 */
public class RoutingRequest {
    private LatLng origin;
    private LatLng destination;
    private String routingService;
    private PreferenceProfile preferenceProfile;
    private UserProfile userProfile;

    public LatLng getOrigin() {
        return origin;
    }

    public void setOrigin(LatLng origin) {
        this.origin = origin;
    }

    public LatLng getDestination() {
        return destination;
    }

    public void setDestination(LatLng destination) {
        this.destination = destination;
    }

    public String getRoutingService() {
        return routingService;
    }

    public void setRoutingService(String routingService) {
        this.routingService = routingService;
    }

    public PreferenceProfile getPreferenceProfile() {
        if (this.preferenceProfile == null) {
            this.preferenceProfile = new PreferenceProfile();
        }
        return preferenceProfile;
    }

    public void setPreferenceProfile(PreferenceProfile preferenceProfile) {
        this.preferenceProfile = preferenceProfile;
    }

    public UserProfile getUserProfile() {
        if (this.userProfile == null) {
            this.userProfile = new UserProfile();
        }
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
}
