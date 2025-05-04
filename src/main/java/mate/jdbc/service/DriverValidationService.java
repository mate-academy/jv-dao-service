package mate.jdbc.service;

import mate.jdbc.exception.ValidationException;
import mate.jdbc.lib.Dao;
import mate.jdbc.lib.Inject;
import mate.jdbc.model.Driver;

@Dao
@Inject
public class DriverValidationService {
    private Driver driver;

    public void validateBeforeCreate(Driver driver) {
        validateDriverName(driver.getName());
        validateLicenseNumber(driver.getLicenseNumber());
    }

    public void validateBeforeUpdate(Driver driver) {
        validateId(driver.getId());
        validateDriverName(driver.getName());
        validateLicenseNumber(driver.getLicenseNumber());
    }

    private void validateId(Long id) {
        if (id == null || id < 1) {
            throw new ValidationException("Invalid driver id");
        }
    }

    private void validateDriverName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new ValidationException("Driver name cannot be empty");
        }
        if (name.length() > 255) {
            throw new ValidationException("Driver name too long");
        }
    }

    private void validateLicenseNumber(String licenseNumber) {
        if (licenseNumber == null || licenseNumber.trim().isEmpty()) {
            throw new ValidationException("License number cannot be empty");
        }
    }
}
