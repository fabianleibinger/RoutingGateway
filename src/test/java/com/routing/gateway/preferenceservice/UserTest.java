package com.routing.gateway.preferenceservice;

import static org.junit.jupiter.api.Assertions.*;

import com.routing.gateway.preferenceservice.mobilitypreferences.PreferenceProfile;
import com.routing.gateway.preferenceservice.mobilitypreferences.UserProfile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {
    private User user;
    private String username = "maria.ziegler@online.de";
    private String fullname = "Maria Ziegler";
    private String password = "1234";

    @BeforeEach
    public void setUp() {
        user = new User();
        user.setUsername(username);
        user.setFullName(fullname);
        user.setPassword(password);
    }

    @Test
    public void testToReceiveTokenBodyFormat() {
        String serialized = user.toReceiveTokenBodyFormat();
        String goal = "grant_type=" + "password" + "&username=" + username + "&password=" + password;
        assertEquals(goal, serialized);
    }

    @Test
    public void testToSignupBodyFormat() {
        String serialized = user.toSignupBodyFormat();
        String goal = "username=" + username + "&fullname=" + fullname + "&password=" + password;
        assertEquals(goal, serialized);
    }

    @Test
    public void testLogin() {
        user.login();
    }

    @Test
    public void testSignup() {
        user.signup();
    }

    @Test
    public void testSetAndGetProfile() {
        user.login();

        UserProfile newProfile = new UserProfile();
        newProfile.setAccessibility(false);
        newProfile.setCanRideABike(true);
        newProfile.setGrantGPS(false);
        newProfile.setHasDriversLicence(true);
        newProfile.setPrivateBicycleAvailable(true);
        newProfile.setPrivateCarAvailable(false);

        user.setProfile(newProfile);
        UserProfile profile = user.getProfile();

        assertEquals(newProfile.getAccessibility(), profile.getAccessibility());
        assertEquals(newProfile.getCanRideABike(), profile.getCanRideABike());
        assertEquals(newProfile.getGrantGPS(), profile.getGrantGPS());
        assertEquals(newProfile.getHasDriversLicence(), profile.getHasDriversLicence());
        assertEquals(newProfile.getPrivateBicycleAvailable(), profile.getPrivateBicycleAvailable());
        assertEquals(newProfile.getPrivateCarAvailable(), profile.getPrivateCarAvailable());
    }

    @Test
    public void testSetAndGetPreferenceProfile() {
        user.login();

        PreferenceProfile newPreferenceProfile = new PreferenceProfile();

        //user.setPreferenceProfile(newPreferenceProfile);
        PreferenceProfile preferenceProfile = user.getPreferenceProfile();

        System.out.println(preferenceProfile.getCyclingPace());
    }
}
