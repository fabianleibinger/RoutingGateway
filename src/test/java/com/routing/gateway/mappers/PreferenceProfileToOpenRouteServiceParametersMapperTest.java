package com.routing.gateway.mappers;

import static org.junit.jupiter.api.Assertions.*;

import com.googlecode.jmapper.JMapper;
import com.routing.gateway.mappers.request.PreferenceProfileToOpenRouteServiceParameters;
import com.routing.gateway.preferenceservice.mobilitypreferences.PreferenceProfile;
import com.routing.gateway.routingservices.requests.parameters.openrouteserviceparameters.OpenRouteServiceParameters;
import fr.xebia.extras.selma.Selma;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PreferenceProfileToOpenRouteServiceParametersMapperTest {

    private PreferenceProfileToOpenRouteServiceParameters mapper;

    @BeforeEach
    public void setUp() {
        mapper = Selma.builder(PreferenceProfileToOpenRouteServiceParameters.class).build();
    }

    @Test
    public void testJMapper() {
        JMapper<OpenRouteServiceParameters, PreferenceProfile> jMapper;
        /*jMapper = new JMapper<>(OpenRouteServiceParameters.class, PreferenceProfile.class);*/

        jMapper = new JMapper<>(OpenRouteServiceParameters.class, PreferenceProfile.class,
                "PreferenceProfileToOpenRouteServiceParametersMapper.xml");

        PreferenceProfile profile = new PreferenceProfile();
        profile.setProfileName("Jeff");
        profile.getWeighting().setComfort(75f);
        profile.setWalkingPace(3);

        OpenRouteServiceParameters parameters = jMapper.getDestination(profile);

        assertEquals("3", parameters.getPreference());
        assertEquals("Jeff", parameters.getOptions().getAvoidBorders());
        assertEquals("0.75f", parameters.getOptions().getProfileParams().getWeightings().getQuiet());
    }

    @Test
    public void testMapper() {
        PreferenceProfile profile = new PreferenceProfile();
        profile.setCyclingPace(3);
        profile.getWeighting().setComfort(75f);
        profile.getWeighting().setDuration(50f);
        profile.getWeighting().setEnvironment(100f);

        OpenRouteServiceParameters parameters = mapper.asOpenRouteServiceParameters(profile);

        assertEquals(2, parameters.getOptions().getProfileParams().getWeightings().getSteepnessDifficulty());
        assertEquals(null, parameters.getPreference());
        assertEquals(1, parameters.getOptions().getProfileParams().getWeightings().getGreen());
        assertEquals(0.75f, parameters.getOptions().getProfileParams().getWeightings().getQuiet());
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
