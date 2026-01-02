package org.ParkingLot.Controller;

import org.ParkingLot.Models.*;
import org.ParkingLot.Repository.GateRepository;
import org.ParkingLot.Repository.ParkingFloorRepository;
import org.ParkingLot.Repository.ParkingLotRepository;
import org.ParkingLot.Repository.ParkingSpotRepository;
import org.ParkingLot.Service.Strategy.ParkingLotService;


public class ParkingLotController {

    private ParkingLotService parkingLotService;

    public ParkingLotController(GateRepository gateRepository, ParkingLotRepository parkingLotRepository, ParkingSpotRepository parkingSpotRepository,
                                ParkingFloorRepository parkingFloorRepository) {
        this.parkingLotService = new ParkingLotService(gateRepository,parkingFloorRepository,parkingSpotRepository,parkingLotRepository);
    }

    public Ticket generateTicket(int parkingLotID, Vehicle vehicle){
        return parkingLotService.toGenerateTicket(parkingLotID, vehicle);
    }


    public double generateBill(ParkingLot parkingLot,Ticket ticket){
        return parkingLotService.calculatingTheBillBasedOnStrategy(parkingLot,ticket);
    }


}
