package org.ParkingLot.Service.Strategy.BillStrategy;


import org.ParkingLot.Models.ParkingLot;
import org.ParkingLot.Models.Ticket;

public interface BillCalculationStrategy {

    double calculateAmount(ParkingLot parkingLot, Ticket ticket );

}
