package org.ParkingLot.Repository;

import org.ParkingLot.Models.ParkingFloor;

import java.util.List;

public interface ParkingFloorRepository {

    List<ParkingFloor> getNumberOfFloorsByPlatformId(int platformId);
    ParkingFloor getFloorsByParkingLotId( int floorNumber );
    void put(ParkingFloor parkingFloor);

}
