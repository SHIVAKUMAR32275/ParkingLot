package org.ParkingLot.Models;

import java.time.LocalDateTime;


public abstract class BaseModel {
    private int id;
    private LocalDateTime isCreatedAt;
    private LocalDateTime isUpdatedAt;
    private String createdBy;
    private String updatedBy;


    public BaseModel(){

    }

    public BaseModel(int id,LocalDateTime isCreatedAt,LocalDateTime isUpdatedAt,String createdBy,String updatedBy){
        this.id = id;
        this.isCreatedAt = isCreatedAt;
        this.isUpdatedAt = isUpdatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }


    public int getId() {
        return id;
    }


    public LocalDateTime getIsCreatedAt() {
        return isCreatedAt;
    }

    public LocalDateTime getIsUpdatedAt() {
        return isUpdatedAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }


    public void setIsCreatedAt(LocalDateTime isCreatedAt) {
        this.isCreatedAt = isCreatedAt;
    }

    public void setIsUpdatedAt(LocalDateTime isUpdatedAt) {
        this.isUpdatedAt = isUpdatedAt;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

}
