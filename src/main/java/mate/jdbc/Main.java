package mate.jdbc;

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
        Manufacturer opel = new Manufacturer();
        opel.setName("opel");
        opel.setCountry("german");
        Manufacturer seat = new Manufacturer();
        seat.setName("seat");
        seat.setCountry("Spain");
        manufacturerService.create(opel);
        manufacturerService.create(seat);
        manufacturerService.getAll().forEach(System.out::println);

        Driver driver1 = new Driver();
        driver1.setName("driver_1");
        driver1.setLicenseNumber("1234f56g7");
        Driver driver2 = new Driver();
        driver2.setName("driver_2");
        driver2.setLicenseNumber("00000000");
        driverService.create(driver1);
        driverService.create(driver2);
        driverService.getAll().forEach(System.out::println);

    }
}
