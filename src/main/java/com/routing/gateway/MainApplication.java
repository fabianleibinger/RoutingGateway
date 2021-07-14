package com.routing.gateway;

import com.routing.gateway.models.Coordinate;
import com.routing.gateway.routingservices.adapters.OpenRouteService;
import com.routing.gateway.routingservices.adapters.OpenTripPlanner;
import com.routing.gateway.routingservices.adapters.Valhalla;
import com.routing.gateway.routingservices.requests.parameters.OpenRouteServiceParameters.OpenRouteServiceParameters;
import com.routing.gateway.routingservices.requests.parameters.OpenTripPlannerParameters.OpenTripPlannerParameters;
import com.routing.gateway.routingservices.requests.OpenRouteServiceRequest;
import com.routing.gateway.routingservices.requests.OpenTripPlannerRequest;
import com.routing.gateway.routingservices.requests.ValhallaRequest;
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

		OpenRouteServiceRequest orsRequest = new OpenRouteServiceRequest("cycling-regular", parameters);

		OpenRouteService ors = new OpenRouteService();
		ors.receiveResponse(orsRequest);

		/**
		 * OTP
		 */
		OpenTripPlannerParameters otpParameters = new OpenTripPlannerParameters();
		OpenTripPlannerRequest otpRequest = new OpenTripPlannerRequest(otpParameters);
		OpenTripPlanner otp = new OpenTripPlanner();
		otp.receiveResponse(otpRequest);

		/**
		 * Valhalla
		 */
		ValhallaRequest valhallaRequest = new ValhallaRequest();
		Valhalla valhalla = new Valhalla();
		valhalla.receiveResponse(valhallaRequest);
	}

}
