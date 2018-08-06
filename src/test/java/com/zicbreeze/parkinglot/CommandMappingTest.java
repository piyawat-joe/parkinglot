package com.zicbreeze.parkinglot;
import com.zicbreeze.parkinglot.Controller.CommandMapping;

import org.junit.Test;
import static org.junit.Assert.*;

public class CommandMappingTest {
    CommandMapping commandMap = new CommandMapping();
    @Test
    public void checkCommandInList() throws Exception {
        assertFalse(commandMap.commandsMap.isEmpty());
        assertTrue(commandMap.commandsMap.containsKey("create_parking_lot"));
        assertTrue(commandMap.commandsMap.containsKey("status"));
        assertFalse(commandMap.commandsMap.containsKey("test"));
    }
}