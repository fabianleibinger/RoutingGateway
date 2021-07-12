package com.routing.connector;

import com.routing.connector.models.Coordinate;
import com.routing.connector.routingservices.adapters.OpenRouteService;
import com.routing.connector.routingservices.adapters.OpenTripPlanner;
import com.routing.connector.routingservices.parameters.OpenRouteServiceParameters.OpenRouteServiceParameters;
import com.routing.connector.routingservices.parameters.OpenTripPlannerParameters.OpenTripPlannerParameters;
import com.routing.connector.routingservices.requests.OpenRouteServiceServiceRequest;
import com.routing.connector.routingservices.requests.OpenTripPlannerServiceRequest;
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

		OpenRouteServiceServiceRequest orsRequest = new OpenRouteServiceServiceRequest("cycling-regular", parameters);

		OpenRouteService ors = new OpenRouteService();
		ors.receiveResponse(orsRequest);

		/**
		 * OTP
		 */
		OpenTripPlannerParameters otpParameters = new OpenTripPlannerParameters();
		OpenTripPlannerServiceRequest otpRequest = new OpenTripPlannerServiceRequest(otpParameters);
		OpenTripPlanner otp = new OpenTripPlanner();
		otp.receiveResponse(otpRequest);
	}

}
