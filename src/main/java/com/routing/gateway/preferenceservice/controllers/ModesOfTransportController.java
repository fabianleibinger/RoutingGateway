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
 * Controller that handles all requests related to the modes of transport.
 */
@RestController
public class ModesOfTransportController {
    //Path of the related controller at the upstream preference service.
    private static final String PATH_SEGMENT = "modesOfTransport";

    /**
     * Returns available modes of transport or throws BadGatewayException.
     *
     * @param user User; accessToken required
     * @return modes of transport HateoasLinkListWithNames
     */
    @PostMapping(path = "modes",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public static HateoasLinkListWithNames getUpdatedModesOfTransport(@RequestBody User user) {
        Optional<HateoasLinkListWithNames> modesOfTransport = updateModesOfTransport(user);
        if (modesOfTransport.isPresent()) {
            return modesOfTransport.get();
        } else {
            throw new BadGatewayException("Failed to receive modes of transport");
        }
    }

    /**
     * Updates available modes of transport from the upstream preference service.
     *
     * @param user User; accessToken required
     * @return modes of transport Optional HateoasLinkListWithNames
     */
    public static Optional<HateoasLinkListWithNames> updateModesOfTransport(User user) {
        HttpPreferenceService httpService = new HttpPreferenceService();
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", user.getAuthorizationHeaderValue());
        Optional<String> responseBody = httpService.getRequest(PATH_SEGMENT, headers);
        if (responseBody.isPresent()) {
            System.out.println("Updated modes of transport successfully.");
            return Optional.of(new Gson().fromJson(responseBody.get(), HateoasLinkListWithNames.class));
        } else {
            System.out.println("Failed to update modes of transport.");
            return Optional.empty();
        }
    }
}
