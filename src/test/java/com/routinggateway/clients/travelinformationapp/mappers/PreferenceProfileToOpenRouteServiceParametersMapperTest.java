package com.routinggateway.clients.travelinformationapp.mappers;

import static org.junit.jupiter.api.Assertions.*;

import com.google.maps.model.LatLng;
import com.routinggateway.clients.travelinformationapp.controller.models.RoutingRequest;
import com.routinggateway.routingservices.requests.parameters.openrouteserviceparameters.OpenRouteServiceParameters;
import org.junit.jupiter.api.Test;
import org.nomin.NominMapper;
import org.nomin.core.Nomin;

public class PreferenceProfileToOpenRouteServiceParametersMapperTest {

    @Test
    public void testNominRRToORSParams() {
        NominMapper nomin = new Nomin("mappings/openrouteservice/RoutingRequestToOpenRouteServiceParameters.groovy");
        RoutingRequest request = new RoutingRequest();
        request.setOrigin(new LatLng(0, 1));
        request.setDestination(new LatLng(2, 3));
        request.getPreferenceProfile().getWeighting().setComfort(50f);
        request.getPreferenceProfile().getWeighting().setDuration(75f);
        request.getPreferenceProfile().getWeighting().setEnvironment(30f);
        request.getPreferenceProfile().setCyclingPace(3);

        OpenRouteServiceParameters parameters = nomin.map(request, OpenRouteServiceParameters.class);
        assertEquals(1d, parameters.getCoordinates().get(0)[0]);
        assertEquals(0.5f, parameters.getOptions().getProfile_params().getWeightings().getQuiet());
        assertEquals("fastest", parameters.getPreference());
        assertEquals(0.3f, parameters.getOptions().getProfile_params().getWeightings().getGreen());
        assertEquals(2, parameters.getOptions().getProfile_params().getWeightings().getSteepness_difficulty());
    }
}
