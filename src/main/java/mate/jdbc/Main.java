package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Manufacturer ford = new Manufacturer();
        ford.setName("Ford");
        ford.setCountry("USA");
        Manufacturer mustang = new Manufacturer();
        mustang.setName("Mustang");
        mustang.setCountry("USA");
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        ford = manufacturerService.create(ford);
        mustang = manufacturerService.create(mustang);
        System.out.println(manufacturerService.get(ford.getId()));
        System.out.println(manufacturerService.get(mustang.getId()));
        System.out.println(manufacturerService.getAll());
        mustang.setCountry("Japan");
        System.out.println(manufacturerService.update(mustang));
        System.out.println(manufacturerService.delete(ford.getId()));

        Driver john = new Driver();
        john.setName("John");
        john.setLicenseNumber("111111");
        Driver stan = new Driver();
        stan.setName("Stan");
        stan.setLicenseNumber("222222");
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        john = driverService.create(john);
        stan = driverService.create(stan);
        System.out.println(driverService.get(john.getId()));
        System.out.println(driverService.get(stan.getId()));
        System.out.println(driverService.getAll());
        stan.setLicenseNumber("123123");
        System.out.println(driverService.update(stan));
        System.out.println(driverService.delete(john.getId()));

        System.out.println(manufacturerService.get(ford.getId()));
        System.out.println(driverService.get(john.getId()));
    }
}
