package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector
            = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        // test your code here
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);

        Manufacturer tesla = new Manufacturer();
        tesla.setName("Tesla");
        tesla.setCountry("USA");
        System.out.println(manufacturerService.create(tesla));

        List<Manufacturer> manufacturers = manufacturerService.getAll();
        manufacturers.forEach(System.out::println);

        System.out.println(manufacturerService.get(tesla.getId()));

        tesla.setName("Volvo");
        System.out.println(manufacturerService.update(tesla));

        manufacturerService.delete(tesla.getId());

        DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);

        Driver teslaDriver = new Driver();
        teslaDriver.setName("Bill");
        teslaDriver.setLicenseNumber("1234567");
        driverService.create(teslaDriver);

        List<Driver> drivers = driverService.getAll();
        drivers.forEach(System.out::println);

        System.out.println(driverService.get(teslaDriver.getId()));

        teslaDriver.setName("John");
        System.out.println(driverService.update(teslaDriver));

        driverService.delete(teslaDriver.getId());
    }
}
