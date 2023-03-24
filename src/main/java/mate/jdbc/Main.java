package mate.jdbc;

import java.util.List;
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
        Manufacturer audi = new Manufacturer();
        audi.setName("Audi");
        audi.setCountry("Germany");
        Manufacturer ferrari = new Manufacturer();
        ferrari.setName("Fiat");
        ferrari.setCountry("Italia");
        System.out.println(manufacturerService.create(audi));
        System.out.println(manufacturerService.create(ferrari));

        ferrari.setName("Ferrari");
        System.out.println(manufacturerService.update(ferrari));
        manufacturerService.delete(ferrari.getId());
        System.out.println(manufacturerService.getAll());

        List<Driver> allDrivers = driverService.getAll();
        allDrivers.forEach(System.out::println);
        Driver audiDriver = new Driver();
        audiDriver.setName("Bastian");
        audiDriver.setLicenseNumber("12121212");
        driverService.create(audiDriver);

        Driver ferrariDriver = new Driver();
        ferrariDriver.setName("Antonio");
        ferrariDriver.setLicenseNumber("12121290");
        driverService.create(ferrariDriver);

        List<Driver> drivers = driverService.getAll();
        drivers.forEach(System.out::println);

        System.out.println(driverService.get(audiDriver.getId()));

        audiDriver.setName("Johan");
        audiDriver.setLicenseNumber("99999999");
        System.out.println(driverService.update(audiDriver));

        driverService.delete(audiDriver.getId());
    }
}
