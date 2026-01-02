package org.ParkingLot.Service.Strategy;

import org.ParkingLot.Models.Constants.GateType;
import org.ParkingLot.Models.Constants.ParkingSpotStatus;
import org.ParkingLot.Models.Constants.VehicleType;
import org.ParkingLot.Models.Gate;
import org.ParkingLot.Models.ParkingFloor;
import org.ParkingLot.Models.ParkingLot;
import org.ParkingLot.Models.ParkingSpot;
import org.ParkingLot.Repository.GateRepository;
import org.ParkingLot.Repository.ParkingFloorRepository;
import org.ParkingLot.Repository.ParkingLotRepository;
import org.ParkingLot.Repository.ParkingSpotRepository;

import java.util.ArrayList;
import java.util.List;


public class InitializationService {

    private final GateRepository gateRepository;
    private final ParkingSpotRepository parkingSpotRepository;
    private final ParkingLotRepository parkingLotRepository;
    private final ParkingFloorRepository parkingFloorRepository;


    public InitializationService( GateRepository gateRepository,
                                  ParkingFloorRepository parkingFloorRepository,
                                  ParkingLotRepository parkingLotRepository,
                                  ParkingSpotRepository parkingSpotRepository)
    {
        this.gateRepository = gateRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.parkingFloorRepository = parkingFloorRepository;
        this.parkingSpotRepository = parkingSpotRepository;
    }



    public ParkingLot parkingLotCreation(){
        System.out.println( " ---Creating a parking Lot --- ");

        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setParkingLotName(" PVR - Cinemas ");
        parkingLot.setAddress("Vinayak-Nagar-Nizambad ");
        parkingLot.setCapacity(100);

        List<VehicleType> supportedVechicleList = new ArrayList<>();
        supportedVechicleList.add(VehicleType.TWO_WHEELER);
        supportedVechicleList.add(VehicleType.FOUR_WHEELER);

        parkingLot.setVehicleTypesSupported(supportedVechicleList);


        List<ParkingFloor> parkingFloorList = new ArrayList<>();
        for (int i=1;i<=5;i++)
        {
            ParkingFloor parkingFloor = new ParkingFloor();
            parkingFloor.setFloorNumber(i);

            List<ParkingSpot> parkingSpotsList = new ArrayList<>();
            for (int j=1;j<=10;j++)
            {
                ParkingSpot parkingSpot = new ParkingSpot();
                parkingSpot.setNumber( (i * 1234 )+j );
                parkingSpot.setParkingSpotStatus(ParkingSpotStatus.IS_AVAILABLE);
                parkingSpot.setVehicleType(VehicleType.FOUR_WHEELER);
                parkingSpot.setFloorId(i); // 🔥 IMPORTANT: set floorId here


                parkingSpotsList.add(parkingSpot);
                parkingSpotRepository.put(parkingSpot);
            }
            for (int k=1;k<=10;k++)
            {
                ParkingSpot parkingSpot = new ParkingSpot();
                parkingSpot.setNumber( (i * 1234 )+ k );
                parkingSpot.setParkingSpotStatus(ParkingSpotStatus.IS_AVAILABLE);
                parkingSpot.setVehicleType(VehicleType.TWO_WHEELER);
                parkingSpot.setFloorId(i); // 🔥 IMPORTANT: set floorId here


                parkingSpotsList.add(parkingSpot);
                parkingSpotRepository.put(parkingSpot);
            }
            parkingFloor.setParkingSpots(parkingSpotsList);

            Gate entryGate = new Gate();
            entryGate.setGateNumber(( i * 2000 ) + 1);
            entryGate.setGateType(GateType.ENTRY);
            entryGate.setOperatorName(" shiva ");
            entryGate.setId((i * 5000)+1);
            parkingFloor.setEntryGate(entryGate);
            gateRepository.put(entryGate);


            Gate exitGate = new Gate();
            exitGate.setGateNumber(( i * 2000 ) + 1 );
            exitGate.setGateType(GateType.EXIT);
            exitGate.setOperatorName(" raju ");
            exitGate.setId( ( i * 4000 ) + 1 );
            parkingFloor.setExitGate(exitGate);
            gateRepository.put(exitGate);

            parkingFloorList.add(parkingFloor);
            parkingFloorRepository.put(parkingFloor);
        }

        parkingLot.setParkingFloors(parkingFloorList);
        parkingLotRepository.put(parkingLot);
        return parkingLotRepository.getParkingLotById(1);

    }















}
