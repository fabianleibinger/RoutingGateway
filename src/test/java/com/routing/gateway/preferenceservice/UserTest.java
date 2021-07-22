package com.routing.gateway.preferenceservice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;

public class UserTest {
    private User user;
    private String username = "maria.ziegler@online.de";
    private String fullname = "Maria Ziegler";
    private String password = "1234";

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
        String goal = "grant_type=" + "password" + "&username=" + username + "&password=" + password;
        assertEquals(goal, serialized);
    }

    @Test
    public void testLogIn() throws IOException, InterruptedException {
        String output = user.logIn();
    }

    @Test
    public void testSignUp() throws IOException, InterruptedException {
        Optional<String> output = user.signUpToo();
    }
}
