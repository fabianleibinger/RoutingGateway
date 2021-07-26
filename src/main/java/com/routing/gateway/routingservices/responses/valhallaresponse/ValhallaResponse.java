package com.routing.gateway.routingservices.responses.valhallaresponse;

import com.routing.gateway.routingservices.Parameters;

/**
 * Response information of a request to Valhalla.
 */
public class ValhallaResponse extends Parameters {
    private String id;
    private ValhallaTrip trip;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ValhallaTrip getTrip() {
        return trip;
    }

    public void setTrip(ValhallaTrip trip) {
        this.trip = trip;
    }
}
