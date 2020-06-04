package controller.exceptions;

public class IncorrectWeekdayException extends RuntimeException {

    public IncorrectWeekdayException() {
        super("Incorrect weekday. Please, try again.\n");
    }

    public IncorrectWeekdayException(String message) {
        super("Incorrect weekday " + message + ". Please, try again.\n");
    }

}
