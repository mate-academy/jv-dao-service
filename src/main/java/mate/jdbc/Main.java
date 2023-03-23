package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerSevice;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerSevice manufacturerSevice = (ManufacturerSevice)
                injector.getInstance(ManufacturerSevice.class);
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        Driver createdDriver = driverService.create(new Driver("Oleksandr", "25565"));
        System.out.println("Created driver: " + driverService.get(createdDriver.getId()));
        System.out.println("All Drivers: " + System.lineSeparator());
        driverService.getAll().forEach(System.out::println);
    }
}
