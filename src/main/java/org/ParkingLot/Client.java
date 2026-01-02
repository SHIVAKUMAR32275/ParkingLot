package org.ParkingLot;

import org.ParkingLot.Controller.ParkingLotController;
import org.ParkingLot.Exceptions.ParkingLotNotFoundException;
import org.ParkingLot.Models.*;
import org.ParkingLot.Models.Constants.VehicleType;
import org.ParkingLot.Repository.*;
import org.ParkingLot.Service.Strategy.InitializationService;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        /// STEP 1: SET UP REPOSITORIES
        GateRepository gateRepository = new GateRepoImpl();
        ParkingSpotRepository parkingSpotRepository = new ParkingSpotImpl();
        ParkingLotRepository parkingLotRepository = new ParkingLotImpl();
        ParkingFloorRepository parkingFloorRepository = new ParkingFloorImpl();

        /// STEP 2: INITIALIZE THE PARKING LOT
        InitializationService service = new InitializationService( gateRepository, parkingFloorRepository, parkingLotRepository, parkingSpotRepository);
        ParkingLot createdLot = service.parkingLotCreation();

        /// STEP 3: INITIALIZE PARKING LOT SERVICE
        ParkingLotController controller = new ParkingLotController(gateRepository,
                                                parkingLotRepository,
                                                parkingSpotRepository,
                                                parkingFloorRepository
        );

        /// STEP 4: VEHICLE INPUT
        Scanner sc = new Scanner(System.in);
        Vehicle vehicle = new Vehicle();

        System.out.print("Enter the vehicle number: ");
        String vehicleNumber = sc.next().toUpperCase();
        vehicle.setVehicleNumber(vehicleNumber);

        System.out.print("Enter the vehicle type (2 or 4): ");
        int vehicleType = sc.nextInt();

        if (vehicleType == 2) {
            vehicle.setVehicleType(VehicleType.TWO_WHEELER);
        } else if (vehicleType == 4) {
            vehicle.setVehicleType(VehicleType.FOUR_WHEELER);
        } else {
            throw new ParkingLotNotFoundException("Please enter a valid vehicle type...");
        }

        Ticket ticket = null;
        try{
            /// STEP 5: GENERATE TICKET
            ticket = controller.generateTicket(1,vehicle);

            /// STEP 6: PRINT TICKET DETAILS
            System.out.println("\n--- Ticket Generated ---");
            System.out.println("Parking Lot    : " + createdLot.getParkingLotName());
            System.out.println("Vehicle Type   : " + vehicle.getVehicleType());
            System.out.println("Vehicle Number : " + vehicle.getVehicleNumber());
            System.out.println("Gate Type      : " + ticket.getEntryGate().getGateType());
            System.out.println("Gate Number    : " + ticket.getEntryGate().getGateNumber());
            System.out.println("Parking Spot   : " + ticket.getParkingSpot().getNumber());
            System.out.println("Entry Time     : " + ticket.getEntryTime());
            System.out.println(" Parking floor : " + ticket.getParkingSpot().getFloorId());
        }
        catch (Exception ex){
            System.out.println(" "+ ex.getMessage());
        }


        System.out.println();
        System.out.println("Do you want to exit from parking lot (Yes/No)?");
        String input = sc.next();

        if (input.equalsIgnoreCase("YES") && ticket != null) {
            double amount = controller.generateBill(createdLot, ticket);
            System.out.println("\n--- Exit Bill ---");
            System.out.println("Vehicle Number : " + vehicle.getVehicleNumber());
            System.out.println("Exit Time      : " + java.time.LocalDateTime.now());
            System.out.println("Amount to Pay  : " + amount + " Rs");
        }


    }
}
