package org.ParkingLot.Models;

import org.ParkingLot.Models.Constants.PaymentMode;
import org.ParkingLot.Models.Constants.PaymentStatus;

import java.time.LocalDateTime;

public class Payment extends BaseModel{

    private double amount;
    private String transactionId;
    private PaymentStatus paymentStatus;
    private PaymentMode paymentMode;
    private Bill bill;
    private LocalDateTime paymentTime;


    public Payment(){

    }

    public Payment(double amount,String transactionId,PaymentStatus paymentStatus,PaymentMode paymentMode,Bill bill,LocalDateTime paymentTime){
        this.amount = amount;
        this.bill = bill;
        this.paymentMode = paymentMode;
        this.transactionId = transactionId;
        this.paymentStatus = paymentStatus;
        this.paymentTime = paymentTime;
    }


    public double getAmount() {
        return amount;
    }

    public Bill getBill() {
        return bill;
    }


    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }


    public PaymentMode getPaymentMode() {
        return paymentMode;
    }


    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }


    public String getTransactionId() {
        return transactionId;
    }


    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }


    public void setPaymentTime(LocalDateTime paymentTime) {
        this.paymentTime = paymentTime;
    }


    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }


}
