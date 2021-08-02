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
public class ComfortController {
    private static final String PATH_SEGMENT = "comfortFactors";

    @PostMapping(path = "comfortFactors",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public static HateoasLinkListWithNames getUpdatedComfortFactors(@RequestBody User user) {
        Optional<HateoasLinkListWithNames> comfortFactors = updateComfortFactors(user);
        if (comfortFactors.isPresent()) {
            return comfortFactors.get();
        } else {
            return new HateoasLinkListWithNames();
        }
    }

    public static Optional<HateoasLinkListWithNames> updateComfortFactors(User user) {
        HttpPreferenceService httpService = new HttpPreferenceService();
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", user.getAuthorizationHeaderValue());
        Optional<String> responseBody = httpService.getRequest(PATH_SEGMENT, headers);
        if (responseBody.isPresent()) {
            System.out.println("Updated comfort factors successfully.");
            return Optional.of(new Gson().fromJson(responseBody.get(), HateoasLinkListWithNames.class));
        } else  {
            System.out.println("Failed to update comfort factors.");
            return Optional.empty();
        }
    }
}
