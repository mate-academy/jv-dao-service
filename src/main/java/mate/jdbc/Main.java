package mate.jdbc;

import java.util.ArrayList;
import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        List<Driver> drivers = new ArrayList<>();
        drivers.add(new Driver("Kim", "TYGW34GH12Q"));
        drivers.add(new Driver("Choli", "HK3H662SDF2"));
        drivers.add(new Driver("Chonsuk", "QEF124GS8H7"));
        for (Driver driver: drivers) {
            driverService.create(driver);
        }
        driverService.getAll().forEach(System.out::println);
        Driver driver = driverService.get(drivers.stream().findFirst().get().getId());
        System.out.println(driver);
        driver.setName("Joseph");
        driver.setLicenseNumber("S1S9S4R5111");
        driverService.update(driver);
        driverService.getAll().forEach(System.out::println);
        driverService.delete(driver.getId());
        driverService.getAll().forEach(System.out::println);
        //<------------------------------------------------------------------------>
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        List<Manufacturer> manufacturers = new ArrayList<>();
        manufacturers.add(new Manufacturer("Bob", "France"));
        manufacturers.add(new Manufacturer("Bobby", "British"));
        manufacturers.add(new Manufacturer("Bober", "Italy"));
        for (Manufacturer manufacturer: manufacturers) {
            manufacturerService.create(manufacturer);
        }
        manufacturerService.getAll().forEach(System.out::println);
        Manufacturer manufacturer = manufacturerService
                .get(manufacturers.stream().findFirst().get().getId());
        System.out.println(manufacturer);
        manufacturer.setName("Adolf");
        manufacturer.setCountry("Germany");
        manufacturerService.update(manufacturer);
        manufacturerService.getAll().forEach(System.out::println);
        manufacturerService.delete(manufacturer.getId());
        manufacturerService.getAll().forEach(System.out::println);
    }
}
