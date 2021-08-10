package com.routing.gateway.clients.travelinformationapp.adapters;

import com.google.gson.Gson;
import com.google.maps.model.EncodedPolyline;
import com.google.maps.model.LatLng;
import com.routing.gateway.routingservices.requests.RoutingRequest;
import com.routing.gateway.clients.travelinformationapp.controller.RoutingResult;
import com.routing.gateway.clients.travelinformationapp.controller.RoutingResultSegment;
import com.routing.gateway.routingservices.requests.ValhallaRequest;
import com.routing.gateway.routingservices.responses.valhallaresponse.ValhallaLeg;
import com.routing.gateway.routingservices.responses.valhallaresponse.ValhallaManeuver;
import com.routing.gateway.routingservices.responses.valhallaresponse.ValhallaResponse;
import com.routing.gateway.routingservices.responses.valhallaresponse.ValhallaSummary;
import org.apache.http.client.utils.URIBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

/**
 * Adapter for Valhalla.
 */
public class Valhalla implements IRoutingService<ValhallaRequest, ValhallaResponse> {
    private static final String NAME = "Valhalla";
    private static final String URL = "http://se-elsbeere:8002/route";

    /**
     * Returns a routing result for a Valhalla request.
     * @param request RoutingRequest
     * @return Optional List RoutingResult
     */
    @Override
    public Optional<List<RoutingResult>> computeRoute(RoutingRequest request) {
        Optional<String> responseOptional;
        if (request.getRequest().getClass() == ValhallaRequest.class) {
            responseOptional = this.receiveResponse((ValhallaRequest) request.getRequest());
        } else {
            System.out.println("Wrong RoutingRequest type provided.");
            return Optional.empty();
        }
        if (responseOptional.isPresent()) {
            String response = responseOptional.get();
            ValhallaResponse responseObject = new Gson().fromJson(response, ValhallaResponse.class);
            List<RoutingResult> routingResults = this.extractRoutingResult(responseObject);
            if (!routingResults.isEmpty()) {
                return Optional.of(routingResults);
            } else {
                System.out.println("No routes found for the given request");
            }
        }
        return Optional.empty();
    }

    /**
     * Sends GET request to Valhalla and tries to receive a HTTP response.
     * @param valhallaRequest for Valhalla
     * @return Optional String: response body that includes a route.
     */
    @Override
    public Optional<String> receiveResponse(ValhallaRequest valhallaRequest) {
        try {
            URI uri = buildURI(valhallaRequest.serialize());
            URL obj = new URL(uri.toString());
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            int responseCode = connection.getResponseCode();
            System.out.println(responseCode);
            if (responseCode != OK_STATUS_CODE) {
                System.out.println("Status Code " + responseCode);
                return Optional.empty();
            }
            String result = null;
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                result = sb.toString();
                br.close();
            } catch (IOException e) {
                System.out.println("Failed to read response.");
            }
            connection.disconnect();
            if (result != null) {
                return Optional.of(result);
            }
        } catch (IOException e) {
            System.out.println("Failed to receive response.");
        }
        return Optional.empty();
    }

    /**
     * Returns a list of routes from the valhallaResponse. List might be empty.
     * @param valhallaResponse
     * @return routes List of RoutingResult
     */
    @Override
    public List<RoutingResult> extractRoutingResult(ValhallaResponse valhallaResponse) {
        List<RoutingResult> routes = new ArrayList<>();

        List<LatLng> polyline = new ArrayList<>();
        ValhallaSummary summary = valhallaResponse.getTrip().getSummary();
        Double durationInMinutes = summary.getTime();
        Double distanceInMeters = summary.getLength() * 1000;
        List<String> instructions = new ArrayList<>();
        List<RoutingResultSegment> segments = new ArrayList<>();
        for (ValhallaLeg leg : valhallaResponse.getTrip().getLegs()) {
            RoutingResultSegment segment = this.extractRoutingResultSegment(leg);
            segments.add(segment);
            for (LatLng latLng : segment.getPolyline()) {
                polyline.add(latLng);
            }
            for (String instruction : segment.getInstructions()) {
                instructions.add(instruction);
            }
        }

        return routes;
    }

    /**
     * Returns a route segment from the ValhallaLeg.
     * @param leg ValhallaLeg
     * @return RoutingResultSegment
     */
    public RoutingResultSegment extractRoutingResultSegment(ValhallaLeg leg) {
        EncodedPolyline encodedPolyline = new EncodedPolyline(leg.getShape());
        List<LatLng> polyline = encodedPolyline.decodePath();
        ValhallaSummary summary = leg.getSummary();
        Double durationInMinutes = summary.getTime();
        Double distanceInMeters = summary.getLength() * 1000;
        String modeOfTransport = leg.getManeuvers().get(0).getTravel_mode();
        List<String> instructions = new ArrayList<>();
        for (ValhallaManeuver maneuver : leg.getManeuvers()) {
            instructions.add(maneuver.getInstruction());
        }
        RoutingResultSegment segment = new RoutingResultSegment
                (polyline, durationInMinutes, distanceInMeters, modeOfTransport);
        segment.setInstructions(instructions);
        return segment;
    }

    /**
     * Adds a Json object to the URL as query parameter.
     * @param jsonQuery Json object
     * @return URI including jsonQuery
     */
    public URI buildURI(String jsonQuery) {
        URIBuilder builder = new URIBuilder(URI.create(URL));
        builder.addParameter("json", jsonQuery);
        URI uri;
        try {
            uri = builder.build();
        } catch (URISyntaxException e) {
            System.out.println("Failed to receive response.");
            uri = URI.create(URL);
        }
        return uri;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getURL() {
        return URL;
    }
}
