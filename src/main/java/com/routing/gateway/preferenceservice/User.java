package com.routing.gateway.preferenceservice;

import java.util.*;

public class User {
    private String username;
    private String fullName;
    private String password;

    public User(String username, String fullName, String password) {
        this.username = username;
        this.fullName = fullName;
        this.password = password;
    }

    public String toLoginBodyFormat() {
        return "grant_type=" + "password" + "&username=" + this.username + "&password=" + this.password;
    }

    //TODO: fix clientid and clientsecret encoding
    public Optional<String> login() {
        String clientId = this.username;
        String clientSecret = this.password;
        String toEncode = clientId + ":" + clientSecret;
        String encoded = new String(Base64.getEncoder().encode(toEncode.getBytes()));
        System.out.println("Basic " + encoded);

        HttpPreferenceService httpService = new HttpPreferenceService();
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        headers.put("Authorization", "Basic " + encoded);
        return httpService.postRequest("oauth/tocken", headers, this.toLoginBodyFormat());
    }

    public String toSignupBodyFormat() {
        return "username=" + this.username + "&fullname=" + this.fullName + "&password=" + this.password;
    }

    public Optional<String> signup() {
        HttpPreferenceService httpService = new HttpPreferenceService();
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        return httpService.postRequest("signup", headers, this.toSignupBodyFormat());
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
}
