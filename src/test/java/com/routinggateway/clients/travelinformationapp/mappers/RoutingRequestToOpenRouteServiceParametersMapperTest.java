package com.routinggateway.clients.travelinformationapp.mappers;

import static org.junit.jupiter.api.Assertions.*;

import com.routinggateway.clients.travelinformationapp.controller.models.LatLng;
import com.routinggateway.clients.travelinformationapp.controller.models.RoutingRequest;
import com.routinggateway.routingservices.requests.parameters.openrouteserviceparameters.OpenRouteServiceParameters;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.nomin.NominMapper;
import org.nomin.core.Nomin;

public class RoutingRequestToOpenRouteServiceParametersMapperTest {
    private NominMapper nomin;

    @BeforeEach
    public void setUp() {
        nomin = new Nomin("mappings/RoutingRequestToOpenRouteServiceParameters.groovy");
    }

    @Test
    public void testRRToORSParams() {
        RoutingRequest request = new RoutingRequest();
        LatLng location = new LatLng();
        location.setLat(0d);
        location.setLng(1d);
        request.setOrigin(location);
        request.setDestination(location);
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
