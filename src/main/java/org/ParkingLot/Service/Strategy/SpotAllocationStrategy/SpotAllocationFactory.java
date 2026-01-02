package org.ParkingLot.Service.Strategy.SpotAllocationStrategy;

public class SpotAllocationFactory {
    public static SpotAllocationStrategy getSpotAllocationStrategy( AllocationStrategy allocationStrategy ){

        return switch (allocationStrategy){
            case LINEAR -> new LinearSpotAllocationStrategy();
            case SPOT_TYPE -> null;
            case NEAR_EXIT -> null;
        };
    }
}
