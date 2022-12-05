package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector myInject = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        // test your code here
        Driver.Builder driverBuilder = new Driver.Builder();
        DriverService driverService =
                (DriverService) myInject.getInstance(DriverService.class);
        ManufacturerService manufacturerService =
                (ManufacturerService) myInject.getInstance(ManufacturerService.class);

        driverService.create(driverBuilder.setName("Vasil").setLicenseNumber("2317245").build());
        driverService.create(driverBuilder.setName("Kolya").setLicenseNumber("6243121").build());

        List<Driver> drivers = driverService.getAll();
        drivers.forEach(System.out::println);
        driverService.delete(2L);
        System.out.println(driverService.get(1L));
        System.out.println(driverService.get(2L));
    }
}
