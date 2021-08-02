package com.routing.gateway.preferenceservice.controller;

import com.routing.gateway.preferenceservice.User;
import com.routing.gateway.preferenceservice.mobilitypreferences.PreferenceProfile;
import com.routing.gateway.preferenceservice.mobilitypreferences.UserProfile;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    //TODO correct request response types

    @PostMapping(path = "user/signup",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public static User signup(@RequestBody User user) {
        if (user.signup()) {
            return user;
        } else {
            return new User();
        }
    }

    @PostMapping(path = "user/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public static User login(@RequestBody User user) {
        if (user.login()) {
            return user;
        } else {
            return new User();
        }
    }

    @PostMapping(path = "user/preferenceProfiles/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public static PreferenceProfile addPreferenceProfile(@RequestBody User user) {
        if (user.addPreferenceProfileToService(user.getPreferenceProfile())) {
            return user.getPreferenceProfile();
        } else {
            return new PreferenceProfile();
        }
    }

    @PostMapping(path = "user/preferenceProfiles/{name}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public static PreferenceProfile getSpecificPreferenceProfile(@RequestBody User user, @PathVariable String name) {
        Optional<PreferenceProfile> preferenceProfile = user.receivePreferenceProfileByName(name);
        return preferenceProfile.orElseGet(PreferenceProfile::new);
    }

    @PutMapping(path = "user/preferenceProfiles/{name}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public static PreferenceProfile updateSpecificPreferenceProfile(@RequestBody User user, @PathVariable String name) {
        if (user.updatePreferenceProfile(user.getPreferenceProfile())) {
            return user.getPreferenceProfile();
        } else {
            return new PreferenceProfile();
        }
    }

    @PostMapping(path = "user/profile",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public static UserProfile getProfile(@RequestBody User user) {
        Optional<UserProfile> userProfile = user.receiveProfile();
        return userProfile.orElseGet(UserProfile::new);
    }

    @PutMapping(path = "user/profile",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public static UserProfile updateProfile(@RequestBody User user) {
        if (user.updateProfile(user.getProfile())) {
            return user.getProfile();
        } else {
            return new UserProfile();
        }
    }

    @PostMapping(path = "user/account",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public static User getAccount(@RequestBody User user) {
        Optional<String> accountInfo = user.receiveAccountInfo();
        if (accountInfo.isPresent()) {
            return user;
        } else {
            return new User();
        }
    }

    @PutMapping(path = "user/account",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public static User updateAccount(@RequestBody User user) {
        if (user.updateAccountInfo(user.getFullname(), user.getPassword())) {
            return user;
        } else {
            return new User();
        }
    }
}
