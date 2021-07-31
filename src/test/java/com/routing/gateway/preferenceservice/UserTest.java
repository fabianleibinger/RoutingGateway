package com.routing.gateway.preferenceservice;

import static org.junit.jupiter.api.Assertions.*;

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
        UserProfile profile = user.getProfile();
        System.out.println(profile.getAccessibility());
        System.out.println(profile.getCanRideABike());
        System.out.println(profile.getGrantGPS());
        System.out.println(profile.getHasDriversLicense());
        System.out.println(profile.getPrivateBicycleAvailable());
        System.out.println(profile.getPrivateCarAvailable());
    }
}
