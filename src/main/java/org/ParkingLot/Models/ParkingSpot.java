package org.ParkingLot.Models;


import org.ParkingLot.Models.Constants.ParkingSpotStatus;
import org.ParkingLot.Models.Constants.VehicleType;

public class ParkingSpot extends BaseModel {
    private int spotNumber;
    private int floorId;
    private ParkingSpotStatus parkingSpotStatus;
    private Vehicle vehicle;
    private VehicleType vehicleType;



    public ParkingSpot(){

    }


    public ParkingSpot(int spotNumber,int floorId ,ParkingSpotStatus parkingSpotStatus,VehicleType vehicleType,Vehicle vehicle){
        this.spotNumber = spotNumber;
        this.parkingSpotStatus = parkingSpotStatus;
        this.vehicle = vehicle;
        this.vehicleType = vehicleType;
        this.floorId = floorId;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public int getNumber() {
        return spotNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public void setNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }
}
