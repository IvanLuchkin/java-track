package controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class InputController {

    private  Scanner scanner;
    private static final Logger LOGGER = LogManager.getLogger(InputController.class);

    public InputController() {
        scanner = new Scanner(System.in);
    }

    public  String inputValue() {
        return scanner.nextLine();
    }

}
