package com.routing.gateway.preferenceservice;

import com.google.gson.Gson;
import com.routing.gateway.preferenceservice.mobilitypreferences.ComfortFactors;
import com.routing.gateway.preferenceservice.mobilitypreferences.PreferenceProfile;

import java.util.*;

public class User {
    private static final String CLIENT_ID = "hspf";
    private static final String CLIENT_SECRET = "regio_move_hspf";

    private String username;
    private String fullName;
    private String password;
    private AccessToken accessToken;
    private ComfortFactors comfortFactors;
    private PreferenceProfile preferenceProfile;

    public void login() {
        Optional<String> responseBody = this.receiveToken();
        if (responseBody.isPresent()) {
            this.accessToken = new Gson().fromJson(responseBody.get(), AccessToken.class);
            System.out.println("User " + this.username + " logged in.");
        } else {
            System.out.println("Login failed for user " + this.username + ".");
        }
    }

    public Optional<String> receiveToken() {
        String toEncode = CLIENT_ID + ":" + CLIENT_SECRET;
        String encoded = new String(Base64.getEncoder().encode(toEncode.getBytes()));

        HttpPreferenceService httpService = new HttpPreferenceService();
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        headers.put("Authorization", "Basic " + encoded);
        return httpService.postRequest("oauth/token", headers, this.toReceiveTokenBodyFormat());
    }

    public String toReceiveTokenBodyFormat() {
        return "grant_type=" + "password" + "&username=" + this.username + "&password=" + this.password;
    }

    public void signup() {
        HttpPreferenceService httpService = new HttpPreferenceService();
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        Optional<String> responseBody = httpService.postRequest("signup", headers, this.toSignupBodyFormat());
        if (responseBody.isPresent()) {
            System.out.println("User " + this.username + " is registered.");
        } else {
            System.out.println("User " + this.username + " could not be registered.");
        }
    }

    public String toSignupBodyFormat() {
        return "username=" + this.username + "&fullname=" + this.fullName + "&password=" + this.password;
    }

    public String getAuthorizationHeaderValue() {
        return this.accessToken.getToken_type() + " " + this.accessToken.getAccess_token();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccessToken getAccessToken() {
        if (this.accessToken == null) {
            this.accessToken = new AccessToken();
        }
        return accessToken;
    }

    public void setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
    }
}
