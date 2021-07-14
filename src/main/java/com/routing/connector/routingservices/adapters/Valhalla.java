package com.routing.connector.routingservices.adapters;

import com.routing.connector.routingservices.RoutingRequest;
import com.routing.connector.routingservices.RoutingResult;
import com.routing.connector.routingservices.requests.ValhallaRequest;
import org.apache.http.client.utils.URIBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Optional;

/**
 * Adapter for Valhalla.
 */
public class Valhalla implements IRoutingService<ValhallaRequest> {
    private static final String NAME = "Valhalla";
    private static final String URL = "http://se-elsbeere:8002/route";

    @Override
    public Optional<RoutingResult> computeRoute(RoutingRequest request) {
        return Optional.empty();
    }

    @Override
    public Optional<String> receiveResponse(ValhallaRequest valhallaRequest) {
        URIBuilder builder = new URIBuilder(URI.create(URL));
        //Add parameters to URI
        builder.addParameter("json", valhallaRequest.serialize());
        URI uri;
        try {
            uri = builder.build();
        } catch (URISyntaxException e) {
            uri = URI.create(URL);
        }
        try {
            URL obj = new URL(uri.toString());
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            System.out.println(connection.getResponseCode());
            String result = "";
            try {
                //TODO make reading work
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
            if (result != "") {
                return Optional.of(result);
            }
        } catch (IOException e) {
            System.out.println("Couldn't receive response.");
        }
        return Optional.empty();
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
