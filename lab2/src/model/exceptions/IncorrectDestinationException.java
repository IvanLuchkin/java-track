package model.exceptions;

public class IncorrectDestinationException extends RuntimeException {

    public IncorrectDestinationException() {
        super("Incorrect destination. Please, try again.\n");
    }

    public IncorrectDestinationException(String message) {
        super(message);
    }

}
