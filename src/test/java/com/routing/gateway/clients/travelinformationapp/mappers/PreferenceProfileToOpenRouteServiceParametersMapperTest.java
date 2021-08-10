package com.routing.gateway.clients.travelinformationapp.mappers;

import static org.junit.jupiter.api.Assertions.*;

import com.routing.gateway.clients.travelinformationapp.mappers.request.PreferenceProfileToOpenRouteServiceParameters;
import com.routing.gateway.preferenceservice.mobilitypreferences.PreferenceProfile;
import com.routing.gateway.routingservices.requests.parameters.openrouteserviceparameters.OpenRouteServiceParameters;
import fr.xebia.extras.selma.Selma;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.nomin.NominMapper;
import org.nomin.core.Nomin;

public class PreferenceProfileToOpenRouteServiceParametersMapperTest {

    private PreferenceProfileToOpenRouteServiceParameters mapper;

    @BeforeEach
    public void setUp() {
        mapper = Selma.builder(PreferenceProfileToOpenRouteServiceParameters.class).build();
    }

    @Test
    public void testNomin() {
        NominMapper nomin = new Nomin("ppToOrs.groovy");
        PreferenceProfile profile = new PreferenceProfile();
        profile.getWeighting().setComfort(50f);
        profile.getWeighting().setDuration(75f);
        profile.getWeighting().setEnvironment(30f);
        profile.setCyclingPace(3);

        OpenRouteServiceParameters parameters = nomin.map(profile, OpenRouteServiceParameters.class);
        assertEquals(0.5f, parameters.getOptions().getProfile_params().getWeightings().getQuiet());
        assertEquals("fastest", parameters.getPreference());
        assertEquals(0.3f, parameters.getOptions().getProfile_params().getWeightings().getGreen());
        assertEquals(2, parameters.getOptions().getProfile_params().getWeightings().getSteepness_difficulty());
    }

    @Test
    public void testMapper() {
        PreferenceProfile profile = new PreferenceProfile();
        profile.setCyclingPace(3);
        profile.getWeighting().setComfort(75f);
        profile.getWeighting().setDuration(50f);
        profile.getWeighting().setEnvironment(100f);

        OpenRouteServiceParameters parameters = mapper.asOpenRouteServiceParameters(profile);

        assertEquals(2, parameters.getOptions().getProfile_params().getWeightings().getSteepness_difficulty());
        assertEquals(null, parameters.getPreference());
        assertEquals(1, parameters.getOptions().getProfile_params().getWeightings().getGreen());
        assertEquals(0.75f, parameters.getOptions().getProfile_params().getWeightings().getQuiet());
    }

    @Test
    public void testNullValue() {
        PreferenceProfile profile = new PreferenceProfile();
        assertThrows(NullPointerException.class, () -> {OpenRouteServiceParameters parameters = mapper.asOpenRouteServiceParameters(profile);});
    }

    @Test
    public void testDurationImportant() {
        PreferenceProfile profile = new PreferenceProfile();
        profile.setCyclingPace(3);
        profile.getWeighting().setComfort(75f);
        profile.getWeighting().setDuration(100f);
        profile.getWeighting().setEnvironment(100f);

        OpenRouteServiceParameters parameters = mapper.asOpenRouteServiceParameters(profile);

        assertEquals("fastest", parameters.getPreference());
    }
}
