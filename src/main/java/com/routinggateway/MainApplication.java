package com.routinggateway;

import com.google.maps.model.LatLng;
import com.routinggateway.routingservices.requests.StandardRoutingRequest;
import com.routinggateway.clients.travelinformationapp.controller.models.RoutingResult;
import com.routinggateway.clients.travelinformationapp.adapters.OpenRouteService;
import com.routinggateway.clients.travelinformationapp.adapters.OpenTripPlanner;
import com.routinggateway.clients.travelinformationapp.adapters.Valhalla;
import com.routinggateway.routingservices.requests.parameters.openrouteserviceparameters.OpenRouteServiceParameters;
import com.routinggateway.routingservices.requests.parameters.opentripplannerparameters.OpenTripPlannerParameters;
import com.routinggateway.routingservices.requests.OpenRouteServiceRequest;
import com.routinggateway.routingservices.requests.OpenTripPlannerRequest;
import com.routinggateway.routingservices.requests.ValhallaRequest;
import com.routinggateway.routingservices.requests.parameters.valhallaparameters.ValhallaLocation;
import com.routinggateway.routingservices.requests.parameters.valhallaparameters.ValhallaParameters;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);

		/*LatLng start = new LatLng(8.681495, 49.41461);
		LatLng destination = new LatLng(8.686507, 49.41943);
		Double[] startCoord = {start.lat, start.lng};
		Double[] destCoord = {destination.lat, destination.lng};
		List<Double[]> coordList = new ArrayList<>();
		coordList.add(startCoord);
		coordList.add(destCoord);

		/**
		 * ORS
		 */
		/*OpenRouteServiceParameters parameters = new OpenRouteServiceParameters();
		parameters.setCoordinates(coordList);

		parameters.getOptions().getProfile_params().getWeightings().setSteepness_difficulty(2);
		OpenRouteServiceRequest orsRequest = new OpenRouteServiceRequest();
		orsRequest.setProfile("cycling-regular");
		orsRequest.setParameters(parameters);
		StandardRoutingRequest request = new StandardRoutingRequest(start, destination, orsRequest, new OpenRouteService());
		Optional<List<RoutingResult>> result = request.send();
		if (result.isPresent()) {
			System.out.println(result.get().get(0).getDistanceInMeters());
		}

		/**
		 * OTP
		 */
		/*OpenTripPlannerParameters otpParameters = new OpenTripPlannerParameters();

		OpenTripPlannerRequest otpRequest = new OpenTripPlannerRequest();
		otpRequest.setParameters(otpParameters);
		request = new StandardRoutingRequest(start, destination, otpRequest, new OpenTripPlanner());
		result = request.send();
		if (result.isPresent()) {
			System.out.println(result.get().get(0).getDistanceInMeters());
		}

		/**
		 * Valhalla
		 */
		/*ValhallaParameters valhallaParameters = new ValhallaParameters();
		ValhallaLocation startLocation = new ValhallaLocation();
		ValhallaLocation destinationLocation = new ValhallaLocation();
		startLocation.setLat(8.681495);
		startLocation.setLon(49.41461);
		destinationLocation.setLat(8.686507);
		destinationLocation.setLon(49.41943);
		valhallaParameters.getLocations().add(startLocation);
		valhallaParameters.getLocations().add(destinationLocation);
		valhallaParameters.setCosting("auto");
		ValhallaRequest valhallaRequest = new ValhallaRequest();
		valhallaRequest.setParameters(valhallaParameters);
		Valhalla valhalla = new Valhalla();
		valhalla.receiveResponse(valhallaRequest);*/
	}

}
