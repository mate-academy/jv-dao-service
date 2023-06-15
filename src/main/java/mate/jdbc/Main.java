package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setCountry("Germany");
        manufacturer.setName("Mercedes");
        System.out.println(manufacturerService.create(manufacturer));
        manufacturer.setName("Lamborghini");
        manufacturer.setCountry("Italy");
        manufacturerService.update(manufacturer);
        System.out.println(manufacturerService.get(5L));
        System.out.println(manufacturerService.delete(manufacturer.getId()));
        System.out.println(manufacturerService.getAll());
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver();
        driver.setName("David");
        driver.setLicenseNumber("123456");
        driverService.create(driver);
        System.out.println(driverService.get(1L));
        driver.setName("Artem");
        driverService.update(driver);
        System.out.println(driverService.getAll());
    }
}
