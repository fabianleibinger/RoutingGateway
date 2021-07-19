package com.routing.gateway.routingservices.requests.parameters.valhallaparameters;

public class ValhallaCostingOptions {
    private ValhallaAutomobileAndBusCostingOptions auto;
    private ValhallaTruckCostingOptions truck;
    private ValhallaMotorScooterCostingOptions motor_scooter;
    private ValhallaMotorCycleCostingOptions motorcycle;
    private ValhallaBicycleCostingOptions bicycle;
    private ValhallaPedestrianCostingOptions pedestrian;
    private ValhallaTransitCostingOptions transit;

    public ValhallaAutomobileAndBusCostingOptions getAuto() {
        if (this.auto == null) {
            this.auto = new ValhallaAutomobileAndBusCostingOptions();
        }
        return auto;
    }

    public void setAuto(ValhallaAutomobileAndBusCostingOptions auto) {
        this.auto = auto;
    }

    public ValhallaTruckCostingOptions getTruck() {
        if (this.truck == null) {
            this.truck = new ValhallaTruckCostingOptions();
        }
        return truck;
    }

    public void setTruck(ValhallaTruckCostingOptions truck) {
        this.truck = truck;
    }

    public ValhallaMotorScooterCostingOptions getMotor_scooter() {
        if (this.motor_scooter == null) {
            this.motor_scooter = new ValhallaMotorScooterCostingOptions();
        }
        return motor_scooter;
    }

    public void setMotor_scooter(ValhallaMotorScooterCostingOptions motor_scooter) {
        this.motor_scooter = motor_scooter;
    }

    public ValhallaMotorCycleCostingOptions getMotorcycle() {
        if (this.motorcycle == null) {
            this.motorcycle = new ValhallaMotorCycleCostingOptions();
        }
        return motorcycle;
    }

    public void setMotorcycle(ValhallaMotorCycleCostingOptions motorcycle) {
        this.motorcycle = motorcycle;
    }

    public ValhallaBicycleCostingOptions getBicycle() {
        if (this.bicycle == null) {
            this.bicycle = new ValhallaBicycleCostingOptions();
        }
        return bicycle;
    }

    public void setBicycle(ValhallaBicycleCostingOptions bicycle) {
        this.bicycle = bicycle;
    }

    public ValhallaPedestrianCostingOptions getPedestrian() {
        if (this.pedestrian == null) {
            this.pedestrian = new ValhallaPedestrianCostingOptions();
        }
        return pedestrian;
    }

    public void setPedestrian(ValhallaPedestrianCostingOptions pedestrian) {
        this.pedestrian = pedestrian;
    }

    public ValhallaTransitCostingOptions getTransit() {
        if (this.transit == null) {
            this.transit = new ValhallaTransitCostingOptions();
        }
        return transit;
    }

    public void setTransit(ValhallaTransitCostingOptions transit) {
        this.transit = transit;
    }
}
