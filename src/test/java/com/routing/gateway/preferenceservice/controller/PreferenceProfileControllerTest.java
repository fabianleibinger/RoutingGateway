package com.routing.gateway.preferenceservice.controller;

import com.routing.gateway.preferenceservice.User;
import com.routing.gateway.preferenceservice.mobilitypreferences.HateoasLinkListWithNames;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PreferenceProfileControllerTest {
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
    public void testGetUpdatedPreferenceProfiles() {
        HateoasLinkListWithNames preferenceProfiles = PreferenceProfileController.getUpdatedPreferenceProfiles(user);
        for (String name : preferenceProfiles.getNames()) {
            System.out.println(name);
        }
    }

    @Test
    public void testDeletePreferenceProfile() {
        PreferenceProfileController.deletePreferenceProfile(user, "testForTIA");
    }
}
