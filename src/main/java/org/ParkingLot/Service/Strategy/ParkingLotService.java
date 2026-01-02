package org.ParkingLot.Service.Strategy;

import org.ParkingLot.Exceptions.ParkingSpotNotFoundException;
import org.ParkingLot.Models.*;
import org.ParkingLot.Models.Constants.ParkingSpotStatus;
import org.ParkingLot.Repository.GateRepository;
import org.ParkingLot.Repository.ParkingFloorRepository;
import org.ParkingLot.Repository.ParkingLotRepository;
import org.ParkingLot.Repository.ParkingSpotRepository;
import org.ParkingLot.Service.Strategy.BillStrategy.BillCalculationStrategy;
import org.ParkingLot.Service.Strategy.BillStrategy.BillGenerationStrategy;
import org.ParkingLot.Service.Strategy.BillStrategy.BillGenerationStrategyFactory;

import java.time.LocalDateTime;
import java.util.List;

public class ParkingLotService {

    private GateRepository gateRepository;
    private ParkingLotRepository parkingLotRepository;
    private ParkingSpotRepository parkingSpotRepository;
    private ParkingFloorRepository parkingFloorRepository;

    public  ParkingLotService(GateRepository gateRepository,
                              ParkingFloorRepository parkingFloorRepository,
                              ParkingSpotRepository parkingSpotRepository,
                              ParkingLotRepository parkingLotRepository){
        this.parkingSpotRepository = parkingSpotRepository;
        this.gateRepository = gateRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.parkingFloorRepository = parkingFloorRepository;
    }

    public Ticket toGenerateTicket(int parkingLotId, Vehicle vehicle){

        /// 1.validating if the parking lot exist or not
        ParkingLot parkingLot =  parkingLotRepository.getParkingLotById(parkingLotId);

        /// 2. finding entry gate
        Gate entryGate = gateRepository.findGateByParkingLotId(parkingLotId);

        ParkingSpot allocatedSpot = allocateParkingSpot(parkingLotId,vehicle);
        if( allocatedSpot == null )
        {
            throw new ParkingSpotNotFoundException(" parking spot is not available ");
        }

        allocatedSpot.setParkingSpotStatus(ParkingSpotStatus.IS_OCCUPIED);
        allocatedSpot.setVehicle(vehicle);


        Ticket ticket = new Ticket();
        ticket.setEntryTime(LocalDateTime.now());
        ticket.setEntryGate(entryGate);
        ticket.setParkingSpot(allocatedSpot);
        ticket.setVehicle(vehicle);

        return ticket;
    }

    public ParkingSpot allocateParkingSpot(int parkingLotId,Vehicle vehicle){

        List<ParkingFloor> parkingFloorList = parkingFloorRepository.getNumberOfFloorsByPlatformId(parkingLotId);

        for ( ParkingFloor floor : parkingFloorList ){
            List<ParkingSpot> parkingSpots = parkingSpotRepository.toGetListOfParkingSpotsById(floor.getFloorNumber());
            for( ParkingSpot spot : parkingSpots )
            {
                if( spot.getParkingSpotStatus().equals(ParkingSpotStatus.IS_AVAILABLE)
                        && spot.getVehicleType().equals(vehicle.getVehicleType()) )
                {
                    spot.setParkingSpotStatus(ParkingSpotStatus.IS_OCCUPIED);
                    return spot;
                }
            }
        }
        return null;
    }



    public double calculatingTheBillBasedOnStrategy(ParkingLot parkingLot,Ticket ticket){
        BillCalculationStrategy billCalculationStrategy = BillGenerationStrategyFactory.getBillCalculationStrategy(BillGenerationStrategy.LINEAR);
        return billCalculationStrategy.calculateAmount(parkingLot,ticket);
    }
}
