package mappings.openrouteservice

import com.routing.gateway.clients.travelinformationapp.controller.RoutingRequest
import com.routing.gateway.clients.travelinformationapp.mappers.request.RoutingRequestToOpenRouteServiceParametersHelper
import com.routing.gateway.routingservices.requests.parameters.openrouteserviceparameters.OpenRouteServiceParameters

mappingFor a: OpenRouteServiceParameters, b: RoutingRequest
a.coordinates = { RoutingRequestToOpenRouteServiceParametersHelper.toCoordinates(b.origin, b.destination) }
a.options.profile_params.weightings.green = { b.preferenceProfile.weighting.environment / 100 }
a.options.profile_params.weightings.steepness_difficulty = { b.preferenceProfile.cyclingPace - 1 }
a.options.profile_params.weightings.quiet = { b.preferenceProfile.weighting.comfort / 100 }
a.preference = { if (b.preferenceProfile.weighting.duration > b.preferenceProfile.weighting.comfort) { "fastest"} }

swallow NullPointerException