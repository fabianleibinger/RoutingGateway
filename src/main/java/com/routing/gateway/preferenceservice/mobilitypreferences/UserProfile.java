package com.routing.gateway.preferenceservice.mobilitypreferences;

import com.routing.gateway.routingservices.Parameters;

import java.util.ArrayList;
import java.util.List;

/**
 * User profile.
 */
public class UserProfile extends Parameters {
    private Boolean accessibility;
    private Boolean canRideABike;
    private Boolean grantGPS;
    private Boolean hasDriversLicence;
    private List<Link> links;
    private Boolean privateBicycleAvailable;
    private Boolean privateCarAvailable;

    public Boolean getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(Boolean accessibility) {
        this.accessibility = accessibility;
    }

    public Boolean getCanRideABike() {
        return canRideABike;
    }

    public void setCanRideABike(Boolean canRideABike) {
        this.canRideABike = canRideABike;
    }

    public Boolean getGrantGPS() {
        return grantGPS;
    }

    public void setGrantGPS(Boolean grantGPS) {
        this.grantGPS = grantGPS;
    }

    public Boolean getHasDriversLicence() {
        return hasDriversLicence;
    }

    public void setHasDriversLicence(Boolean hasDriversLicence) {
        this.hasDriversLicence = hasDriversLicence;
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

    public Boolean getPrivateBicycleAvailable() {
        return privateBicycleAvailable;
    }

    public void setPrivateBicycleAvailable(Boolean privateBicycleAvailable) {
        this.privateBicycleAvailable = privateBicycleAvailable;
    }

    public Boolean getPrivateCarAvailable() {
        return privateCarAvailable;
    }

    public void setPrivateCarAvailable(Boolean privateCarAvailable) {
        this.privateCarAvailable = privateCarAvailable;
    }
}
