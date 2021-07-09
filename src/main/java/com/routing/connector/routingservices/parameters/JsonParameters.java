package com.routing.connector.routingservices.parameters;

import com.google.gson.Gson;

/**
 * Abstract class for Json parameters.
 * Provides toJson() and fromJson() methods for object to Json transformations.
 */
public abstract class JsonParameters {
    /**
     * Transforms JsonParameters object to Json file.
     * @return String json
     */
    public String toJson() {
        String json = new Gson().toJson(this);
        System.out.println(json);
        return json;
    }

    /**
     * Transforms Json file to JsonParameters subclass object.
     * @param json
     * @param type class type
     * @param <P> subclass of JsonParameters
     * @return object of <P>
     */
    public static <P extends JsonParameters> P fromJson(String json, Class<P> type) {
        return new Gson().fromJson(json, type);
    }
}
