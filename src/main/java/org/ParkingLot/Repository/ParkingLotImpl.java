package org.ParkingLot.Repository;

import org.ParkingLot.Exceptions.ParkingLotNotFoundException;
import org.ParkingLot.Models.ParkingLot;
import java.util.HashMap;

public class ParkingLotImpl implements ParkingLotRepository{

    private final HashMap<Integer,ParkingLot> parkingLotHashMap = new HashMap<>();
    private static int idCounter = 1 ;


    @Override
    public ParkingLot getParkingLotById(int id) {
        ParkingLot parkingLot = parkingLotHashMap.get(id);
        if( parkingLot == null ){
            throw new ParkingLotNotFoundException(" ParkingLot is not found ");
        }
        return parkingLot;
    }

    @Override
    public void put(ParkingLot parkingLot) {
        parkingLot.setId(idCounter++);
        parkingLotHashMap.put(parkingLot.getId(),parkingLot);
//        System.out.println("Parking lot has been added successfully");
    }



}
