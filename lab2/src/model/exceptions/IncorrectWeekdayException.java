package model.exceptions;

public class IncorrectWeekdayException extends RuntimeException {

    public IncorrectWeekdayException() {
        super("Incorrect weekday. Please, try again.\n");
    }

    public IncorrectWeekdayException(String message) {
        super(message);
    }

}
