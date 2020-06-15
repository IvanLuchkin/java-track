package controller;

import model.Weekday;
import model.exceptions.IncorrectDestinationException;
import model.exceptions.IncorrectTimeException;
import model.exceptions.IncorrectWeekdayException;

import java.util.Arrays;

class Validator {

    void checkTime(String input) {
        if(!input.matches("^([0-1][0-9]|2[0-3]):([0-5][0-9])$")) {
            throw new IncorrectTimeException();
        }
    }

    void checkDestination(String input) {
        if(!input.matches("[A-Z][a-z]+")) {
            throw new IncorrectDestinationException();
        }
    }

    void checkWeekday(String input) {
        if(!Arrays.toString(Weekday.values()).contains(input)) {
            throw new IncorrectWeekdayException();
        }
    }


}
