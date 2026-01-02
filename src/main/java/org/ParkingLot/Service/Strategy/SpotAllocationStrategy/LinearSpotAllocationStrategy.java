package org.ParkingLot.Service.Strategy.SpotAllocationStrategy;

import org.ParkingLot.Exceptions.ParkingSpotNotFoundException;
import org.ParkingLot.Models.Constants.ParkingSpotStatus;


import org.ParkingLot.Models.ParkingFloor;
import org.ParkingLot.Models.ParkingLot;
import org.ParkingLot.Models.ParkingSpot;
import org.ParkingLot.Models.Vehicle;

public class LinearSpotAllocationStrategy implements SpotAllocationStrategy{


    @Override
    public ParkingSpot allocateSpot(ParkingLot parkingLot, Vehicle vehicle, ParkingSpot parkingSpot) {
        for( ParkingFloor floor : parkingLot.getParkingFloors())
        {
            for (ParkingSpot spot : floor.getParkingSpots() )
            {
                if( spot.getParkingSpotStatus().equals(ParkingSpotStatus.IS_AVAILABLE)
                    && spot.getVehicleType().equals(vehicle.getVehicleType()) )
                {
                    return spot;
                }
            }
        }
        throw new ParkingSpotNotFoundException(" Parking spot is not found ");
    }


}
