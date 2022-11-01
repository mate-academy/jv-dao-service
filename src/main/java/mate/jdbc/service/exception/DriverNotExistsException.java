package mate.jdbc.service.exception;

public class DriverNotExistsException extends RuntimeException {
    public DriverNotExistsException(String message) {
        super(message);
    }
}
