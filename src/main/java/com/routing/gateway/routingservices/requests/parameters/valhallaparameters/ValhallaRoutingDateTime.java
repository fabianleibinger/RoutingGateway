package com.routing.gateway.routingservices.requests.parameters.valhallaparameters;

import com.routing.gateway.routingservices.requests.parameters.Parameters;

import java.util.Date;

public class ValhallaRoutingDateTime extends Parameters {
    private Integer type;
    private Date value;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getValue() {
        return value;
    }

    public void setValue(Date value) {
        this.value = value;
    }
}
