package com.routing.gateway.preferenceservice.controller;

import com.google.gson.Gson;
import com.routing.gateway.preferenceservice.HttpPreferenceService;
import com.routing.gateway.preferenceservice.User;
import com.routing.gateway.preferenceservice.mobilitypreferences.HateoasLinkListWithNames;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PreferenceProfileController {
    private static final String PATH_SEGMENT = "user/preferenceProfiles";
    private static HateoasLinkListWithNames preferenceProfiles;

    public static HateoasLinkListWithNames getUpdatedPreferenceProfiles(User user) {
        updatePreferenceProfiles(user);
        return preferenceProfiles;
    }

    public static void updatePreferenceProfiles(User user) {
        HttpPreferenceService httpService = new HttpPreferenceService();
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", user.getAuthorizationHeaderValue());
        Optional<String> responseBody = httpService.getRequest(PATH_SEGMENT, headers);
        if (responseBody.isPresent()) {
            preferenceProfiles = new Gson().fromJson(responseBody.get(), HateoasLinkListWithNames.class);
            System.out.println("Updated preference profiles successfully.");
        } else  {
            System.out.println("Failed to update preference profiles.");
        }
    }

    public static void deletePreferenceProfile(User user, String name) {
        HttpPreferenceService httpService = new HttpPreferenceService();
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", user.getAuthorizationHeaderValue());
        Optional<String> responseBody = httpService.deleteRequest(PATH_SEGMENT + "/" + name, headers);
        if (responseBody.isPresent()) {
            System.out.println("Deleted preference profile successfully.");
        } else {
            System.out.println("Failed to delete preference profile.");
        }
    }
}
