package controller;

import model.entities.Weekday;
import controller.exceptions.IncorrectDestinationException;
import controller.exceptions.IncorrectTimeException;
import controller.exceptions.IncorrectWeekdayException;

import java.util.Arrays;

class Validator {

    public static void checkTime(String input) {
        if(!input.matches("^([0-1][0-9]|2[0-3]):([0-5][0-9])$")) {
            throw new IncorrectTimeException(input);
        }
    }

    public static void checkDestination(String input) {
        if(!input.matches("[A-Z][a-z]+")) {
            throw new IncorrectDestinationException(input);
        }
    }

    public static void checkWeekday(String input) {
        if(!Arrays.toString(Weekday.values()).contains(input)) {
            throw new IncorrectWeekdayException(input);
        }
    }


}
