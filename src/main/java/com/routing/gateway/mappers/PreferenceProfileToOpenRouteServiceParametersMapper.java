package com.routing.gateway.mappers;

import com.routing.gateway.preferenceservice.mobilitypreferences.PreferenceProfile;
import com.routing.gateway.routingservices.requests.parameters.openrouteserviceparameters.OpenRouteServiceParameters;
import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Maps;

@Mapper
public interface PreferenceProfileToOpenRouteServiceParametersMapper {
    @Maps(withCustom = OpenRouteServiceMapper.class)
    OpenRouteServiceParameters asOpenRouteServiceParameters(PreferenceProfile profile);

    class OpenRouteServiceMapper {
        public OpenRouteServiceParameters asOpenRouteServiceParameters(PreferenceProfile profile) {
            OpenRouteServiceParameters parameters = new OpenRouteServiceParameters();

            if (profile.getWeighting().getDuration() > profile.getWeighting().getComfort()) {
                parameters.setPreference("fastest");
            }
            parameters.getOptions().getProfileParams().getWeightings()
                    .setQuiet(profile.getWeighting().getComfort() / 100);
            parameters.getOptions().getProfileParams().getWeightings()
                    .setGreen(profile.getWeighting().getEnvironment() / 100);
            parameters.getOptions().getProfileParams().getWeightings()
                    .setSteepnessDifficulty(profile.getCyclingPace() - 1);

            return parameters;
        }
    }
}