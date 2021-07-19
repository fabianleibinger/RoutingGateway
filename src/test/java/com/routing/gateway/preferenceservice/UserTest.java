package com.routing.gateway.preferenceservice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {
    private User user;
    private String username = "peytonL@gmx.de";
    private String fullname = "Peytonius L";
    private String password = "test123";

    @BeforeEach
    public void setUp() {
        user = new User(username,fullname,password);
    }

    @Test
    public void testToSignUpBodyFormat() {
        String serialized = user.toSignUpBodyFormat();
        String goal = "username=" + username + "&fullname=" + fullname + "&password=" + password;
        assertEquals(goal, serialized);
    }

    @Test
    public void testToLogInBodyFormat() {
        String serialized = user.toLogInBodyFormat();
        String goal = "grant_type" + "password" + "&username=" + username + "&password=" + password;
        assertEquals(goal, serialized);
    }

    @Test
    public void testSignUp() {
        String output = user.signup();
    }
}
