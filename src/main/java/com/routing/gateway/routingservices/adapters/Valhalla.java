package com.routing.gateway.routingservices.adapters;

import com.routing.gateway.routingservices.RoutingRequest;
import com.routing.gateway.routingservices.RoutingResult;
import com.routing.gateway.routingservices.requests.ValhallaRequest;
import com.routing.gateway.routingservices.responses.valhallaresponse.ValhallaResponse;
import org.apache.http.client.utils.URIBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Optional;
import java.util.List;

/**
 * Adapter for Valhalla.
 */
public class Valhalla implements IRoutingService<ValhallaRequest, ValhallaResponse> {
    private static final String NAME = "Valhalla";
    private static final String URL = "http://se-elsbeere:8002/route";

    @Override
    public Optional<List<RoutingResult>> computeRoute(RoutingRequest request) {
        return Optional.empty();
    }

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

    @Override
    public List<RoutingResult> extractRoutingResult(ValhallaResponse valhallaResponse) {
        return null;
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
