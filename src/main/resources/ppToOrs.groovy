import com.routing.gateway.preferenceservice.mobilitypreferences.PreferenceProfile
import com.routing.gateway.routingservices.requests.parameters.openrouteserviceparameters.OpenRouteServiceParameters

mappingFor a: OpenRouteServiceParameters, b: PreferenceProfile
a.options.profile_params.weightings.green = { b.weighting.environment / 100 }
a.options.profile_params.weightings.steepness_difficulty = { b.cyclingPace - 1 }
a.options.profile_params.weightings.quiet = { b.weighting.comfort / 100 }
a.preference = { if (b.weighting.duration > b.weighting.comfort) { "fastest"} }

swallow NullPointerException