package com.routing.gateway.routingservices.requests.parameters.valhallaparameters;

import java.util.ArrayList;
import java.util.List;

public class ValhallaTransitCostingOptions extends ValhallaVehicleBaseCostingOptions {
    public Double use_bus;
    public Double use_rail;
    public Double use_transfers;
    public Double transit_start_end_max_distance;
    public Double transit_transfer_max_distance;
    public List<ValhallaFilter> filters;

    public Double getUse_bus() {
        return use_bus;
    }

    public void setUse_bus(Double use_bus) {
        this.use_bus = use_bus;
    }

    public Double getUse_rail() {
        return use_rail;
    }

    public void setUse_rail(Double use_rail) {
        this.use_rail = use_rail;
    }

    public Double getUse_transfers() {
        return use_transfers;
    }

    public void setUse_transfers(Double use_transfers) {
        this.use_transfers = use_transfers;
    }

    public Double getTransit_start_end_max_distance() {
        return transit_start_end_max_distance;
    }

    public void setTransit_start_end_max_distance(Double transit_start_end_max_distance) {
        this.transit_start_end_max_distance = transit_start_end_max_distance;
    }

    public Double getTransit_transfer_max_distance() {
        return transit_transfer_max_distance;
    }

    public void setTransit_transfer_max_distance(Double transit_transfer_max_distance) {
        this.transit_transfer_max_distance = transit_transfer_max_distance;
    }

    public List<ValhallaFilter> getFilters() {
        if(this.filters == null) {
            this.filters = new ArrayList<>();
        }
        return filters;
    }

    public void setFilters(List<ValhallaFilter> filters) {
        this.filters = filters;
    }
}
