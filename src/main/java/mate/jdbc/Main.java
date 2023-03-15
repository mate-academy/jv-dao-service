package mate.jdbc;

import java.util.Optional;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    public static void main(String[] args) {
        Injector injector = Injector.getInstance("mate.jdbc");
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        testManufactureService(manufacturerService,
                new Manufacturer("testManufacturer", "testCountry"));
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        testDriverService(driverService,
                new Driver("test driver", "test licence number"));
    }

    public static void testManufactureService(ManufacturerService service,
                                              Manufacturer testManufacturer) {
        System.out.println("*************** list all manufacturers *******************");
        service.getAll().forEach(System.out::println);
        System.out.println("*************** create new manufacturers *******************");
        Manufacturer newManufacturer = service.create(testManufacturer);
        service.get(newManufacturer.getId()).ifPresent(System.out::println);
        System.out.println("*************** get&update manufacturers *******************");
        Optional<Manufacturer> optionalManufacturer = service.get(newManufacturer.getId());
        if (optionalManufacturer.isPresent()) {
            testManufacturer = optionalManufacturer.get();
            testManufacturer.setCountry("Ukraine");
            testManufacturer = service.update(testManufacturer);
            service.get(testManufacturer.getId()).ifPresent(System.out::println);
        }
        System.out.println("*************** delete manufacturers *******************");
        service.delete(testManufacturer.getId());
        service.getAll().forEach(System.out::println);
    }

    public static void testDriverService(DriverService service, Driver testDriver) {
        System.out.println("*************** list all drivers *******************");
        service.getAll().forEach(System.out::println);
        System.out.println("*************** create new driver *******************");
        Driver newDriver = service.create(testDriver);
        service.get(newDriver.getId()).ifPresent(System.out::println);
        System.out.println("*************** get&update driver *******************");
        Optional<Driver> optionalDriver = service.get(newDriver.getId());
        if (optionalDriver.isPresent()) {
            testDriver = optionalDriver.get();
            testDriver.setLicenseNumber("new license number");
            testDriver = service.update(testDriver);
            service.get(testDriver.getId()).ifPresent(System.out::println);
        }
        System.out.println("*************** delete driver *******************");
        service.delete(testDriver.getId());
        service.getAll().forEach(System.out::println);
    }

}
