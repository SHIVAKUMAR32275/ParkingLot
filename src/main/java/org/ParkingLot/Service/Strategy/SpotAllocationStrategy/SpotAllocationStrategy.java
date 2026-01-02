package org.ParkingLot.Service.Strategy.SpotAllocationStrategy;

import org.ParkingLot.Models.ParkingLot;
import org.ParkingLot.Models.ParkingSpot;
import org.ParkingLot.Models.Vehicle;

public interface SpotAllocationStrategy {

    ParkingSpot allocateSpot(ParkingLot parkingLot, Vehicle vehicle,ParkingSpot parkingSpot);


}
