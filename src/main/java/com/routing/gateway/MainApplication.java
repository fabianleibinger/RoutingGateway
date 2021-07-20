package com.routing.gateway;

import com.routing.gateway.models.Coordinate;
import com.routing.gateway.routingservices.RoutingRequest;
import com.routing.gateway.routingservices.adapters.OpenRouteService;
import com.routing.gateway.routingservices.adapters.OpenTripPlanner;
import com.routing.gateway.routingservices.adapters.Valhalla;
import com.routing.gateway.routingservices.requests.parameters.openrouteserviceparameters.OpenRouteServiceParameters;
import com.routing.gateway.routingservices.requests.parameters.opentripplannerparameters.OpenTripPlannerParameters;
import com.routing.gateway.routingservices.requests.OpenRouteServiceRequest;
import com.routing.gateway.routingservices.requests.OpenTripPlannerRequest;
import com.routing.gateway.routingservices.requests.ValhallaRequest;
import com.routing.gateway.routingservices.requests.parameters.valhallaparameters.ValhallaLocation;
import com.routing.gateway.routingservices.requests.parameters.valhallaparameters.ValhallaParameters;
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
		Coordinate start = new Coordinate(8.681495, 49.41461);
		Coordinate destination = new Coordinate(8.686507, 49.41943);
		coordinates.add(start);
		coordinates.add(destination);
		OpenRouteServiceParameters parameters = new OpenRouteServiceParameters();
		parameters.addCoordinates(coordinates);

		parameters.getOptions().getProfileParams().getWeightings().setSteepnessDifficulty(2);
		OpenRouteServiceRequest orsRequest = new OpenRouteServiceRequest("cycling-regular", parameters);
		RoutingRequest request = new RoutingRequest(start, destination, orsRequest);

		OpenRouteService ors = new OpenRouteService();
		ors.computeRoute(request);

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
		ValhallaParameters valhallaParameters = new ValhallaParameters();
		ValhallaLocation startLocation = new ValhallaLocation();
		ValhallaLocation destinationLocation = new ValhallaLocation();
		startLocation.setLat(8.681495);
		startLocation.setLon(49.41461);
		destinationLocation.setLat(8.686507);
		destinationLocation.setLon(49.41943);
		valhallaParameters.getLocations().add(startLocation);
		valhallaParameters.getLocations().add(destinationLocation);
		valhallaParameters.setCosting("auto");
		ValhallaRequest valhallaRequest = new ValhallaRequest(valhallaParameters);
		Valhalla valhalla = new Valhalla();
		valhalla.receiveResponse(valhallaRequest);
	}

}
