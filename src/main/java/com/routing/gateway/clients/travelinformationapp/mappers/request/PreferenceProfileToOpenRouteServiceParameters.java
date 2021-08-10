package com.routing.gateway.clients.travelinformationapp.mappers.request;

import com.routing.gateway.preferenceservice.mobilitypreferences.PreferenceProfile;
import com.routing.gateway.routingservices.requests.parameters.openrouteserviceparameters.OpenRouteServiceParameters;
import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Maps;

@Mapper
public interface PreferenceProfileToOpenRouteServiceParameters {
    @Maps(withCustom = OpenRouteServiceMapper.class)
    OpenRouteServiceParameters asOpenRouteServiceParameters(PreferenceProfile profile);

    class OpenRouteServiceMapper {
        public OpenRouteServiceParameters asOpenRouteServiceParameters(PreferenceProfile profile) {
            OpenRouteServiceParameters parameters = new OpenRouteServiceParameters();

            if (profile.getWeighting().getDuration() > profile.getWeighting().getComfort()) {
                parameters.setPreference("fastest");
            }
            parameters.getOptions().getProfile_params().getWeightings()
                    .setQuiet(profile.getWeighting().getComfort() / 100);
            parameters.getOptions().getProfile_params().getWeightings()
                    .setGreen(profile.getWeighting().getEnvironment() / 100);
            parameters.getOptions().getProfile_params().getWeightings()
                    .setSteepness_difficulty(profile.getCyclingPace() - 1);

            return parameters;
        }
    }
}
