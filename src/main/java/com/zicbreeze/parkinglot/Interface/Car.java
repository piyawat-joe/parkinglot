package com.zicbreeze.parkinglot.Interface;

public interface Car {
    public String color = "";
    public String regisNo = "";
    public void createParkingLot(String lotNo);
    public void park(String regNo, String color) ;
    public void leave(String slotNo);
    public void getStatus();
    public void getRegistrationNoForCarsWithColour(String color);
    public void getSlotNoForCarsWithColour(String color);
    public void getSlotNoForRegistrationNo (String regisNo);
}
