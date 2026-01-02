package org.ParkingLot.Service.Strategy.BillStrategy;

import org.ParkingLot.Models.ParkingLot;
import org.ParkingLot.Models.Ticket;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class LinearBillCalculationStrategy implements BillCalculationStrategy {


    private static double BASE_RATE = 50;
    private static double HOURLY_RATE = 40;


    @Override
    public double calculateAmount(ParkingLot parkingLot, Ticket ticket) {
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
}
