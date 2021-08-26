package mappings

import com.routinggateway.clients.travelinformationapp.controller.models.RoutingRequest
import com.routinggateway.clients.travelinformationapp.mappings.helpers.HelperRoutingRequestToOpenTripPlannerParameters
import com.routinggateway.routingservices.requests.parameters.opentripplannerparameters.OpenTripPlannerParameters

mappingFor a: OpenTripPlannerParameters, b: RoutingRequest

a.bikeSpeed = b.preferenceProfile.cyclingPace
simple([a: 7d, b: 1], [a: 10.5d, b: 2], [a: 14d, b: 3])
a.fromPlace = { b.origin.getLat().toString() + ", " + b.origin.getLng().toString() }
a.maxTransfers = b.preferenceProfile.connectionPreferences.maxNumOfChanges
a.maxWalkDistance = { b.preferenceProfile.maxWalkingDistance * 1000 }
//a.time = b.preferenceProfile.timeFrame[0]
a.toPlace = { b.destination.getLat().toString() + ", " + b.destination.getLng().toString() }
a.waitReluctance = { (b.preferenceProfile.levelOfIntermodality / 5) + 1 }
a.walkSpeed = { b.preferenceProfile.walkingPace + 1 }
a.wheelchair = b.userProfile.accessibility
a.mode = { HelperRoutingRequestToOpenTripPlannerParameters.toModes(b.preferenceProfile.modePreferences) }
a.optimize = {
    if (b.preferenceProfile.weighting.comfort > b.preferenceProfile.weighting.duration) {
        if (b.preferenceProfile.weighting.comfort > b.preferenceProfile.weighting.environment) {
            "SAFE"
        } else {
            "GREENWAYS"
        }
    } else {
        if (b.preferenceProfile.weighting.duration > b.preferenceProfile.weighting.environment) {
            "QUICK"
        } else {
            "GREENWAYS"
        }
    }
}

swallow NullPointerException