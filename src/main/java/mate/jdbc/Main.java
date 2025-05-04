package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {

    private static final Injector injector = Injector.getInstance("mate");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        //Create
        Manufacturer newManufacturer = new Manufacturer();
        newManufacturer.setName("Mercedes");
        newManufacturer.setCountry("Germany");
        manufacturerService.create(newManufacturer);
        //Read
        List<Manufacturer> allManufacturers = manufacturerService.getAll();
        for (Manufacturer manufacturer : allManufacturers) {
            System.out.println(manufacturer);
        }
        Long id = newManufacturer.getId();
        Manufacturer manufacturer = manufacturerService.get(id);
        if (manufacturer != null) {
            System.out.println(manufacturer);
        } else {
            System.out.println("There is no manufacturer with such id (id = " + id + ")");
        }
        //Update
        newManufacturer.setName("Mercedes2");
        manufacturerService.update(newManufacturer);
        //Delete
        manufacturerService.delete(newManufacturer.getId());

        //DRIVER
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        //Create
        Driver newDriver = new Driver();
        newDriver.setName("Anton");
        newDriver.setLicenseNumber("12345");
        driverService.create(newDriver);
        //Read
        List<Driver> allDrivers = driverService.getAll();
        for (Driver driver : allDrivers) {
            System.out.println(driver);
        }
        Long driverId = newDriver.getId();
        Driver driver = driverService.get(driverId);
        if (driver != null) {
            System.out.println(driver);
        } else {
            System.out.println("There is no manufacturer with such id (id = " + driverId + ")");
        }
        //Update
        newDriver.setName("Anton2");
        driverService.update(newDriver);
        //Delete
        driverService.delete(newDriver.getId());

    }
}
