package com.routing.gateway.preferenceservice.controller;

import com.google.gson.Gson;
import com.routing.gateway.preferenceservice.HttpPreferenceService;
import com.routing.gateway.preferenceservice.User;
import com.routing.gateway.preferenceservice.mobilitypreferences.HateoasLinkListWithNames;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ComfortController {
    private static final String PATH_SEGMENT = "comfortFactors";
    private static HateoasLinkListWithNames comfortFactors;

    public static HateoasLinkListWithNames getUpdatedComfortFactors(User user) {
        updateComfortFactors(user);
        return comfortFactors;
    }

    public static void updateComfortFactors(User user) {
        HttpPreferenceService httpService = new HttpPreferenceService();
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", user.getAuthorizationHeaderValue());
        Optional<String> responseBody = httpService.getRequest(PATH_SEGMENT, headers);
        if (responseBody.isPresent()) {
            comfortFactors = new Gson().fromJson(responseBody.get(), HateoasLinkListWithNames.class);
            System.out.println("Updated comfort factors successfully.");
        } else  {
            System.out.println("Failed to update comfort factors.");
        }
    }
}
