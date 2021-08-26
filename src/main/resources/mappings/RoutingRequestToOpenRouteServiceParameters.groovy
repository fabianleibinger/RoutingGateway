package mappings

import com.routinggateway.clients.travelinformationapp.controller.models.RoutingRequest
import com.routinggateway.clients.travelinformationapp.mappings.helpers.HelperRoutingRequestToOpenRouteServiceParameters
import com.routinggateway.routingservices.requests.parameters.openrouteserviceparameters.OpenRouteServiceParameters

mappingFor a: OpenRouteServiceParameters, b: RoutingRequest

a.coordinates = { HelperRoutingRequestToOpenRouteServiceParameters.toCoordinates(b.origin, b.destination) }
a.options.profile_params.weightings.green = { b.preferenceProfile.weighting.environment / 100 }
a.options.profile_params.weightings.steepness_difficulty = { b.preferenceProfile.cyclingPace - 1 }
a.options.profile_params.weightings.quiet = { b.preferenceProfile.weighting.comfort / 100 }
a.preference = { if (b.preferenceProfile.weighting.duration > b.preferenceProfile.weighting.comfort) {"fastest"} }

swallow NullPointerException