package org.ParkingLot.Repository;

import org.ParkingLot.Exceptions.GateNotFoundException;
import org.ParkingLot.Models.Gate;

import java.util.HashMap;

public class GateRepoImpl implements GateRepository {

    private static int idCounter =  1 ;
    private HashMap<Integer,Gate> gateHashMap = new HashMap<>();


    @Override
    public Gate findGateByParkingLotId(int id) {
        Gate gate = gateHashMap.get(id);
        if( gate == null ){
            throw new GateNotFoundException(" Gate with "+id+" is not present ");
        }
        return gate;
    }

    @Override
    public void put(Gate gate) {
        gate.setId(idCounter++);
        gateHashMap.put(gate.getId(),gate);
//        System.out.println("Gate has been added successfully");
    }


}
