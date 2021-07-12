package com.routing.connector;

import com.routing.connector.models.Coordinate;
import com.routing.connector.routingservices.adapters.OpenRouteService;
import com.routing.connector.routingservices.adapters.OpenTripPlanner;
import com.routing.connector.routingservices.parameters.JsonParameters;
import com.routing.connector.routingservices.parameters.OpenRouteServiceParameters.OpenRouteServiceParameters;
import com.routing.connector.routingservices.parameters.OpenTripPlannerParameters.OpenTripPlannerParameters;
import com.routing.connector.routingservices.requests.OpenRouteServiceRequest;
import com.routing.connector.routingservices.requests.OpenTripPlannerRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);

		/**
		 * ORS
		 */
		List<Coordinate> coordinates = new ArrayList<>();
		coordinates.add(new Coordinate(8.681495, 49.41461));
		coordinates.add(new Coordinate(8.686507, 49.41943));
		OpenRouteServiceParameters parameters = new OpenRouteServiceParameters();
		parameters.addCoordinates(coordinates);

		parameters.getOptions().getProfileParams().getWeightings().setSteepnessDifficulty(2);

		OpenRouteServiceRequest request = new OpenRouteServiceRequest("cycling-regular", parameters);

		OpenRouteService routingService = new OpenRouteService();
		routingService.receiveResponse(request);

		String json = parameters.toJson();
		OpenRouteServiceParameters fromJson = JsonParameters.fromJson(json, OpenRouteServiceParameters.class);

		System.out.println(fromJson.getOptions().getProfileParams().getWeightings().getSteepnessDifficulty());

		/**
		 * OTP
		 */
		OpenTripPlannerParameters otpParameters = new OpenTripPlannerParameters();
		OpenTripPlannerRequest otpRequest = new OpenTripPlannerRequest(otpParameters);
		OpenTripPlanner otp = new OpenTripPlanner();
		otp.receiveResponse(otpRequest);
	}

}
