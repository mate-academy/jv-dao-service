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
        Driver driver = new Driver();
        driver.setName("Bob");
        driver.setLicenseNumber("MateCode12345");
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("CarbonCar");
        manufacturer.setCountry("Ukraine");

        DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);
        Driver driverFromCreateMethod = driverService.create(driver);
        System.out.println(driverFromCreateMethod);

        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturerFromCreateMethod = manufacturerService.create(manufacturer);
        System.out.println(manufacturerFromCreateMethod);

        Driver driverFromGetMethod = driverService.get(driverFromCreateMethod.getId());
        System.out.println(driverFromGetMethod);

        Manufacturer manufacturerFromGetMethod = manufacturerService
                .get(manufacturerFromCreateMethod.getId());
        System.out.println(manufacturerFromGetMethod);

        List<Driver> driversFromGetAllMethod = driverService.getAll();
        driversFromGetAllMethod.forEach(System.out::println);

        List<Manufacturer> manufacturersFromGetAllMethod = manufacturerService.getAll();
        manufacturersFromGetAllMethod.forEach(System.out::println);
    }
}
