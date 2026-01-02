package org.ParkingLot.Repository;

import org.ParkingLot.Models.ParkingSpot;

import java.util.List;

public interface ParkingSpotRepository {

    List<ParkingSpot> toGetListOfParkingSpotsById( int floorId );

    ParkingSpot getSpot(int floorId );

    void put(ParkingSpot parkingSpot);

}
