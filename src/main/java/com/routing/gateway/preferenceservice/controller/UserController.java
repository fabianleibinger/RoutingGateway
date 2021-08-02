package com.routing.gateway.preferenceservice.controller;

import com.routing.gateway.preferenceservice.User;
import com.routing.gateway.preferenceservice.mobilitypreferences.PreferenceProfile;
import com.routing.gateway.preferenceservice.mobilitypreferences.UserProfile;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @PostMapping(path = "user/signup",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public static User signup(@RequestBody User user) {

    }

    @PostMapping(path = "user/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public static User login(@RequestBody User user) {

    }

    @PostMapping(path = "user/preferenceProfiles/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public static PreferenceProfile addPreferenceProfile(@RequestBody User user) {

    }

    @PostMapping(path = "user/preferenceProfiles/{name}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public static PreferenceProfile getSpecificPreferenceProfile(@RequestBody User user, @PathVariable String name) {

    }

    @PutMapping(path = "user/preferenceProfiles/{name}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public static PreferenceProfile updateSpecificPreferenceProfile(@RequestBody User user, @PathVariable String name) {

    }

    @PostMapping(path = "user/profile",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public static UserProfile getProfile(@RequestBody User user) {

    }

    @PutMapping(path = "user/profile",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public static UserProfile updateProfile(@RequestBody User user) {

    }

    @PostMapping(path = "user/account",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public static User getAccount(@RequestBody User user) {

    }

    @PutMapping(path = "user/account",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public static User updateAccount(@RequestBody User user) {

    }
}
