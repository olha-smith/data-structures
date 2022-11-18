package data.structures.exceptions;

public class UnsupportedOperationException extends RuntimeException {

    public static final String MESSAGE = "This operation isn't supported yet";

    public UnsupportedOperationException() {
        super(MESSAGE);
    }
}
