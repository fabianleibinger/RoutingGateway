package com.routing.gateway.preferenceservice.controllers;

import com.routing.gateway.preferenceservice.User;
import com.routing.gateway.preferenceservice.controllers.exceptions.BadGatewayException;
import com.routing.gateway.preferenceservice.mobilitypreferences.Account;
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

    /**
     * Signs up user or throws BadGatewayException.
     *
     * @param user User; username, fullname and password required
     * @return user
     */
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

    /**
     * Logs user in or throws BadGatewayException.
     *
     * @param user User; username and password required
     * @return user including accessToken
     */
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

    /**
     * Returns user profile or throws BadGatewayException.
     *
     * @param user User; accessToken required
     * @return user profile
     */
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

    /**
     * Updates user profile or throws BadGatewayException.
     *
     * @param user User; accessToken and profile required
     * @return profile UserProfile
     */
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

    /**
     * Returns accountInfo or throws BadGatewayException.
     *
     * @param user User; accessToken required
     * @return account
     */
    @PostMapping(path = "account",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public static Account getAccountInfo(@RequestBody User user) {
        Optional<Account> accountInfo = user.receiveAccountInfo();
        if (accountInfo.isPresent()) {
            return accountInfo.get();
        } else {
            throw new BadGatewayException("Failed to receive account info.");
        }
    }

    /**
     * Updates accountInfo or throws BadGatewayException.
     *
     * @param user User; fullname, password and accessToken required
     * @return account
     */
    @PutMapping(path = "account",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public static Account updateAccountInfo(@RequestBody User user) {
        Optional<Account> accountInfo = user.updateAccountInfo(user.getFullname(), user.getPassword());
        if (accountInfo.isPresent()) {
            return accountInfo.get();
        } else {
            throw new BadGatewayException("Failed to update user account.");
        }
    }
}
