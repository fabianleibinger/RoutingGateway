package com.routing.gateway.preferenceservice.controller;

import com.routing.gateway.preferenceservice.User;
import com.routing.gateway.preferenceservice.controller.exceptions.BadGatewayException;
import com.routing.gateway.preferenceservice.mobilitypreferences.UserProfile;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Controller that handles all requests related users. Preference profiles are handled separately.
 */
@RestController
@RequestMapping("user")
public class UserController {

    //TODO correct request response types

    @PostMapping(path = "signup",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public static User signup(@RequestBody User user) {
        if (user.signup()) {
            return user;
        } else {
            throw new BadGatewayException("User could not be registered.");
        }
    }

    @PostMapping(path = "login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public static User login(@RequestBody User user) {
        if (user.login()) {
            return user;
        } else {
            throw new BadGatewayException("Failed to login.");
        }
    }

    @PostMapping(path = "profile",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public static UserProfile getProfile(@RequestBody User user) {
        Optional<UserProfile> userProfile = user.receiveProfile();
        if (userProfile.isPresent()) {
            return userProfile.get();
        } else {
            throw new BadGatewayException("Failed to receive user profile.");
        }
    }

    @PutMapping(path = "profile",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public static UserProfile updateProfile(@RequestBody User user) {
        if (user.updateProfile(user.getProfile())) {
            return user.getProfile();
        } else {
            throw new BadGatewayException("Failed to update user profile.");
        }
    }

    @PostMapping(path = "account",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public static User getAccount(@RequestBody User user) {
        Optional<String> accountInfo = user.receiveAccountInfo();
        if (accountInfo.isPresent()) {
            return user;
        } else {
            throw new BadGatewayException("Failed to receive account info.");
        }
    }

    @PutMapping(path = "account",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public static User updateAccount(@RequestBody User user) {
        if (user.updateAccountInfo(user.getFullname(), user.getPassword())) {
            return user;
        } else {
            throw new BadGatewayException("Failed to update user account.");
        }
    }
}
