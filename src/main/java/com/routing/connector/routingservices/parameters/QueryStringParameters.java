package com.routing.connector.routingservices.parameters;

import java.util.Map;

/**
 * Abstract class for parameters, that are passed in a Query String.
 * Provides toString() methods for needed data types.
 */
public abstract class QueryStringParameters extends JsonParameters {

    public abstract Map<String, String> toStringKeyValueMap();

    public String toString(Boolean value) {
        return value == null ? null : Boolean.toString(value);
    }

    public String toString(Integer value) {
        return value == null ? null : Integer.toString(value);
    }

    public String toString(Double value) {
        return value == null ? null : Double.toString(value);
    }

    public String toString(Float value) {
        return value == null ? null : Float.toString(value);
    }

    public String toString(Long value) {
        return value == null ? null : Long.toString(value);
    }
}
