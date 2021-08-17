package com.routing.gateway.preferenceservice;

import com.google.gson.Gson;
import com.routing.gateway.preferenceservice.mobilitypreferences.AccessToken;
import com.routing.gateway.preferenceservice.mobilitypreferences.Account;
import com.routing.gateway.preferenceservice.mobilitypreferences.PreferenceProfile;
import com.routing.gateway.preferenceservice.mobilitypreferences.UserProfile;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User of the preference service.
 */
public class User {
    //Needed for login.
    private static final String CLIENT_ID = "hspf";
    private static final String CLIENT_SECRET = "regio_move_hspf";

    private String username;
    private String fullname;
    private String password;
    private AccessToken accessToken;
    private PreferenceProfile preferenceProfile;
    private UserProfile profile;

    /**
     * Tries to signup user.
     *
     * @return isSignedUp
     */
    public Boolean signup() {
        if (checkUsername()) {
            HttpPreferenceService httpService = new HttpPreferenceService();
            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/x-www-form-urlencoded");
            Optional<String> responseBody = httpService.postRequest("signup", headers, this.toSignupBodyFormat());
            if (responseBody.isPresent()) {
                System.out.println("User " + this.username + " is registered.");
                return true;
            } else {
                System.out.println("User " + this.username + " could not be registered.");
            }
        }
        return false;
    }

    /**
     * Checks if the username conforms to preference service specifications.
     *
     * @return isCorrectFormat
     */
    public Boolean checkUsername() {
        Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(this.username);
        return matcher.find();
    }

    /**
     * Returns the request body format for signup.
     *
     * @return request body format
     */
    public String toSignupBodyFormat() {
        return "username=" + this.username + "&fullname=" + this.fullname + "&password=" + this.password;
    }

    /**
     * Tries to login user.
     *
     * @return isLoggedIn
     */
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

    /**
     * Tries to receive an access token for login.
     *
     * @return Optional response body
     */
    public Optional<String> receiveToken() {
        String toEncode = CLIENT_ID + ":" + CLIENT_SECRET;
        String encoded = new String(Base64.getEncoder().encode(toEncode.getBytes()));

        HttpPreferenceService httpService = new HttpPreferenceService();
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        headers.put("Authorization", "Basic " + encoded);
        return httpService.postRequest("oauth/token", headers, this.toReceiveTokenBodyFormat());
    }

    /**
     * Returns the request body format for receive token.
     *
     * @return request body format
     */
    public String toReceiveTokenBodyFormat() {
        return "grant_type=" + "password" + "&username=" + this.username + "&password=" + this.password;
    }

    /**
     * Returns the authorization header value, that is needed for most requests.
     *
     * @return authorization header value
     */
    public String getAuthorizationHeaderValue() {
        try {
            return this.accessToken.getToken_type() + " " + this.accessToken.getAccess_token();
        } catch (NullPointerException e) {
            System.out.println("Login first to receive token.");
            return "";
        }

    }

    /**
     * Tries to add a new preference profile to the user.
     *
     * @param preferenceProfile
     * @return isAdded
     */
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

    /**
     * Tries to receive a preference profile of the user.
     *
     * @param name of the preference profile
     * @return Optional preference profile
     */
    public Optional<PreferenceProfile> receivePreferenceProfileByName(String name) {
        HttpPreferenceService httpService = new HttpPreferenceService();
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", this.getAuthorizationHeaderValue());
        Optional<String> responseBody = httpService.getRequest("user/preferenceProfiles/" + name, headers);
        if (responseBody.isPresent()) {
            this.preferenceProfile = new Gson().fromJson(responseBody.get(), PreferenceProfile.class);
            System.out.println("Received preference profile successfully.");
            return Optional.of(this.preferenceProfile);
        } else {
            System.out.println("Failed to receive preference profile.");
        }
        return Optional.empty();
    }

    /**
     * Tries to update a preference profile of the user.
     *
     * @param preferenceProfile
     * @return isUpdated
     */
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

    /**
     * Tries to receive the user profile of the user.
     *
     * @return Optional user profile
     */
    public Optional<UserProfile> receiveProfile() {
        HttpPreferenceService httpService = new HttpPreferenceService();
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", this.getAuthorizationHeaderValue());
        Optional<String> responseBody = httpService.getRequest("user", headers);
        if (responseBody.isPresent()) {
            this.profile = new Gson().fromJson(responseBody.get(), UserProfile.class);
            System.out.println("Received user profile successfully.");
            return Optional.of(this.profile);
        } else {
            System.out.println("Failed to receive user profile.");
        }
        return Optional.empty();
    }

    /**
     * Tries to update the user profile of the user.
     *
     * @param profile
     * @return isUpdated
     */
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

    /**
     * Tries to receive the account info of the user.
     *
     * @return Optional account
     */
    public Optional<Account> receiveAccountInfo() {
        HttpPreferenceService httpService = new HttpPreferenceService();
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", this.getAuthorizationHeaderValue());
        Optional<String> responseBody = httpService.getRequest("account", headers);
        if (responseBody.isPresent()) {
            Account info = new Gson().fromJson(responseBody.get(), Account.class);
            this.fullname = info.getFullname();
            this.username = info.getUsername();
            System.out.println("Received account information successfully.");
            return Optional.of(info);
        } else {
            System.out.println("Failed to receive account information.");
        }
        return Optional.empty();
    }

    /**
     * Tries to update the account info of the user.
     *
     * @param fullname
     * @param password
     * @return Optional account
     */
    public Optional<Account> updateAccountInfo(String fullname, String password) {
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
            return Optional.of(info);
        } else {
            System.out.println("Failed to update user account.");
            return Optional.empty();
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

    /**
     * Updates the fullname of the user.
     *
     * @param fullname
     */
    public void updateFullname(String fullname) {
        this.updateAccountInfo(fullname, this.password);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Updates the password of the user.
     *
     * @param password
     */
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
