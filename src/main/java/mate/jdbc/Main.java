package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer renoManufacturer = new Manufacturer();
        renoManufacturer.setName("Reno");
        renoManufacturer.setCountry("France");
        System.out.println(manufacturerService.create(renoManufacturer));
        System.out.println(manufacturerService.get(renoManufacturer.getId()));
        Manufacturer kiaManufacturer = new Manufacturer();
        kiaManufacturer.setId(renoManufacturer.getId());
        kiaManufacturer.setName("Kia");
        kiaManufacturer.setCountry("South Korea");
        System.out.println(manufacturerService.update(kiaManufacturer));
        System.out.println(manufacturerService.delete(renoManufacturer.getId()));
        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);
        Driver driverBob = new Driver();
        driverBob.setName("Bob");
        driverBob.setLicenseNumber("1235");
        System.out.println(driverService.create(driverBob));
        System.out.println(driverService.get(driverBob.getId()));
        Driver driverAlex = new Driver();
        driverAlex.setId(driverBob.getId());
        driverAlex.setName("Alex");
        driverAlex.setLicenseNumber("1236");
        System.out.println(driverService.update(driverAlex));
        System.out.println(driverService.delete(driverBob.getId()));
        driverService.getAll().forEach(System.out::println);
    }
}
