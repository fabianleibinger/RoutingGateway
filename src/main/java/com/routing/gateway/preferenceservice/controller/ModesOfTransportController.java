package com.routing.gateway.preferenceservice.controller;

import com.google.gson.Gson;
import com.routing.gateway.preferenceservice.HttpPreferenceService;
import com.routing.gateway.preferenceservice.User;
import com.routing.gateway.preferenceservice.mobilitypreferences.HateoasLinkListWithNames;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ModesOfTransportController {
    private static final String PATH_SEGMENT = "modesOfTransport";
    private static HateoasLinkListWithNames modesOfTransport;

    public static HateoasLinkListWithNames getUpdatedModesOfTransport(User user) {
        updateModesOfTransport(user);
        return modesOfTransport;
    }

    public static void updateModesOfTransport(User user) {
        HttpPreferenceService httpService = new HttpPreferenceService();
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", user.getAuthorizationHeaderValue());
        Optional<String> responseBody = httpService.getRequest(PATH_SEGMENT, headers);
        if (responseBody.isPresent()) {
            modesOfTransport = new Gson().fromJson(responseBody.get(), HateoasLinkListWithNames.class);
            System.out.println("Updated modes of transport successfully.");
        } else  {
            System.out.println("Failed to update modes of transport.");
        }
    }
}
