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
        Driver driverBob = new Driver();
        driverBob.setName("Bob");
        driverBob.setLicenseNumber("RA1455");
        driverService.create(driverBob);

        Driver driverJohn = new Driver(1L, "John", "AK4687");
        driverService.update(driverJohn);

        System.out.println(driverService.get(1L));

        driverService.delete(2L);

        driverService.getAll().forEach(System.out::println);

        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);

        Manufacturer manufacturerSaab = new Manufacturer();
        manufacturerSaab.setName("saab");
        manufacturerSaab.setCountry("sweden");
        manufacturerService.create(manufacturerSaab);

        System.out.println(manufacturerService.get(21L));

        Manufacturer manufacturerCitroen = new Manufacturer();
        manufacturerCitroen.setId(16L);
        manufacturerCitroen.setName("citroen");
        manufacturerCitroen.setCountry("france");

        manufacturerService.update(manufacturerCitroen);

        manufacturerService.delete(18L);

        manufacturerService.getAll().forEach(System.out::println);
        // test your code here
    }
}
