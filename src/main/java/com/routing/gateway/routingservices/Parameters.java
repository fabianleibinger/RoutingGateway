package com.routing.gateway.routingservices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import org.apache.http.client.utils.URIBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Abstract class for Routing Service parameters.
 * Provides methods for object to Json, XML and Query String transformations.
 */
public abstract class Parameters {
    /**
     * Transforms <RoutingServiceParameters> object to Json.
     *
     * @return String json
     */
    public String toJson() {
        return new Gson().toJson(this);
    }

    /**
     * Transforms <RoutingServiceParameters> object to XML.
     *
     * @return String XML
     */
    public String toXML() {
        try {
            return new XmlMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            System.out.println("Failed to serialize object to xml.");
            return "";
        }
    }

    /**
     * Transforms <RoutingServiceParameters> object to Query String for http.
     *
     * @return String Query String for http
     */
    public String toQueryString() {
        String json = this.toJson();

        Map<String, String> map;
        try {
            map = new ObjectMapper().readValue(json, HashMap.class);
        } catch (JsonProcessingException e) {
            return "";
        }
        map = map.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry<String, String>::getKey, Map.Entry<String, String>::getValue));

        URIBuilder builder = new URIBuilder();
        map.entrySet().forEach(entry -> builder.addParameter(entry.getKey(), entry.getValue()));
        URI uri;
        try {
            uri = builder.build();
        } catch (URISyntaxException e) {
            uri = URI.create("");
        }
        return uri.toString();
    }
}