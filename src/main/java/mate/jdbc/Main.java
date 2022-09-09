package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        final ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        Manufacturer car = new Manufacturer();
        car.setName("Tesla");
        car.setCountry("USA");
        manufacturerService.create(car);
        System.out.println("Created manufacturer " + car);
        System.out.println("Get by id : " + car.getId());
        System.out.println("Get all : " + manufacturerService.getAll());
        car.setName("Toyota");
        car.setCountry("China");
        System.out.println("Update : " + manufacturerService.update(car));
        System.out.println("Get : " + manufacturerService.get(car.getId()));
        System.out.println("AND ACTUAL is : " + manufacturerService.delete(car.getId()));
        System.out.println("After delete : " + manufacturerService.getAll());
        final DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        Driver driver = new Driver();
        driver.setName("Bob");
        driver.setLicenseNumber("31547");
        System.out.println("Driver is : " + driverService.create(driver));
        System.out.println("Get by id : " + driverService.get(driver.getId()));
        System.out.println("Get all : " + driverService.getAll());
        driver.setName("Mark");
        System.out.println("After update : " + driverService.update(driver));
        System.out.println("Get id : " + driverService.get(driver.getId()));
    }
}
