package com.routing.gateway.preferenceservice.controller;

import com.google.gson.Gson;
import com.routing.gateway.preferenceservice.HttpPreferenceService;
import com.routing.gateway.preferenceservice.User;
import com.routing.gateway.preferenceservice.mobilitypreferences.HateoasLinkListWithNames;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class PreferenceProfileController {
    private static final String PATH_SEGMENT = "user/preferenceProfiles";

    @PostMapping(path = "user/preferenceProfiles",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public static HateoasLinkListWithNames getUpdatedPreferenceProfiles(@RequestBody User user) {
        user.login();
        Optional<HateoasLinkListWithNames> preferenceProfiles = updatePreferenceProfiles(user);
        if (preferenceProfiles.isPresent()) {
            return preferenceProfiles.get();
        } else {
            return new HateoasLinkListWithNames();
        }
    }

    public static Optional<HateoasLinkListWithNames> updatePreferenceProfiles(User user) {
        HttpPreferenceService httpService = new HttpPreferenceService();
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", user.getAuthorizationHeaderValue());
        Optional<String> responseBody = httpService.getRequest(PATH_SEGMENT, headers);
        if (responseBody.isPresent()) {
            System.out.println("Updated preference profiles successfully.");
            return Optional.of(new Gson().fromJson(responseBody.get(), HateoasLinkListWithNames.class));
        } else  {
            System.out.println("Failed to update preference profiles.");
            return Optional.empty();
        }
    }

    @DeleteMapping("user/preferenceProfiles/{name}")
    public static void deletePreferenceProfile(User user, @PathVariable String name) {
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
