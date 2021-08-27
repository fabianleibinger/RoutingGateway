package com.routinggateway.clients.travelinformationapp.adapters;

import com.google.gson.Gson;
import com.routinggateway.clients.travelinformationapp.controller.models.RoutingRequest;
import com.routinggateway.clients.travelinformationapp.controller.models.RoutingResponse;
import com.routinggateway.clients.travelinformationapp.controller.models.RoutingResult;
import com.routinggateway.clients.travelinformationapp.mappings.ValhallaTripToRoutingResult;
import com.routinggateway.routingservices.requests.ValhallaRequest;
import com.routinggateway.routingservices.requests.parameters.valhallaparameters.ValhallaParameters;
import com.routinggateway.routingservices.responses.valhallaresponse.ValhallaResponse;
import org.apache.http.client.utils.URIBuilder;
import org.nomin.NominMapper;
import org.nomin.core.Nomin;

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
     * Returns a routing response for a routing request according to mobility preferences.
     *
     * @param request RoutingRequest
     * @return Optional RoutingResponse
     */
    @Override
    public Optional<RoutingResponse> receiveRoutesForPreference(RoutingRequest request) {
        NominMapper nomin = new Nomin("mappings/RoutingRequestToValhallaParameters.groovy");
        ValhallaParameters parameters = nomin.map(request, ValhallaParameters.class);

        ValhallaRequest valhallaRequest = new ValhallaRequest();
        valhallaRequest.setParameters(parameters);

        Optional<List<RoutingResult>> resultList = this.computeRoutes(valhallaRequest);
        if (resultList.isPresent()) {
            System.out.println("Returned routes for preference successfully.");
            return Optional.of(new RoutingResponse(resultList.get()));
        }

        return Optional.empty();
    }

    /**
     * Returns a routing result for a Valhalla request.
     *
     * @param request RoutingRequest
     * @return Optional List RoutingResult
     */
    @Override
    public Optional<List<RoutingResult>> computeRoutes(ValhallaRequest request) {
        Optional<String> response = this.receiveResponse(request);
        if (response.isPresent()) {
            ValhallaResponse responseObject = new Gson().fromJson(response.get(), ValhallaResponse.class);
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
     *
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
     *
     * @param valhallaResponse
     * @return routes List of RoutingResult
     */
    @Override
    public List<RoutingResult> extractRoutingResult(ValhallaResponse valhallaResponse) {
        List<RoutingResult> routes = new ArrayList<>();
        RoutingResult result = ValhallaTripToRoutingResult.map(valhallaResponse.getTrip());
        routes.add(result);
        return routes;
    }

    /**
     * Adds a Json object to the URL as query parameter.
     *
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
