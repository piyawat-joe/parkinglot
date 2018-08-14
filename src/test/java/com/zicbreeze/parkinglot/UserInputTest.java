package com.zicbreeze.parkinglot;
import com.zicbreeze.parkinglot.View.UserInput;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class UserInputTest {
    UserInput input = new UserInput();
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
    public void parseTextInput() throws Exception {
        input.parseTextInput("hello");
        assertEquals("Invalid input.\n", outContent.toString());
        input.parseTextInput("status");
        assertEquals("Invalid input.\n" +
                "Sorry, No parking lot created\n", outContent.toString());
    }

}