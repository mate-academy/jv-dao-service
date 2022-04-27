package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        Driver firstDriver = new Driver("John_Sena", "12345");
        driverService.create(firstDriver);
        driverService.delete(firstDriver.getId());

        Driver secondDriver = new Driver("John_Wik", "32141");
        driverService.create(secondDriver);
        secondDriver.setLicenseNumber("12341");
        driverService.update(secondDriver);

        List<Driver> allDrivers = driverService.getAll();

        for (Driver allDriver : allDrivers) {
            System.out.println(allDriver);
        }
        //allDrivers.forEach(System.out::println);
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        manufacturerService.getAll().forEach(System.out::println);

    }
}
