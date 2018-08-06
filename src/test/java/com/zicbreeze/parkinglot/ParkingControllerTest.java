package com.zicbreeze.parkinglot;
import com.zicbreeze.parkinglot.Controller.ParkingController;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.Environment;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;


public class ParkingControllerTest {
    ParkingController parkingLot = new ParkingController();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
    @Test
    public void createParkingLot() throws Exception {
        parkingLot.createParkingLot("6");
        assertEquals(6, parkingLot.SIZE);
        assertEquals(6, parkingLot.availableList.size());
        assertEquals("Created a parking lot with 6 slots\n\n",outContent.toString());
    }

    @Test
    public void park() throws Exception {
        parkingLot.park("KA-01-HH-1234", "White");
        parkingLot.park("KA-01-HH-9999", "White");
        assertEquals("Sorry, No parking lot created\n" +
                "\n" +
                "Sorry, No parking lot created\n\n", outContent.toString());
        parkingLot.createParkingLot("6");
        parkingLot.park("KA-01-HH-1234", "White");
        parkingLot.park("KA-01-HH-9999", "White");
        assertEquals(4, parkingLot.availableList.size());
    }

    @Test
    public void leave() throws Exception {
        parkingLot.leave("2");
        assertEquals("Sorry, No parking lot created\n\n", outContent.toString());
        parkingLot.createParkingLot("6");
        parkingLot.park("KA-01-HH-1234", "White");
        parkingLot.park("KA-01-HH-9999", "White");
        parkingLot.leave("4");
        assertEquals("Sorry, No parking lot created\n" +
                "\n" +
                "Created a parking lot with 6 slots\n" +
                "\n" +
                "Allocated slot number: 1\n" +
                "\n" +
                "Allocated slot number: 2\n" +
                "\n" +
                "Slot number 4 is already empty\n\n", outContent.toString());
    }

    @Test
    public void getStatus() throws Exception {
        parkingLot.getStatus();
        assertEquals("Sorry, No parking lot created\n\n", outContent.toString());
        parkingLot.createParkingLot("6");
        parkingLot.park("KA-01-HH-1234", "White");
        parkingLot.park("KA-01-HH-9999", "White");
        parkingLot.getStatus();
        assertEquals("Sorry, No parking lot created\n" +
                "\n" +
                "Created a parking lot with 6 slots\n" +
                "\n" +
                "Allocated slot number: 1\n" +
                "\n" +
                "Allocated slot number: 2\n" +
                "\n" +
                "Slot No.\tRegistration No.\tColor\n" +
                "1\tKA-01-HH-1234\tWhite\n" +
                "2\tKA-01-HH-9999\tWhite\n\n", outContent.toString());
    }

    @Test
    public void getRegistrationNoForCarsWithColour() throws Exception {
        parkingLot.getRegistrationNoForCarsWithColour("White");
        assertEquals("Sorry, No parking lot created\n\n", outContent.toString());
        parkingLot.createParkingLot("6");
        parkingLot.park("KA-01-HH-1234", "White");
        parkingLot.park("KA-01-HH-9999", "White");
        parkingLot.getRegistrationNoForCarsWithColour("White");
        assertEquals("Sorry, No parking lot created\n" +
                "\n" +
                "Created a parking lot with 6 slots\n" +
                "\n" +
                "Allocated slot number: 1\n" +
                "\n" +
                "Allocated slot number: 2\n" +
                "\n" +
                "\n" +
                "KA-01-HH-1234,KA-01-HH-9999", outContent.toString());
        parkingLot.getRegistrationNoForCarsWithColour("Red");
        assertEquals("Sorry, No parking lot created\n" +
                "\n" +
                "Created a parking lot with 6 slots\n" +
                "\n" +
                "Allocated slot number: 1\n" +
                "\n" +
                "Allocated slot number: 2\n" +
                "\n" +
                "\n" +
                "KA-01-HH-1234,KA-01-HH-9999Not found\n\n", outContent.toString());
    }

    @Test
    public void getSlotNoForCarsWithColour() throws Exception {
        parkingLot.getSlotNoForCarsWithColour("White");
        assertEquals("Sorry, No parking lot created\n\n", outContent.toString());
        parkingLot.createParkingLot("6");
        parkingLot.park("KA-01-HH-1234", "White");
        parkingLot.park("KA-01-HH-9999", "White");
        parkingLot.getSlotNoForCarsWithColour("White");
        assertEquals("Sorry, No parking lot created\n" +
                "\n" +
                "Created a parking lot with 6 slots\n" +
                "\n" +
                "Allocated slot number: 1\n" +
                "\n" +
                "Allocated slot number: 2\n" +
                "\n" +
                "\n" +
                "1,2\n", outContent.toString());
        parkingLot.getSlotNoForCarsWithColour("Red");
        assertEquals("Sorry, No parking lot created\n" +
                "\n" +
                "Created a parking lot with 6 slots\n" +
                "\n" +
                "Allocated slot number: 1\n" +
                "\n" +
                "Allocated slot number: 2\n" +
                "\n" +
                "\n" +
                "1,2\n" +
                "Not found\n\n", outContent.toString());
    }

    @Test
    public void getSlotNoForRegistrationNo() throws Exception {
        parkingLot.getSlotNoForRegistrationNo("KA-01-HH-1234");
        assertEquals("Sorry, No parking lot created\n\n", outContent.toString());
        parkingLot.createParkingLot("6");
        parkingLot.park("KA-01-HH-1234", "White");
        parkingLot.park("KA-01-HH-9999", "White");
        parkingLot.getSlotNoForRegistrationNo("KA-01-HH-1234");
        assertEquals("Sorry, No parking lot created\n" +
                "\n" +
                "Created a parking lot with 6 slots\n" +
                "\n" +
                "Allocated slot number: 1\n" +
                "\n" +
                "Allocated slot number: 2\n" +
                "\n" +
                "1\n", outContent.toString());
        parkingLot.getSlotNoForRegistrationNo("KA-01-HH-9999");
        assertEquals("Sorry, No parking lot created\n" +
                "\n" +
                "Created a parking lot with 6 slots\n" +
                "\n" +
                "Allocated slot number: 1\n" +
                "\n" +
                "Allocated slot number: 2\n" +
                "\n" +
                "1\n" +
                "2\n", outContent.toString());
        parkingLot.leave("1");
        parkingLot.getSlotNoForRegistrationNo("KA-01-HH-1234");
        assertEquals("Sorry, No parking lot created\n" +
                "\n" +
                "Created a parking lot with 6 slots\n" +
                "\n" +
                "Allocated slot number: 1\n" +
                "\n" +
                "Allocated slot number: 2\n" +
                "\n" +
                "1\n" +
                "2\n" +
                "Slot number 1 is free\n" +
                "\n" +
                "Not found\n\n", outContent.toString());
    }

}