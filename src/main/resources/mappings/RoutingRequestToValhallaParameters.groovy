package mappings

import com.routinggateway.clients.travelinformationapp.controller.models.RoutingRequest
import com.routinggateway.clients.travelinformationapp.mappings.nominhelpers.HelperRoutingRequestToValhallaParameters
import com.routinggateway.routingservices.requests.parameters.valhallaparameters.ValhallaParameters

mappingFor a: ValhallaParameters, b: RoutingRequest

a.locations = { HelperRoutingRequestToValhallaParameters.toLocations(b.origin, b.destination) }
a.costing = { if (b.preferenceProfile.levelOfIntermodality > 25) { "multimodal" } }
a.costing_options.bicycle.bicycle_type = { "hybrid" }
a.costing_options.bicycle.cycling_speed = b.preferenceProfile.cyclingPace
simple([a: 14d, b: 1], [a: 18d, b: 2], [a: 24d, b: 3])
a.costing_options.pedestrian.walking_speed = b.preferenceProfile.walkingPace
simple([a: 3d, b: 1], [a: 5.1d, b: 2], [a: 8d, b: 3])
a.units = { "kilometers" }
a.directions_type = { "instructions" }
//a.date_time = {}

swallow NullPointerException