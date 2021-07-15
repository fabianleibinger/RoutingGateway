package com.routing.gateway.routingservices.requests.parameters.valhallaparameters;

import com.routing.gateway.routingservices.requests.parameters.Parameters;

public class ValhallaFilter extends Parameters {
    String ids;
    String action;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
