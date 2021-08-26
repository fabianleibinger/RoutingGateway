package com.routinggateway.clients.travelinformationapp.mappers;

import static org.junit.jupiter.api.Assertions.*;

import com.routinggateway.clients.travelinformationapp.controller.models.LatLng;
import com.routinggateway.clients.travelinformationapp.controller.models.RoutingRequest;
import com.routinggateway.routingservices.requests.parameters.openrouteserviceparameters.OpenRouteServiceParameters;
import com.routinggateway.routingservices.requests.parameters.opentripplannerparameters.OpenTripPlannerParameters;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.nomin.NominMapper;
import org.nomin.core.Nomin;

public class NominTest {
    private NominMapper nomin;
    private RoutingRequest request;

    @BeforeEach
    public void setUp() {
        request = new RoutingRequest();
        LatLng location = new LatLng();
        location.setLat(0d);
        location.setLng(1d);
        request.setOrigin(location);
        request.setDestination(location);
        request.getPreferenceProfile().getWeighting().setComfort(50f);
        request.getPreferenceProfile().getWeighting().setDuration(75f);
        request.getPreferenceProfile().getWeighting().setEnvironment(30f);
        request.getPreferenceProfile().setCyclingPace(3);
        request.getPreferenceProfile().setWalkingPace(1);
        request.getPreferenceProfile().getConnectionPreferences().setMaxNumOfChanges(4);
        request.getPreferenceProfile().setMaxWalkingDistance(20f);
        request.getPreferenceProfile().setLevelOfIntermodality(45);
        request.getUserProfile().setAccessibility(true);
        request.getPreferenceProfile().getModePreferences().getPreferredModes().add("car");
    }

    @Test
    public void testRRToORSParams() {
        nomin = new Nomin("mappings/RoutingRequestToOpenRouteServiceParameters.groovy");

        OpenRouteServiceParameters parameters = nomin.map(request, OpenRouteServiceParameters.class);

        assertEquals(1d, parameters.getCoordinates().get(0)[0]);
        assertEquals(0.5f, parameters.getOptions().getProfile_params().getWeightings().getQuiet());
        assertEquals("fastest", parameters.getPreference());
        assertEquals(0.3f, parameters.getOptions().getProfile_params().getWeightings().getGreen());
        assertEquals(2, parameters.getOptions().getProfile_params().getWeightings().getSteepness_difficulty());
    }

    @Test
    public void testRRToOTPParams() {
        nomin = new Nomin("mappings/RoutingRequestToOpenTripPlannerParameters.groovy");

        OpenTripPlannerParameters parameters = nomin.map(request, OpenTripPlannerParameters.class);

        assertEquals(14d, parameters.getBikeSpeed());
        assertEquals("0.0, 1.0", parameters.getFromPlace());
        assertEquals(4, parameters.getMaxTransfers());
        assertEquals(20000d, parameters.getMaxWalkDistance());
        assertEquals("QUICK", parameters.getOptimize());
        assertEquals("0.0, 1.0", parameters.getToPlace());
        assertEquals(10d, parameters.getWaitReluctance());
        assertEquals(2d, parameters.getWalkSpeed());
        assertEquals(true , parameters.getWheelchair());
        assertEquals("CAR, CAR_TO_PARK, ", parameters.getMode());
    }
}
