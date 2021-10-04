package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.setName("Peter");
        driver.setLicenseNumber("54322");
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        System.out.println(driverService.create(driver));
        Driver updateDriver = new Driver();
        updateDriver.setName("Bill");
        updateDriver.setId(driver.getId());
        updateDriver.setLicenseNumber(driver.getLicenseNumber());
        System.out.println(driverService.getAll());
        driverService.update(updateDriver);
        System.out.println(driverService.getAll());
        driverService.delete(updateDriver.getId());
        System.out.println(driverService.getAll());

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("LuAZ");
        manufacturer.setCountry("Ukraine");
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        System.out.println(manufacturerService.create(manufacturer));
        System.out.println(manufacturerService.get(manufacturer.getId()));
        System.out.println(manufacturerService.getAll());
        manufacturer.setCountry("Germany");
        manufacturerService.update(manufacturer);
        manufacturerService.getAll().forEach(System.out::println);
        manufacturerService.delete(manufacturer.getId());
        System.out.println(manufacturerService.getAll());
    }
}
