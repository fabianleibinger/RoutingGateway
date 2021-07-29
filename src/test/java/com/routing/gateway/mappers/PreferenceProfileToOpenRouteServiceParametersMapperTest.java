package com.routing.gateway.mappers;

import static org.junit.jupiter.api.Assertions.*;

import com.googlecode.jmapper.JMapper;
import com.routing.gateway.preferenceservice.mobilitypreferences.PreferenceProfile;
import com.routing.gateway.routingservices.requests.parameters.openrouteserviceparameters.OpenRouteServiceParameters;
import fr.xebia.extras.selma.Selma;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PreferenceProfileToOpenRouteServiceParametersMapperTest {

    private PreferenceProfileToOpenRouteServiceParametersMapper mapper;

    @BeforeEach
    public void setUp() {
        mapper = Selma.builder(PreferenceProfileToOpenRouteServiceParametersMapper.class).build();
    }

    @Test
    public void testJMapper() {
        JMapper<OpenRouteServiceParameters, PreferenceProfile> jMapper;
        jMapper = new JMapper<>(OpenRouteServiceParameters.class, PreferenceProfile.class);
        /*jMapper = new JMapper<>(OpenRouteServiceParameters.class, PreferenceProfile.class,
                "PreferenceProfileToOpenRouteServiceParametersMapper.xml");*/

        PreferenceProfile profile = new PreferenceProfile();
        profile.setProfileName("Jeff");
        //profile.getWeighting().setComfort(75f);

        OpenRouteServiceParameters parameters = jMapper.getDestination(profile);
        assertEquals("Jeff", parameters.getPreference());
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
