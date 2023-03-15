package mate.jdbc;

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
        System.out.println(service.get(newManufacturer.getId()));
        System.out.println("*************** get&update manufacturers *******************");
        testManufacturer = service.get(newManufacturer.getId());
        testManufacturer.setCountry("Ukraine");
        testManufacturer = service.update(testManufacturer);
        System.out.println(service.get(testManufacturer.getId()));
        System.out.println("*************** delete manufacturers *******************");
        service.delete(testManufacturer.getId());
        service.getAll().forEach(System.out::println);
    }

    public static void testDriverService(DriverService service, Driver testDriver) {
        System.out.println("*************** list all drivers *******************");
        service.getAll().forEach(System.out::println);
        System.out.println("*************** create new driver *******************");
        Driver newDriver = service.create(testDriver);
        System.out.println(service.get(newDriver.getId()));
        System.out.println("*************** get&update driver *******************");
        testDriver = service.get(newDriver.getId());
        testDriver.setLicenseNumber("new license number");
        testDriver = service.update(testDriver);
        System.out.println(service.get(testDriver.getId()));
        System.out.println("*************** delete driver *******************");
        service.delete(testDriver.getId());
        service.getAll().forEach(System.out::println);
    }

}
