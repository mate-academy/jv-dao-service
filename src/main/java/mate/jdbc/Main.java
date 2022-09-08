package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Tesla");
        manufacturer.setCountry("USA");
        Manufacturer createManufacturer = manufacturerService.create(manufacturer);
        System.out.println(manufacturer);
        System.out.println("-------------------------------------------------");

        System.out.println("Read manufacturer");
        Manufacturer readManufacturer = manufacturerService.read(createManufacturer.getId());
        System.out.println(readManufacturer);
        System.out.println("-------------------------------------------------");

        System.out.println("Read all manufacturers");
        List<Manufacturer> allManufacturers = manufacturerService.readAll();
        allManufacturers.stream().forEach(System.out::println);
        System.out.println("-------------------------------------------------");

        System.out.println("Update manufacturer");
        Manufacturer updateManufacturer = new Manufacturer();
        updateManufacturer.setId(createManufacturer.getId());
        updateManufacturer.setName("BMW");
        updateManufacturer.setCountry("Germany");
        System.out.println(manufacturerService.update(updateManufacturer));
        System.out.println("-------------------------------------------------");

        System.out.println("Delete manufacturer");
        System.out.println(manufacturerService.delete(createManufacturer.getId()));
        System.out.println("-------------------------------------------------");

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver();
        driver.setLicenseNumber("26041995");
        driver.setName("Mirko");
        Driver createDriver = driverService.create(driver);
        System.out.println(driver);
        System.out.println("-------------------------------------------------");

        System.out.println("Read driver");
        Driver readDriver = driverService.read(createDriver.getId());
        System.out.println(readDriver);
        System.out.println("-------------------------------------------------");

        System.out.println("Read all drivers");
        List<Driver> allDrivers = driverService.readAll();
        allDrivers.stream().forEach(System.out::println);
        System.out.println("-------------------------------------------------");

        System.out.println("Update driver");
        Driver updateDriver = new Driver();
        updateDriver.setId(createDriver.getId());
        updateDriver.setName("Artem");
        updateDriver.setLicenseNumber("27041995");
        System.out.println(driverService.update(updateDriver));
        System.out.println("-------------------------------------------------");

        System.out.println("Delete driver");
        System.out.println(driverService.delete(createDriver.getId()));
        System.out.println("-------------------------------------------------");
    }
}
