package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver driverJoe = new Driver();
        driverJoe.setName("Joe");
        driverJoe.setLicenseNumber("12389");
        Driver driverJack = new Driver();
        driverJack.setName("Jack");
        driverJack.setLicenseNumber("qw2389");
        Driver driverBob = new Driver();
        driverBob.setName("Bob");
        driverBob.setLicenseNumber("qfpw2389");
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        driverService.create(driverBob);
        driverService.create(driverJoe);
        driverService.create(driverJack);
        System.out.println(driverService.get(1L).toString());
        driverJoe.setName("July");
        driverJoe.setLicenseNumber("123587189");
        driverService.update(driverJoe);
        driverService.delete(2L);
        driverService.getAll().forEach(d -> System.out.println(d.toString()));

        Manufacturer bmw = new Manufacturer();
        bmw.setName("BMW");
        bmw.setCountry("Germany");
        Manufacturer mazda = new Manufacturer();
        mazda.setName("Mazda");
        mazda.setCountry("Japan");
        Manufacturer ford = new Manufacturer();
        ford.setName("Ford");
        ford.setCountry("USA");
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        manufacturerService.create(bmw);
        manufacturerService.create(mazda);
        manufacturerService.create(ford);
        System.out.println(manufacturerService.get(4L).toString());
        mazda.setName("Hyundai");
        mazda.setCountry("Korea");
        manufacturerService.update(mazda);
        manufacturerService.delete(1L);
        manufacturerService.getAll().forEach(m -> System.out.println(m.toString()));
    }
}
