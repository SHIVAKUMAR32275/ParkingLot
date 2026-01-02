package org.ParkingLot.Models;

import org.ParkingLot.Models.Constants.BillStatus;

import java.time.LocalDateTime;

public class Bill extends BaseModel {

    private LocalDateTime exitTime;
    private BillStatus billStatus;
    private Ticket ticket;
    private Gate exitGate;
    private double amount;


    public Bill(){

    }

    public Bill(LocalDateTime exitTime,BillStatus billStatus,Ticket ticket,Gate exitGate,double amount){
        this.amount = amount;
        this.billStatus = billStatus;
        this.exitTime = exitTime;
        this.exitGate = exitGate;
        this.ticket = ticket;

    }


    public Gate getExitGate() {
        return exitGate;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public Ticket getTicket() {
        return ticket;
    }


    public void setExitGate(Gate exitGate) {
        this.exitGate = exitGate;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }


    public void setAmount(double amount) {
        this.amount = amount;
    }


    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }


}
