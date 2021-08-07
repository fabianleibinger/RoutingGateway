package com.routing.gateway.preferenceservice.controllers;

import com.google.gson.Gson;
import com.routing.gateway.preferenceservice.HttpPreferenceService;
import com.routing.gateway.preferenceservice.User;
import com.routing.gateway.preferenceservice.controllers.exceptions.BadGatewayException;
import com.routing.gateway.preferenceservice.mobilitypreferences.HateoasLinkListWithNames;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Controller that handles all requests related to the comfort factors.
 */
@RestController
public class ComfortController {
    //Path of the related controller at the upstream preference service.
    private static final String PATH_SEGMENT = "comfortFactors";

    /**
     * Returns available comfort factors or throws BadGatewayException.
     *
     * @param user User; accessToken required
     * @return comfort factors HateoasLinkListWithNames
     */
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
            throw new BadGatewayException("Failed to receive comfort factors.");
        }
    }

    /**
     * Updates available comfort factors from the upstream preference service.
     *
     * @param user User; accessToken required
     * @return comfort factors Optional HateoasLinkListWithNames
     */
    public static Optional<HateoasLinkListWithNames> updateComfortFactors(User user) {
        HttpPreferenceService httpService = new HttpPreferenceService();
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", user.getAuthorizationHeaderValue());
        Optional<String> responseBody = httpService.getRequest(PATH_SEGMENT, headers);
        if (responseBody.isPresent()) {
            System.out.println("Updated comfort factors successfully.");
            return Optional.of(new Gson().fromJson(responseBody.get(), HateoasLinkListWithNames.class));
        } else {
            System.out.println("Failed to update comfort factors.");
            return Optional.empty();
        }
    }
}
