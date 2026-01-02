package org.ParkingLot.Models;

import org.ParkingLot.Models.Constants.GateType;

public class Gate extends BaseModel{

    private int gateNumber;
    public GateType gateType;
    private String operatorName;

    public Gate(){

    }

    public Gate(int id,GateType gateType,String operatorName,int gateNumber){
        this.operatorName = operatorName;
        this.gateType = gateType;
        this.gateNumber = gateNumber;
    }


    public GateType getGateType() {
        return gateType;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public String getOperatorName() {
        return operatorName;
    }


    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }


    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }


}
