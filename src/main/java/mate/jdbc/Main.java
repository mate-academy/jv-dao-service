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
                new Manufacturer("Citroen", "France"),
                new Manufacturer("Toyota", "Japan")
        );
        System.out.println("\nTest manufacturerService create:");
        for (Manufacturer manufacturer : manufacturers) {
            manufacturerService.create(manufacturer);
        }
        System.out.println(manufacturers);

        System.out.println("\nTest manufacturerService getAll:");
        manufacturers = manufacturerService.getAll();
        manufacturers.forEach(System.out::println);

        List<Driver> drivers = List.of(
                new Driver("Teodor Rusvelt", "123456789"),
                new Driver("Ronald Reigan", "159753456"),
                new Driver("Donald Trump", "999666999")
        );

        System.out.println("\nTest driverService create:");
        for (Driver driver : drivers) {
            driverService.create(driver);
        }
        System.out.println(manufacturers);

        Long id = 1L;
        System.out.println("\nTest driverService delete by id = " + id + " :");
        System.out.println(driverService.delete(id));

        id = 2L;
        System.out.println("\nTest driverService get by id = " + id + " :");
        System.out.println(driverService.get(id));

        Driver driver = new Driver(id, "Hary Crishna", "777777777777");
        System.out.println("\nTest driverService update driver:");
        System.out.println(driver);
        System.out.println(driverService.update(driver));

        System.out.println("\nTest driverService getAll:");
        drivers = driverService.getAll();
        drivers.forEach(System.out::println);
    }
}
