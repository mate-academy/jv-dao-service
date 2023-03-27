package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerSevice;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerSevice manufacturerSevice = (ManufacturerSevice)
                injector.getInstance(ManufacturerSevice.class);
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        //manufacturer test
        Manufacturer createdManufacturer = manufacturerSevice.create(
                new Manufacturer("Audi", "Germany"));
        System.out.println("Final manufacturer is: "
                + manufacturerSevice.get(manufacturerSevice.update(
                new Manufacturer(createdManufacturer.getId(), "Shmaudi", "Zimbabwe")).getId()));
        //driver test
        Driver createdDriver = driverService.create(
                new Driver("Oleksandr", "25565"));
        System.out.println("Created driver: " + driverService.get(createdDriver.getId()));
        System.out.println("Updated driver: " + driverService.update(
                new Driver(createdDriver.getId(), "Oleksandra", "25565")));
        System.out.println("All Drivers: ");
        driverService.getAll().forEach(System.out::println);
        driverService.delete(createdDriver.getId());
        System.out.println("All Drivers after delete: " + System.lineSeparator());
        driverService.getAll().forEach(System.out::println);
    }
}
