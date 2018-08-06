package com.zicbreeze.parkinglot.View;

import com.zicbreeze.parkinglot.Controller.CommandMapping;
import com.zicbreeze.parkinglot.Controller.ParkingController;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UserInput {
    ParkingController parkingLot;
    CommandMapping commandMap;
    public UserInput() {
        commandMap = new CommandMapping();
        parkingLot = new ParkingController();
    }
    public void parseTextInput(String input) {
        String[] inputs = input.split(" ");
        switch (inputs.length) {
            case 1:
                try {
                    Method method = commandMap.commandsMap.get(input);
                    if (method != null) {
                        method.invoke(parkingLot);
                    } else {
                        System.out.println("Invalid input.");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    Method method = commandMap.commandsMap.get(inputs[0]);
                    if (method != null) {
                        method.invoke(parkingLot, inputs[1]);
                    } else {
                        System.out.println("Invalid input.");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try {
                    Method method = commandMap.commandsMap.get(inputs[0]);
                    if (method != null) {
                        method.invoke(parkingLot, inputs[1], inputs[2]);
                    } else {
                        System.out.println("Invalid input.");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Invalid input.");
        }
    }
    public void parseFileInput(String filePath) {
        File inputFile = new File(filePath);
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            String line;
            try {
                while ((line = br.readLine()) != null) {
                    parseTextInput(line.trim());
                }
            } catch (IOException ex) {
                System.out.println("Error File reading.");
                ex.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }
}
