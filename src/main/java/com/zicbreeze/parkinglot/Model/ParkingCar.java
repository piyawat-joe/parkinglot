package com.zicbreeze.parkinglot.Model;

import com.zicbreeze.parkinglot.Interface.Car;

public class ParkingCar implements Car{
    public String regisNo;
    public String color;
    public ParkingCar(String regisNo, String color) {
        this.regisNo = regisNo;
        this.color = color;
    }

    @Override
    public void createParkingLot(String lotNo) {

    }

    @Override
    public void park(String regNo, String color) {

    }

    @Override
    public void leave(String slotNo) {

    }

    @Override
    public void getStatus() {

    }

    @Override
    public void getRegistrationNoForCarsWithColour(String color) {

    }

    @Override
    public void getSlotNoForCarsWithColour(String color) {

    }

    @Override
    public void getSlotNoForRegistrationNo(String regisNo) {

    }
}
