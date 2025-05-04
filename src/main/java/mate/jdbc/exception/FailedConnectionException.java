package mate.jdbc.exception;

public class FailedConnectionException extends RuntimeException {
    public FailedConnectionException(String message, Throwable exception) {
        super(message);
    }
}
