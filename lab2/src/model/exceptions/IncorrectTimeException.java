package model.exceptions;

public class IncorrectTimeException extends RuntimeException {

    public IncorrectTimeException() {
        super("Incorrect time. Please, try again.\n");
    }

    public IncorrectTimeException(String message) {
        super(message);
    }

}
