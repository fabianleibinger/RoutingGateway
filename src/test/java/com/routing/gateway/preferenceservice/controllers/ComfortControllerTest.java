package com.routing.gateway.preferenceservice.controllers;

import com.routing.gateway.preferenceservice.User;
import com.routing.gateway.preferenceservice.mobilitypreferences.HateoasLinkListWithNames;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComfortControllerTest {
    private User user;
    private String username = "maria.ziegler@online.de";
    private String fullname = "Maria Ziegler";
    private String password = "1234";

    @BeforeEach
    public void setup() {
        user = new User();
        user.setUsername(username);
        user.setFullname(fullname);
        user.setPassword(password);

        user.login();
    }

    @Test
    public void testGetUpdatedComfortFactors() {
        HateoasLinkListWithNames comfortFactors = ComfortController.getUpdatedComfortFactors(user);
        for (String name : comfortFactors.getNames()) {
            System.out.println(name);
        }
    }
}
