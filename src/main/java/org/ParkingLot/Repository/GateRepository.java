package org.ParkingLot.Repository;

import org.ParkingLot.Models.Gate;

public interface GateRepository {

    Gate findGateByParkingLotId(int id);
    void put(Gate gate);

}
