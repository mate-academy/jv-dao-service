package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver();
        driver.setName("Bob");
        driver.setLicenseNumber("RA1455");
        driverService.create(driver);

        Driver driver1 = new Driver(1L, "John", "AK4687");
        driverService.update(driver1);

        System.out.println(driverService.get(1L));

        driverService.delete(2L);

        driverService.getAll().forEach(System.out::println);

        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("saab");
        manufacturer.setCountry("sweden");
        manufacturerService.create(manufacturer);

        System.out.println(manufacturerService.get(21L));

        Manufacturer manufacturer1 = new Manufacturer();
        manufacturer1.setId(16L);
        manufacturer1.setName("citroen");
        manufacturer1.setCountry("france");

        manufacturerService.update(manufacturer1);

        manufacturerService.delete(18L);

        manufacturerService.getAll().forEach(System.out::println);
        // test your code here
    }
}
