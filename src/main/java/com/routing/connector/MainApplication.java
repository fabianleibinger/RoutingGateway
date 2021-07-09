package com.routing.connector;

import com.routing.connector.models.Coordinate;
import com.routing.connector.routingservices.adapters.OpenRouteService;
import com.routing.connector.routingservices.parameters.OpenRouteServiceParameters.OpenRouteServiceParameters;
import com.routing.connector.routingservices.requests.OpenRouteServiceRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);

		List<Coordinate> coordinates = new ArrayList<>();
		coordinates.add(new Coordinate(8.681495, 49.41461));
		coordinates.add(new Coordinate(8.686507, 49.41943));
		OpenRouteServiceParameters parameters = new OpenRouteServiceParameters(coordinates);

		parameters.getOptions().getProfileParams().getWeightings().setSteepnessDifficulty(2);

		OpenRouteServiceRequest request = new OpenRouteServiceRequest("cycling-regular", parameters);

		OpenRouteService routingService = new OpenRouteService();
		routingService.receiveResponse(request);

		parameters.toJson();
	}

}
