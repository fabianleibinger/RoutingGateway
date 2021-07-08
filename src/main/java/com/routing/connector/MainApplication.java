package com.routing.connector;

import com.routing.connector.models.Coordinate;
import com.routing.connector.routingservices.adapters.OpenRouteService;
import com.routing.connector.routingservices.requests.OpenRouteServiceParameters;
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
		coordinates.add(new Coordinate(8.687872, 49.420318));
		OpenRouteServiceParameters parameters = new OpenRouteServiceParameters(coordinates);

		OpenRouteServiceRequest request = new OpenRouteServiceRequest("driving-car", parameters);

		OpenRouteService routingService = new OpenRouteService();
		routingService.receiveResponse(request);
	}

}
