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
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);

        List<Manufacturer> manufacturers = List.of(
                new Manufacturer("BMW", "Germany"),
                new Manufacturer("Toyota", "Japan"),
                new Manufacturer("Volvo", "Sweden"),
                new Manufacturer("Ford", "USA")
        );

        System.out.println("\nTest manufacturerService create:");
        for (Manufacturer manufacturer : manufacturers) {
            manufacturerService.create(manufacturer);
        }
        System.out.println(manufacturers);

        Long manufacturerID = 3L;
        System.out.println("\nTest get manufacturerService by id = " + manufacturerID);
        System.out.println("return = " + manufacturerService.get(manufacturerID));

        System.out.println("\nTest manufacturerService getAll:");
        manufacturers = manufacturerService.getAll();
        manufacturers.forEach(System.out::println);

        System.out.println("\nTest delete manufacturer by id = " + manufacturerID);
        System.out.println("return = " + manufacturerService.delete(manufacturerID));

        List<Driver> drivers = List.of(
                new Driver("Taras", "12121212"),
                new Driver("Petro", "13131313"),
                new Driver("Stepan", "14141414"),
                new Driver("Ivan", "98989898")
        );

        System.out.println("\nTest driverService create:");
        for (Driver driver : drivers) {
            driverService.create(driver);
        }
        System.out.println(drivers);

        Long driverId = 2L;
        System.out.println("\nTest get driverService by id = " + driverId);
        System.out.println("return = " + driverService.get(driverId));

        System.out.println("\nTest driverService getAll:");
        drivers = driverService.getAll();
        drivers.forEach(System.out::println);

        System.out.println("\nTest delete driver by id = " + driverId);
        System.out.println("return = " + manufacturerService.delete(driverId));
    }
}
