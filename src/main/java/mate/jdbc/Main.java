package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Mercedes");
        manufacturer.setCountry("Ukraine");
        Manufacturer saveManufacturer = manufacturerService.create(manufacturer);
        System.out.println(saveManufacturer + " create method");
        Manufacturer saveManufacturerById =
                manufacturerService.get(saveManufacturer.getId());
        System.out.println(saveManufacturerById + " get method");
        List<Manufacturer> allManufacturers = manufacturerService.getAll();
        System.out.println(allManufacturers + " getAll method");
        manufacturer.setCountry("Germany");
        manufacturerService.update(manufacturer);
        allManufacturers = manufacturerService.getAll();
        System.out.println(allManufacturers + " update method");
        manufacturerService.delete(manufacturer.getId());
        allManufacturers = manufacturerService.getAll();
        System.out.println(allManufacturers + " delete method");
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver();
        driver.setName("Oleg");
        driver.setLicenseNumber("1234UA");
        Driver saveDriver = driverService.create(driver);
        System.out.println(saveDriver + " create method");
        Driver saveDriverById =
                driverService.get(saveDriver.getId());
        System.out.println(saveDriverById + " get method");
        List<Driver> allDrivers = driverService.getAll();
        System.out.println(allDrivers + " getAll method");
        driver.setName("Misha");
        driverService.update(driver);
        allDrivers = driverService.getAll();
        System.out.println(allDrivers + " update method");
        driverService.delete(driver.getId());
        allDrivers = driverService.getAll();
        System.out.println(allDrivers + " delete method");
    }
}
