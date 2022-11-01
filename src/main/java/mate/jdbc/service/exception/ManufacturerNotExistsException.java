package mate.jdbc.service.exception;

public class ManufacturerNotExistsException extends RuntimeException {
    public ManufacturerNotExistsException(String message) {
        super(message);
    }
}
