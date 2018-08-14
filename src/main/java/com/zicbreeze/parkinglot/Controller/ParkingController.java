package com.zicbreeze.parkinglot.Controller;
import java.util.*;

import com.zicbreeze.parkinglot.Interface.Car;
import com.zicbreeze.parkinglot.Model.ParkingCar;

public class ParkingController implements Car {
    public int SIZE = 0;
    public ArrayList<Integer> availableList;
    public Map<String, ParkingCar> slotMap1;
    public Map<String, String> slotMap2;
    public Map<String, ArrayList<String>> slotMap3;

    @Override
    public void createParkingLot(String lotNo) {
        try {
            SIZE = Integer.parseInt(lotNo);
        } catch (Exception e) {
            System.out.println("Invalid lot No");
        }
        availableList = new ArrayList<Integer>() {};
        for (int i=1; i<= SIZE; i++) {
            availableList.add(i);
        }
        slotMap1 = new HashMap<String, ParkingCar>();
        slotMap2 = new HashMap<String, String>();
        slotMap3 = new HashMap<String, ArrayList<String>>();
        System.out.println("Created a parking lot with " + lotNo + " slots");
    }

    @Override
    public void park(String regisNo, String color) {
        if (SIZE == 0) {
            System.out.println("Sorry, No parking lot created");
        } else if (slotMap1.size() == SIZE) {
            System.out.println("Sorry, parking lot is full");
        } else {
            Collections.sort(availableList);
            String slot = availableList.get(0).toString();
            ParkingCar car = new ParkingCar(regisNo, color);
            slotMap1.put(slot, car);
            slotMap2.put(regisNo, slot);
            if (slotMap3.containsKey(color)) {
                ArrayList<String> regisNoList = slotMap3.get(color);
                slotMap3.remove(color);
                regisNoList.add(regisNo);
                slotMap3.put(color, regisNoList);
            } else {
                ArrayList<String> regisNoList = new ArrayList<String>();
                regisNoList.add(regisNo);
                slotMap3.put(color, regisNoList);
            }
            System.out.println("Allocated slot number: " + slot);
            availableList.remove(0);
        }
    }

    @Override
    public void leave(String slotNo) {
        if (SIZE == 0) {
            System.out.println("Sorry, No parking lot created");
        } else if (slotMap1.size() > 0) {
            ParkingCar leaveCar = slotMap1.get(slotNo);
            if (leaveCar != null) {
                slotMap1.remove(slotNo);
                slotMap2.remove(leaveCar.regisNo);
                ArrayList<String> regisNoList = slotMap3.get(leaveCar.color);
                if (regisNoList.contains(leaveCar.regisNo)) {
                    regisNoList.remove(leaveCar.regisNo);
                }
                // Add the Lot No. back to available slot list.
                availableList.add(Integer.parseInt(slotNo));
                System.out.println("Slot number " + slotNo + " is free");
            } else {
                System.out.println("Slot number " + slotNo + " is already empty");
            }
        } else {
            System.out.println("Parking lot is empty");
        }
    }

    @Override
    public void getStatus() {
        if (SIZE == 0) {
            System.out.println("Sorry, No parking lot created");
        } else if (slotMap1.size() > 0) {
            // Print the current status.
            System.out.println("Slot No.\tRegistration No.\tColour");
            ParkingCar car;
            for (int i = 1; i <= SIZE; i++) {
                String key = Integer.toString(i);
                if (slotMap1.containsKey(key)) {
                    car = slotMap1.get(key);
                    System.out.println(i + "\t" + car.regisNo + "\t" + car.color);
                }
            }
            //System.out.println();
        } else {
            System.out.println("Parking lot is empty");
        }
    }

    @Override
    public void getRegistrationNoForCarsWithColour(String color) {
        if (SIZE == 0) {
            System.out.println("Sorry, No parking lot created");
        } else if (slotMap3.containsKey(color)) {
            ArrayList<String> regisNoList = slotMap3.get(color);
            for (int i=0; i < regisNoList.size(); i++) {
                if (!(i==regisNoList.size() - 1)){
                    System.out.print(regisNoList.get(i) + ", ");
                } else {
                    System.out.println(regisNoList.get(i));
                }
            }
        } else {
            System.out.println("Not found");
        }
    }

    @Override
    public void getSlotNoForCarsWithColour(String color) {
        if (SIZE == 0) {
            System.out.println("Sorry, No parking lot created");
        } else if (slotMap3.containsKey(color)) {
            ArrayList<String> regisNoList = slotMap3.get(color);
            ArrayList<Integer> slotList = new ArrayList<Integer>();
            for (int i=0; i < regisNoList.size(); i++) {
                slotList.add(Integer.valueOf(slotMap2.get(regisNoList.get(i))));
            }
            Collections.sort(slotList);
            for (int j=0; j < slotList.size(); j++) {
                if (!(j == slotList.size() - 1)) {
                    System.out.print(slotList.get(j) + ", ");
                } else {
                    System.out.println(slotList.get(j));
                }
            }
        } else {
            System.out.println("Not found");
        }
    }

    @Override
    public void getSlotNoForRegistrationNo (String regisNo) {
        if (SIZE == 0) {
            System.out.println("Sorry, No parking lot created");
        } else if (slotMap2.containsKey(regisNo)) {
            System.out.println(slotMap2.get(regisNo));
        } else {
            System.out.println("Not found");
        }
    }
}
