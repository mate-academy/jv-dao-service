package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Long EXISTING_INSTANCE = 1L;
    private static final Long NOT_EXISTING_INSTANCE = 100L;
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);

        Manufacturer manufacturer = new Manufacturer(null, "Ford", "USA");
        System.out.println(manufacturerService.create(manufacturer));
        manufacturerService.getAll().forEach(System.out::println);

        Manufacturer updatedManufacturer = manufacturerService.get(EXISTING_INSTANCE);
        System.out.println(updatedManufacturer);

        updatedManufacturer.setName("Peugeot");
        manufacturerService.update(updatedManufacturer);
        manufacturerService.getAll().forEach(System.out::println);

        manufacturerService.delete(EXISTING_INSTANCE);
        manufacturerService.getAll().forEach(System.out::println);

        manufacturerService.get(NOT_EXISTING_INSTANCE);

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        Driver firstDriver = new Driver(null, "Bob", "12345");
        Driver secondDriver = new Driver(null, "John", "98765");
        Driver thirdDriver = new Driver(null, "Alice", "55555");

        List<Driver> driverList = List.of(firstDriver, secondDriver, thirdDriver);
        for (Driver driver : driverList) {
            System.out.println(driverService.create(driver));
        }

        Driver updatedDriver = driverService.get(EXISTING_INSTANCE);
        System.out.println(updatedDriver);

        updatedDriver.setName("Katty");
        driverService.update(updatedDriver);
        driverService.getAll().forEach(System.out::println);

        driverService.delete(EXISTING_INSTANCE);
        driverService.getAll().forEach(System.out::println);

        driverService.get(NOT_EXISTING_INSTANCE);
    }
}
