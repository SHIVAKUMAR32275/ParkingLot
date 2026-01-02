package org.ParkingLot.Repository;

import org.ParkingLot.Exceptions.ParkingSpotNotFoundException;
import org.ParkingLot.Models.ParkingSpot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingSpotImpl implements ParkingSpotRepository{

    private static int idCounter = 1;
    private HashMap<Integer,ParkingSpot> parkingSpotHashMap = new HashMap<>();


    @Override
    public List<ParkingSpot> toGetListOfParkingSpotsById(int floorId) {
        List<ParkingSpot> parkingSpotList = new ArrayList<>();

        for ( ParkingSpot spot : parkingSpotHashMap.values() )
        {
            if( spot.getFloorId() == floorId )
            {
                parkingSpotList.add(spot);
            }
        }

        if( parkingSpotList.isEmpty() )
        {
            throw new ParkingSpotNotFoundException(" list of spots doesn't found with respective floor id "+floorId);
        }

        return  parkingSpotList;
    }

    @Override
    public ParkingSpot getSpot(int floorId) {
        ParkingSpot parkingSpot = parkingSpotHashMap.get(floorId);
        if( parkingSpot == null ){
            throw new ParkingSpotNotFoundException(" Parking spot is not found ");
        }
        return parkingSpot;
    }

    @Override
    public void put(ParkingSpot parkingSpot) {
        parkingSpot.setNumber(idCounter++);
        parkingSpotHashMap.put(parkingSpot.getNumber(),parkingSpot);
//        System.out.println(" Parking Spot added successfully ");
    }
}
