package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final ManufacturerService manufacturerService =
            (ManufacturerService) injector.getInstance(ManufacturerService.class);
    private static final DriverService driverService =
            (DriverService) injector.getInstance(DriverService.class);

    public static void main(String[] args) {
        Driver firstDriver = new Driver();
        firstDriver.setName("Bob");
        firstDriver.setLicenseNumber("19283735");
        Driver secondDriver = new Driver();
        secondDriver.setName("John");
        secondDriver.setLicenseNumber("17342964");
        driverService.create(firstDriver);
        driverService.create(secondDriver);
        List<Driver> allDrivers = driverService.getAll();
        allDrivers.forEach(System.out::println);
        driverService.get(firstDriver.getId());
        secondDriver.setName("Bill");
        driverService.update(secondDriver);
        System.out.println(secondDriver);
        driverService.delete(secondDriver.getId());

        Manufacturer firstCar = new Manufacturer();
        firstCar.setName("Reno");
        firstCar.setCountry("France");
        Manufacturer secondCar = new Manufacturer();
        secondCar.setName("Toyota");
        secondCar.setCountry("Japan");
        manufacturerService.create(firstCar);
        manufacturerService.create(secondCar);
        List<Manufacturer> allManufacturers = manufacturerService.getAll();
        allManufacturers.forEach(System.out::println);
        System.out.println(manufacturerService.get(firstCar.getId()));
        secondCar.setName("Mazda");
        manufacturerService.update(secondCar);
        System.out.println(secondCar);
        manufacturerService.delete(secondCar.getId());
    }
}
