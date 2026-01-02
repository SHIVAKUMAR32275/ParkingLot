package org.ParkingLot.Models;

import java.time.LocalDateTime;

public class Ticket extends BaseModel{

    private LocalDateTime entryTime;
    private ParkingSpot parkingSpot;
    private Vehicle vehicle;
    private Gate entryGate;

    public Ticket(){

    }

    public Ticket(LocalDateTime entryTime,ParkingSpot parkingSpot,Vehicle vehicle,Gate entryGate){
        this.entryGate = entryGate;
        this.entryTime = entryTime;
        this.parkingSpot = parkingSpot;
        this.vehicle = vehicle;
    }


    public Gate getEntryGate() {
        return entryGate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }


    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }


    public void setEntryGate(Gate entryGate) {
        this.entryGate = entryGate;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

}
