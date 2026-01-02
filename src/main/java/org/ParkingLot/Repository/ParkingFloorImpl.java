package org.ParkingLot.Repository;

import org.ParkingLot.Exceptions.ParkingFloorNotFoundException;
import org.ParkingLot.Exceptions.ParkingSpotNotFoundException;
import org.ParkingLot.Models.ParkingFloor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingFloorImpl implements ParkingFloorRepository{

    private static int idCounter = 1;
    private final HashMap<Integer,ParkingFloor> parkingFloorHashMap = new HashMap<>();


    @Override
    public List<ParkingFloor> getNumberOfFloorsByPlatformId(int platformId) {
        List<ParkingFloor> parkingFloorList = new ArrayList<>();

        for( ParkingFloor floor : parkingFloorHashMap.values() ) {
            if( floor.getFloorNumber() == platformId ) {
                parkingFloorList.add(floor);
            }
        }
        if( parkingFloorList.isEmpty() ){
            throw new ParkingSpotNotFoundException(" floor not found with platform id -- "+platformId);
        }
        return parkingFloorList;
    }

    @Override
    public ParkingFloor getFloorsByParkingLotId(int floorNumber) {
        ParkingFloor parkingFloor = parkingFloorHashMap.get(floorNumber);
        if( parkingFloor == null ) {
            throw new ParkingFloorNotFoundException(" Floor not found ");
        }
        return parkingFloor;
    }

    @Override
    public void put(ParkingFloor parkingFloor) {
        parkingFloor.setFloorNumber(idCounter++);
        parkingFloorHashMap.put(parkingFloor.getFloorNumber(),parkingFloor);
        System.out.println(" Parking Floor added successfully  :  "+parkingFloor.getFloorNumber());
    }





}
