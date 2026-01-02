package org.ParkingLot.Service.Strategy.BillStrategy;

public class BillGenerationStrategyFactory {

    public static BillCalculationStrategy getBillCalculationStrategy(BillGenerationStrategy billGenerationStrategy){

        return switch (billGenerationStrategy){
            case LINEAR -> new LinearBillCalculationStrategy();
            case SURGE -> new SurgeBillCalculationStrategy();
        };

    }
}
