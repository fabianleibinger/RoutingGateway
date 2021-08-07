package com.routing.gateway.preferenceservice;

import com.google.gson.Gson;
import com.routing.gateway.preferenceservice.mobilitypreferences.AccessToken;
import com.routing.gateway.preferenceservice.mobilitypreferences.Account;
import com.routing.gateway.preferenceservice.mobilitypreferences.PreferenceProfile;
import com.routing.gateway.preferenceservice.mobilitypreferences.UserProfile;

import java.util.*;

/**
 * User of the preference service.
 */
public class User {
    private static final String CLIENT_ID = "hspf";
    private static final String CLIENT_SECRET = "regio_move_hspf";

    private String username;
    private String fullname;
    private String password;
    private AccessToken accessToken;
    private PreferenceProfile preferenceProfile;
    private UserProfile profile;

    public Boolean signup() {
        HttpPreferenceService httpService = new HttpPreferenceService();
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        Optional<String> responseBody = httpService.postRequest("signup", headers, this.toSignupBodyFormat());
        if (responseBody.isPresent()) {
            System.out.println("User " + this.username + " is registered.");
            return true;
        } else {
            System.out.println("User " + this.username + " could not be registered.");
            return false;
        }
    }

    public String toSignupBodyFormat() {
        return "username=" + this.username + "&fullname=" + this.fullname + "&password=" + this.password;
    }

    public Boolean login() {
        Optional<String> responseBody = this.receiveToken();
        if (responseBody.isPresent()) {
            this.accessToken = new Gson().fromJson(responseBody.get(), AccessToken.class);
            System.out.println("User " + this.username + " logged in.");
            return true;
        } else {
            System.out.println("Login failed for user " + this.username + ".");
            return false;
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

    public String getAuthorizationHeaderValue() {
        try {
            return this.accessToken.getToken_type() + " " + this.accessToken.getAccess_token();
        } catch (NullPointerException e) {
            System.out.println("Login first to receive token.");
            return "";
        }

    }

    public Boolean addPreferenceProfileToService(PreferenceProfile preferenceProfile) {
        HttpPreferenceService httpService = new HttpPreferenceService();
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", this.getAuthorizationHeaderValue());
        Optional<String> responseBody
                = httpService.postRequest("user/preferenceProfiles", headers, preferenceProfile.toJson());
        if (responseBody.isPresent()) {
            this.preferenceProfile = preferenceProfile;
            System.out.println("Added preference profile successfully.");
            return true;
        } else {
            System.out.println("Failed to add preference profile.");
            return false;
        }
    }

    public Optional<PreferenceProfile> receivePreferenceProfileByName(String name) {
        HttpPreferenceService httpService = new HttpPreferenceService();
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", this.getAuthorizationHeaderValue());
        Optional<String> responseBody = httpService.getRequest("user/preferenceProfiles/" + name, headers);
        if (responseBody.isPresent()) {
            this.preferenceProfile = new Gson().fromJson(responseBody.get(), PreferenceProfile.class);
            System.out.println("Received preference profile successfully.");
            return Optional.of(this.preferenceProfile);
        } else  {
            System.out.println("Failed to receive preference profile.");
        }
        return Optional.empty();
    }

    public Boolean updatePreferenceProfile(PreferenceProfile preferenceProfile) {
        HttpPreferenceService httpService = new HttpPreferenceService();
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", this.getAuthorizationHeaderValue());
        Optional<String> responseBody
                = httpService.putRequest("user/preferenceProfiles/" + preferenceProfile.getProfileName(),
                headers, preferenceProfile.toJson());
        if (responseBody.isPresent()) {
            this.preferenceProfile = preferenceProfile;
            System.out.println("Updated preference profile successfully.");
            return true;
        } else {
            System.out.println("Failed to update preference profile.");
            return false;
        }
    }

    public Optional<UserProfile> receiveProfile() {
        HttpPreferenceService httpService = new HttpPreferenceService();
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", this.getAuthorizationHeaderValue());
        Optional<String> responseBody = httpService.getRequest("user", headers);
        if (responseBody.isPresent()) {
            this.profile = new Gson().fromJson(responseBody.get(), UserProfile.class);
            System.out.println("Received user profile successfully.");
            return Optional.of(this.profile);
        } else  {
            System.out.println("Failed to receive user profile.");
        }
        return Optional.empty();
    }

    public Boolean updateProfile(UserProfile profile) {
        HttpPreferenceService httpService = new HttpPreferenceService();
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", this.getAuthorizationHeaderValue());
        Optional<String> responseBody = httpService.putRequest("user", headers, profile.toJson());
        if (responseBody.isPresent()) {
            this.profile = profile;
            System.out.println("Updated user profile successfully.");
            return true;
        } else {
            System.out.println("Failed to update user profile.");
            return false;
        }
    }

    public Optional<Account> receiveAccountInfo() {
        HttpPreferenceService httpService = new HttpPreferenceService();
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", this.getAuthorizationHeaderValue());
        Optional<String> responseBody = httpService.getRequest("account", headers);
        if (responseBody.isPresent()) {
            Account info = new Gson().fromJson(responseBody.get(), Account.class);
            this.fullname = info.getFullname();
            this.username = info.getUsername();
            System.out.println("Received fullname successfully.");
            return Optional.of(info);
        } else  {
            System.out.println("Failed to receive fullname.");
        }
        return Optional.empty();
    }

    public Boolean updateAccountInfo(String fullname, String password) {
        HttpPreferenceService httpService = new HttpPreferenceService();
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", this.getAuthorizationHeaderValue());
        String jsonBody = "{\"fullname\": \"" + fullname + "\", \"password\": \"" + password + "\"}";
        Optional<String> responseBody = httpService.putRequest("account", headers, jsonBody);
        if (responseBody.isPresent()) {
            Account info = new Gson().fromJson(responseBody.get(), Account.class);
            this.fullname = info.getFullname();
            this.password = password;
            System.out.println("Updated user account successfully.");
            return true;
        } else {
            System.out.println("Failed to update user account.");
            return false;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void updateFullname(String fullname) {
        this.updateAccountInfo(fullname, this.password);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void updatePassword(String password) {
        this.updateAccountInfo(this.fullname, password);
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

    public PreferenceProfile getPreferenceProfile() {
        if (this.preferenceProfile == null) {
            this.preferenceProfile = new PreferenceProfile();
        }
        return this.preferenceProfile;
    }

    public void setPreferenceProfile(PreferenceProfile preferenceProfile) {
        this.preferenceProfile = preferenceProfile;
    }

    public UserProfile getProfile() {
        if (this.profile == null) {
            this.profile = new UserProfile();
        }
        return profile;
    }

    public void setProfile(UserProfile profile) {
        this.profile = profile;
    }
}
