package com.routing.gateway.preferenceservice;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
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

    public String toLogInBodyFormat() {
        return "grant_type=" + "password" + "&username=" + this.username + "&password=" + this.password;
    }

    public String logIn() throws IOException, InterruptedException {
        String clientId = this.username;
        String clientSecret = this.password;
        String toEncode = clientId + ":" + clientSecret;
        String encoded = new String(Base64.getEncoder().encode(toEncode.getBytes()));
        System.out.println("Basic " + encoded);

        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://regiomove.fzi.de/backend/oauth/tocken"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Authorization", "Basic " + encoded)
                .timeout(Duration.ofSeconds(35))
                .POST(HttpRequest.BodyPublishers.ofString(this.toLogInBodyFormat()))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());
        return response.body();
    }

    public String toSignUpBodyFormat() {
        return "username=" + this.username + "&fullname=" + this.fullName + "&password=" + this.password;
    }

    public Optional<String> signup() {
        HttpPreferenceService httpService = new HttpPreferenceService();
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        return httpService.postRequest("signup", headers, this.toSignUpBodyFormat());
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
