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

        Manufacturer manufacturerA = Manufacturer.builder().name("A").country("AA").build();
        Manufacturer manufacturerB = Manufacturer.builder().name("B").country("BB").build();
        Manufacturer manufacturerC = Manufacturer.builder().name("C").country("CC").build();
        Manufacturer manufacturerD = Manufacturer.builder().name("D").country("DD").build();
        Manufacturer manufacturerE = Manufacturer.builder().name("E").country("EE").build();
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

        Driver driverA = Driver.builder().name("A").licenseNumber("AA").build();
        Driver driverB = Driver.builder().name("B").licenseNumber("BB").build();
        Driver driverC = Driver.builder().name("C").licenseNumber("CC").build();
        Driver driverD = Driver.builder().name("D").licenseNumber("DD").build();
        Driver driverE = Driver.builder().name("E").licenseNumber("EE").build();
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
