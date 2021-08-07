package com.routing.gateway.preferenceservice.controllers;

import com.google.gson.Gson;
import com.routing.gateway.preferenceservice.HttpPreferenceService;
import com.routing.gateway.preferenceservice.User;
import com.routing.gateway.preferenceservice.controllers.exceptions.BadGatewayException;
import com.routing.gateway.preferenceservice.mobilitypreferences.HateoasLinkListWithNames;
import com.routing.gateway.preferenceservice.mobilitypreferences.PreferenceProfile;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Controller that handles all requests related to preference profiles of users.
 */
@RestController
@RequestMapping("user/preferenceProfiles")
public class PreferenceProfileController {
    //Path of the related controller at the upstream preference service.
    private static final String PATH_SEGMENT = "user/preferenceProfiles";

    /**
     * Returns available preference profiles of a user or throws BadGatewayException.
     *
     * @param user User; accessToken required
     * @return preference profiles HateoasLinkListWithNames
     */
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public static HateoasLinkListWithNames getUpdatedPreferenceProfiles(@RequestBody User user) {
        Optional<HateoasLinkListWithNames> preferenceProfiles = updatePreferenceProfiles(user);
        if (preferenceProfiles.isPresent()) {
            return preferenceProfiles.get();
        } else {
            throw new BadGatewayException("Failed to receive preference profiles.");
        }
    }

    /**
     * Updates available preference profiles of user from the upstream preference service.
     *
     * @param user User; accessToken required
     * @return preference profiles Optional HateoasLinkListWithNames
     */
    public static Optional<HateoasLinkListWithNames> updatePreferenceProfiles(User user) {
        HttpPreferenceService httpService = new HttpPreferenceService();
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", user.getAuthorizationHeaderValue());
        Optional<String> responseBody = httpService.getRequest(PATH_SEGMENT, headers);
        if (responseBody.isPresent()) {
            System.out.println("Updated preference profiles successfully.");
            return Optional.of(new Gson().fromJson(responseBody.get(), HateoasLinkListWithNames.class));
        } else {
            System.out.println("Failed to update preference profiles.");
            return Optional.empty();
        }
    }

    /**
     * Adds preference profile for user or throws BadGatewayException.
     *
     * @param user User; accessToken and preferenceProfile required
     * @return preference profile
     */
    @PostMapping(path = "add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public static PreferenceProfile addPreferenceProfile(@RequestBody User user) {
        if (user.addPreferenceProfileToService(user.getPreferenceProfile())) {
            return user.getPreferenceProfile();
        } else {
            throw new BadGatewayException("Failed to add preference profile.");
        }
    }

    /**
     * Returns specific preference profile for user or throws BadGatewayException.
     *
     * @param user User; accessToken required
     * @param name String name of the preference profile
     * @return preference profile
     */
    @PostMapping(path = "{name}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public static PreferenceProfile getSpecificPreferenceProfile(@RequestBody User user, @PathVariable String name) {
        Optional<PreferenceProfile> preferenceProfile = user.receivePreferenceProfileByName(name);
        if (preferenceProfile.isPresent()) {
            return preferenceProfile.get();
        } else {
            throw new BadGatewayException("Failed to receive preference profile.");
        }
    }

    /**
     * Updates specific preference profile for user or throws BadGatewayException.
     *
     * @param user User; accessToken and preferenceProfile required
     * @param name String name of the preference profile to be updated
     * @return preference profile
     */
    @PutMapping(path = "{name}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public static PreferenceProfile updateSpecificPreferenceProfile(@RequestBody User user, @PathVariable String name) {
        if (user.updatePreferenceProfile(user.getPreferenceProfile())) {
            return user.getPreferenceProfile();
        } else {
            throw new BadGatewayException("Failed to update preference profile.");
        }
    }

    /**
     * Deletes specific preference profile for user or throws BadGatewayException.
     *
     * @param user User; accessToken required
     * @param name String name of the preference profile
     */
    @DeleteMapping("{name}")
    @ResponseStatus(HttpStatus.OK)
    public static void deletePreferenceProfile(User user, @PathVariable String name) {
        HttpPreferenceService httpService = new HttpPreferenceService();
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", user.getAuthorizationHeaderValue());
        Optional<String> responseBody = httpService.deleteRequest(PATH_SEGMENT + "/" + name, headers);
        if (responseBody.isPresent()) {
            System.out.println("Deleted preference profile successfully.");
        } else {
            System.out.println("Failed to delete preference profile.");
            throw new BadGatewayException("Failed to delete preference profile.");
        }
    }
}
