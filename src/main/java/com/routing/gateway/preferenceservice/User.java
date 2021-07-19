package com.routing.gateway.preferenceservice;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

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
        return "grant_type" + "password" + "&username=" + this.username + "&password=" + this.password;
    }

    public String toSignUpBodyFormat() {
        return "username=" + this.username + "&fullname=" + this.fullName + "&password=" + this.password;
    }

    public String signup() {
        HttpService httpService = new HttpService();
        HttpClient httpClient = httpService.getHttpClient();
        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://regiomove.fzi.de:8080/signup"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .timeout(Duration.ofSeconds(35))
                .POST(HttpRequest.BodyPublishers.ofString(this.toSignUpBodyFormat()))
                .build();
        try {
            HttpResponse<String> response = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            System.out.println(response.body());
            return response.body();
        } catch (IOException | InterruptedException e) {
            System.out.println("Couldn't receive response.");
            return "";
        }
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
