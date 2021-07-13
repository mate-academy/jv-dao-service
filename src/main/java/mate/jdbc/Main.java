package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Peugeot");
        manufacturer.setCountry("France");
        manufacturerService.create(manufacturer);
        manufacturerService.getAll();
        manufacturerService.get(3L);
        Manufacturer manufacturer1 = new Manufacturer();
        manufacturer1.setId(3L);
        manufacturer1.setName("Porsche");
        manufacturer1.setCountry("Germany");
        manufacturerService.update(manufacturer1);
        manufacturerService.delete(3L);

        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);
        Driver driver = new Driver();
        driver.setName("Alice");
        driver.setLicenseNumber("083915675");
        driverService.create(driver);
        driverService.getAll();
        driverService.get(2L);
        Driver driver1 = new Driver();
        driver1.setId(2L);
        driver1.setName("Alex");
        driver1.setLicenseNumber("CXV02305");
        driverService.update(driver1);
        driverService.delete(2L);
    }
}
