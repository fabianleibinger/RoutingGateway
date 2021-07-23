package com.routing.gateway.routingservices.responses.opentripplannerresponse;

public class OpenTripPlannerLocalizedAlert {
    private String alertHeaderText;
    private String alertDescriptionText;
    private String alertUrl;
    private Integer effectiveStartDate;

    public String getAlertHeaderText() {
        return alertHeaderText;
    }

    public void setAlertHeaderText(String alertHeaderText) {
        this.alertHeaderText = alertHeaderText;
    }

    public String getAlertDescriptionText() {
        return alertDescriptionText;
    }

    public void setAlertDescriptionText(String alertDescriptionText) {
        this.alertDescriptionText = alertDescriptionText;
    }

    public String getAlertUrl() {
        return alertUrl;
    }

    public void setAlertUrl(String alertUrl) {
        this.alertUrl = alertUrl;
    }

    public Integer getEffectiveStartDate() {
        return effectiveStartDate;
    }

    public void setEffectiveStartDate(Integer effectiveStartDate) {
        this.effectiveStartDate = effectiveStartDate;
    }
}
