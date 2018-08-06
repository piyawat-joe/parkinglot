package com.zicbreeze.parkinglot.Model;

import com.zicbreeze.parkinglot.Interface.Car;

public class ParkingCar implements Car{
    String regisNo;
    String color;
    public ParkingCar(String regisNo, String color) {
        this.regisNo = regisNo;
        this.color = color;
    }
    @Override
    public void park() {

    }

    @Override
    public void leave() {

    }
}
