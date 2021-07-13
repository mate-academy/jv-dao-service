package mate.jdbc;

import mate.jdbc.dao.ManufacturerService;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Renault");
        manufacturer.setCountry("France");
        manufacturerService.create(manufacturer);
        manufacturerService.getAll();
        manufacturerService.get(2L);
        Manufacturer manufacturer1 = new Manufacturer();
        manufacturer1.setId(2L);
        manufacturer1.setName("Mercedes");
        manufacturer1.setCountry("Germany");
        manufacturerService.update(manufacturer1);
        manufacturerService.delete(2L);

        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);
        Driver driver = new Driver();
        driver.setName("Bob");
        driver.setLicenseNumber("083956875");
        driverService.create(driver);
        driverService.getAll();
        driverService.get(1L);
        Driver driver1 = new Driver();
        driver1.setId(1L);
        driver1.setName("Yurii");
        driver1.setLicenseNumber("CXV05905");
        driverService.update(driver1);
        driverService.delete(1L);
    }
}
