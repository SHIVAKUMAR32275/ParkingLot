package org.ParkingLot.Repository;

import org.ParkingLot.Models.ParkingLot;

public interface ParkingLotRepository {

    ParkingLot getParkingLotById(int id);
    void put(ParkingLot parkingLot);

}
