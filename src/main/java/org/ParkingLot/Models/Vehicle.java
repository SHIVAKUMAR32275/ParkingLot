package org.ParkingLot.Models;

import org.ParkingLot.Models.Constants.VehicleType;

public class Vehicle {

    private String vehicleNumber;
    private VehicleType vehicleType;

    public Vehicle(){

    }

    public Vehicle(String vehicleNumber,VehicleType vehicleType){
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
    }


    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
}
