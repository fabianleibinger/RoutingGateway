package com.routing.gateway.routingservices.responses.opentripplannerresponse;

import java.util.ArrayList;
import java.util.List;

public class OpenTripPlannerError {
    private Integer number;
    private String msg;
    private String message;
    private List<String> missing;
    private Boolean noPath;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getMissing() {
        if (this.missing == null) {
            this.missing = new ArrayList<>();
        }
        return missing;
    }

    public void setMissing(List<String> missing) {
        this.missing = missing;
    }

    public Boolean getNoPath() {
        return noPath;
    }

    public void setNoPath(Boolean noPath) {
        this.noPath = noPath;
    }
}
