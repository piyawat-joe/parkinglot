package com.zicbreeze.parkinglot;
import com.zicbreeze.parkinglot.View.UserInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) {
        UserInput UserInput = new UserInput();
        switch (args.length) {
            case 0:
                System.out.println("Input 'exit' to quit or input command");
                for (;;) {
                    try {
                        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
                        String inputString = bufferRead.readLine();
                        if (inputString.equalsIgnoreCase("exit")) {
                            break;
                        } else if ((inputString == null) || (inputString.isEmpty())) {
                        } else {
                            UserInput.parseTextInput(inputString.trim());
                        }
                    } catch(IOException e) {
                        System.out.println("Error input from command line.");
                        e.printStackTrace();
                    }
                }
                break;
            case 1:
                UserInput.parseFileInput(args[0]);
                break;
            default:
                System.out.println("Invalid input.");
        }
    }
}
