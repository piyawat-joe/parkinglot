package com.zicbreeze.parkinglot.Controller;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.HashMap;

public class CommandMapping {
    public Map<String, Method> commandsMap;

    public CommandMapping() {
        commandsMap = new HashMap<String, Method>();
        try {
            populateCommandsHashMap();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    private void populateCommandsHashMap() throws NoSuchMethodException {
        commandsMap.put("create_parking_lot", ParkingController.class.getMethod("createParkingLot", String.class));
        commandsMap.put("park", ParkingController.class.getMethod("park", String.class, String.class));
        commandsMap.put("leave", ParkingController.class.getMethod("leave", String.class));
        commandsMap.put("status", ParkingController.class.getMethod("getStatus"));
        commandsMap.put("registration_numbers_for_cars_with_colour", ParkingController.class.getMethod("getRegistrationNoForCarsWithColour", String.class));
        commandsMap.put("slot_numbers_for_cars_with_colour", ParkingController.class.getMethod("getSlotNoForCarsWithColour", String.class));
        commandsMap.put("slot_number_for_registration_number", ParkingController.class.getMethod("getSlotNoForRegistrationNo", String.class));
    }
}
