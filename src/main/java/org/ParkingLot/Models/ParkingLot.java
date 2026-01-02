package org.ParkingLot.Models;

import org.ParkingLot.Models.Constants.VehicleType;
import java.util.List;

public class ParkingLot extends BaseModel{

    private String parkingLotName;
    private String address;
    private List<ParkingFloor> parkingFloors;
    private List<ParkingSpot> parkingSpots;
    private List<VehicleType> vehicleTypesSupported;
    private int capacity;
    private int occupiedSlots;


    public ParkingLot(){

    }

    public ParkingLot(String parkingLotName,
                      String address,
                      List<ParkingFloor> parkingFloors,
                      List<ParkingSpot> parkingSpots,
                      List<VehicleType> vehicleTypesSupported,
                      int capacity,
                      int occupiedSlots)
    {
        this.parkingLotName = parkingLotName;
        this.address = address;
        this.parkingFloors = parkingFloors;
        this.parkingSpots = parkingSpots;
        this.vehicleTypesSupported = vehicleTypesSupported;
        this.capacity = capacity;
        this.occupiedSlots = occupiedSlots;

    }


    public int getCapacity() {
        return capacity;
    }

    public int getOccupiedSlots() {
        return occupiedSlots;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }


    public List<VehicleType> getVehicleTypesSupported() {
        return vehicleTypesSupported;
    }

    public String getAddress() {
        return address;
    }

    public String getParkingLotName() {
        return parkingLotName;
    }


    public void setAddress(String address) {
        this.address = address;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setOccupiedSlots(int occupiedSlots) {
        this.occupiedSlots = occupiedSlots;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public void setParkingLotName(String parkingLotName) {
        this.parkingLotName = parkingLotName;
    }


    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public void setVehicleTypesSupported(List<VehicleType> vehicleTypesSupported) {
        this.vehicleTypesSupported = vehicleTypesSupported;
    }


}
