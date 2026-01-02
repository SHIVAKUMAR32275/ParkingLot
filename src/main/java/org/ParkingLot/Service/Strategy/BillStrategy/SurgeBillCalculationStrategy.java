package org.ParkingLot.Service.Strategy.BillStrategy;

import org.ParkingLot.Models.ParkingLot;
import org.ParkingLot.Models.Ticket;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SurgeBillCalculationStrategy implements BillCalculationStrategy{

    private static double BASE_RATE = 50;
    private static double HOURLY_RATE = 40;
    private static double L1_SURGE = 1.2;
    private static double L2_SURGE = 1.5;
    private static double L3_SURGE = 2;


    private double calculateLinearAmount(Ticket ticket) {
        LocalDateTime entryTime = ticket.getEntryTime();
        LocalDateTime exitTime  = LocalDateTime.now();

        boolean isBaseRateCalculated = false;
        double amount = 0;


        long numberOfSeconds = ChronoUnit.SECONDS.between(entryTime,exitTime);

        while ( numberOfSeconds >  0 )
        {
            if( ! isBaseRateCalculated )
            {
                amount = amount + BASE_RATE;
                isBaseRateCalculated = true;
            }
            else {
                amount = amount + HOURLY_RATE;
            }
            numberOfSeconds = numberOfSeconds - 3600;
        }
        return  amount;
    }

    @Override
    public double calculateAmount(ParkingLot parkingLot, Ticket ticket) {
        LocalDateTime entryTime = ticket.getEntryTime();
        LocalDateTime exitTime = LocalDateTime.now();
        double amount =  calculateLinearAmount(ticket);

        double occupancyRate = ( parkingLot.getOccupiedSlots() / parkingLot.getCapacity()  ) * 100 ;

        if( occupancyRate >= 0 && occupancyRate < 25 )
        {
            amount = amount * L1_SURGE;
        }
        else if (occupancyRate > 25 && occupancyRate <= 75)
        {
            amount = amount * L2_SURGE;
        }
        else
        {
            amount = amount * L3_SURGE;
        }
        return amount;
    }




}
