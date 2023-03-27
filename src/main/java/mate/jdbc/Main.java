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
        Manufacturer updatedManufacturer = manufacturerSevice.update(
                new Manufacturer(createdManufacturer.getId(), "Shmaudi", "Zimbabwe"));
        System.out.println("Final manufacturer is: " + manufacturerSevice.get(updatedManufacturer.getId()));
        //driver test
        Driver createdDriver = driverService.create(new Driver("Oleksandr", "25565"));
        System.out.println("Created driver: " + driverService.get(createdDriver.getId()));
        Driver updatedDriver = driverService.update(new Driver(createdDriver.getId(), "Oleksandra", "25565"));
        System.out.println("Updated driver: " + driverService.get(updatedDriver.getId()));
        System.out.println("All Drivers: ");
        driverService.getAll().forEach(System.out::println);
        driverService.delete(updatedDriver.getId());
        System.out.println("All Drivers after delete: " + System.lineSeparator());
        driverService.getAll().forEach(System.out::println);
    }
}
