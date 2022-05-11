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
        //create
        Manufacturer createManufacturer = new Manufacturer();
        createManufacturer.setName("Alfa Romeo");
        createManufacturer.setCountry("Italy");
        createManufacturer = manufacturerService.create(createManufacturer);
        System.out.println("create"
                + System.lineSeparator() + createManufacturer + System.lineSeparator());
        //get
        Manufacturer testManufacturer = manufacturerService.get(5L);
        System.out.println("get"
                + System.lineSeparator() + testManufacturer + System.lineSeparator());
        //getAll
        System.out.println("getAll");
        List<Manufacturer> allManufacturers = manufacturerService.getAll();
        for (Manufacturer manufacturer: allManufacturers) {
            System.out.println(manufacturer);
        }
        System.out.println(System.lineSeparator());
        //update
        Manufacturer updateManufacturer = new Manufacturer();
        updateManufacturer.setName("Fiat");
        updateManufacturer.setCountry("Italy");
        updateManufacturer.setId(12L);
        manufacturerService.update(updateManufacturer);
        System.out.println("update" + System.lineSeparator() + manufacturerService.get(5L));
        //delete
        System.out.println("delete");
        manufacturerService.delete(4L);
        List<Manufacturer> allAfter = manufacturerService.getAll();
        for (Manufacturer manufacturer: allAfter) {
            System.out.println(manufacturer);
        }
        //create
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver createDriver = new Driver();
        createDriver.setName("Matvii");
        createDriver.setLicenseNumber("234");
        createDriver = driverService.create(createDriver);
        System.out.println("create"
                + System.lineSeparator() + createDriver + System.lineSeparator());
        //get
        Driver testDriver = driverService.get(2L);
        System.out.println("get" + System.lineSeparator() + testDriver + System.lineSeparator());
        //getAll
        System.out.println("getAll");
        List<Driver> allDrivers = driverService.getAll();
        for (Driver driver: allDrivers) {
            System.out.println(driver);
        }
        //update
        Driver updateDriver = new Driver();
        updateDriver.setName("Oleksandra");
        updateDriver.setLicenseNumber("456");
        updateDriver.setId(2L);
        driverService.update(updateDriver);
        System.out.println("update" + System.lineSeparator() + driverService.get(2L));
        //delete
        System.out.println("delete");
        driverService.delete(2L);
        List<Driver> driversAfter = driverService.getAll();
        for (Driver driver: driversAfter) {
            System.out.println(driver);
        }
    }
}
