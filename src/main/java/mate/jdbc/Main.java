package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final ManufacturerService manufacturerService = (ManufacturerService)
            injector.getInstance(ManufacturerService.class);
    private static final DriverService driverService = (DriverService)
            injector.getInstance(DriverService.class);

    public static void main(String[] args) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Toyota");
        manufacturer.setCountry("Japan");
        manufacturerService.create(manufacturer);
        manufacturer = manufacturerService.get(3L);
        manufacturer.setName("Renault");
        manufacturer.setCountry("France");
        Manufacturer updatedManufacturer = manufacturerService.update(manufacturer);
        System.out.println(updatedManufacturer);
        manufacturerService.delete(1L);
        manufacturerService.getAll().forEach(System.out::println);
        Driver driver = new Driver();
        driver.setName("Jack");
        driver.setLicenseNumber("443789");
        driverService.create(driver);
        driver = driverService.get(4L);
        driver.setName("Mark");
        driver.setLicenseNumber("589456");
        Driver updatedDriver = driverService.update(driver);
        System.out.println(updatedDriver);
        driverService.delete(3L);
        driverService.getAll().forEach(System.out::println);
    }
}
