package mate.jdbc;

import mate.jdbc.dao.ManufacturerService;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;

public class Main {
    public static void main(String[] args) {
        final Injector injector = Injector.getInstance("mate.jdbc");
        final DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        final ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);

        Manufacturer manufacturerA = new Manufacturer(1L, "A", "AA");
        Manufacturer manufacturerB = new Manufacturer(2L, "B", "BB");
        Manufacturer manufacturerC = new Manufacturer(3L, "C", "CC");
        Manufacturer manufacturerD = new Manufacturer(4L, "D", "DD");
        Manufacturer manufacturerE = new Manufacturer(5L, "E", "EE");
        System.out.println(manufacturerService.create(manufacturerA));
        System.out.println(manufacturerService.create(manufacturerB));
        System.out.println(manufacturerService.create(manufacturerC));
        System.out.println(manufacturerService.create(manufacturerD));
        System.out.println(manufacturerService.create(manufacturerE));
        System.out.println(manufacturerService.get(1L));
        manufacturerService.getAll().forEach(System.out::println);
        manufacturerE.setName("EEE");
        manufacturerE.setCountry("EEEEE");
        System.out.println(manufacturerService.update(manufacturerE));
        manufacturerService.getAll().forEach(System.out::println);
        manufacturerService.delete(manufacturerE.getId());
        manufacturerService.getAll().forEach(System.out::println);

        Driver driverA = new Driver(1L, "A", "AA");
        Driver driverB = new Driver(2L, "B", "BB");
        Driver driverC = new Driver(3L, "C", "CC");
        Driver driverD = new Driver(4L, "D", "DD");
        Driver driverE = new Driver(5L, "E", "EE");

        System.out.println(driverService.create(driverA));
        System.out.println(driverService.create(driverB));
        System.out.println(driverService.create(driverC));
        System.out.println(driverService.create(driverD));
        System.out.println(driverService.create(driverE));
        System.out.println(driverService.get(1L));
        driverService.getAll().forEach(System.out::println);
        driverE.setName("EEE");
        driverE.setLicenseNumber("EEEEE");
        System.out.println(driverService.update(driverE));
        driverService.getAll().forEach(System.out::println);
        driverService.delete(driverE.getId());
        driverService.getAll().forEach(System.out::println);
    }
}
