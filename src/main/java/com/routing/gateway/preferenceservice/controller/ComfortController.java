package com.routing.gateway.preferenceservice.controller;

import com.google.gson.Gson;
import com.routing.gateway.preferenceservice.HttpPreferenceService;
import com.routing.gateway.preferenceservice.User;
import com.routing.gateway.preferenceservice.mobilitypreferences.ComfortFactors;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ComfortController {
    private static final String PATH_SEGMENT = "comfortFactors";
    private static ComfortFactors comfortFactors;

    public static ComfortFactors getUpdatedComfortFactors(User user) {
        updateComfortFactors(user);
        return comfortFactors;
    }

    public static void updateComfortFactors(User user) {
        HttpPreferenceService httpService = new HttpPreferenceService();
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", user.getAuthorizationHeaderValue());
        Optional<String> responseBody = httpService.getRequest(PATH_SEGMENT, headers);
        if (responseBody.isPresent()) {
            comfortFactors = new Gson().fromJson(responseBody.get(), ComfortFactors.class);
            System.out.println("Updated comfort factors successfully.");
        } else  {
            System.out.println("Failed to update comfort factors.");
        }
    }
}
