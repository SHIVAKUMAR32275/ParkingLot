package org.ParkingLot.Models;

import java.util.List;

public class ParkingFloor {

    private int floorNumber;
    private List<ParkingSpot> parkingSpots;
    private Gate entryGate;
    private Gate exitGate;

    public ParkingFloor(){

    }


    public ParkingFloor(int floorNumber,List<ParkingSpot> parkingSpots,Gate entryGate,Gate exitGate){
        this.floorNumber = floorNumber;
        this.entryGate = entryGate;
        this.exitGate = exitGate;
        this.parkingSpots = parkingSpots;
    }


    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public Gate getEntryGate() {
        return entryGate;
    }

    public Gate getExitGate() {
        return exitGate;
    }

    public int getFloorNumber() {
        return floorNumber;
    }


    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public void setEntryGate(Gate entryGate) {
        this.entryGate = entryGate;
    }

    public void setExitGate(Gate exitGate) {
        this.exitGate = exitGate;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }


}
