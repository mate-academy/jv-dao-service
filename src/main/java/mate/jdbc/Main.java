package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Manufacturer manufacturerFord = new Manufacturer();
        manufacturerFord.setName("Ford");
        manufacturerFord.setCountry("USA");
        Manufacturer manufacturerHonda = new Manufacturer();
        manufacturerHonda.setName("Honda");
        manufacturerHonda.setCountry("Japan");
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        manufacturerService.create(manufacturerFord);
        manufacturerService.create(manufacturerHonda);
        manufacturerHonda.setCountry("USA");
        manufacturerService.update(manufacturerHonda);
        manufacturerService.delete(manufacturerFord.getId());
        System.out.println(manufacturerService.get(manufacturerHonda.getId()));
        manufacturerService.getAll().forEach(System.out::println);
        Driver driverAlex = new Driver();
        driverAlex.setName("Alex");
        driverAlex.setLicenseNumber("123412WR");
        Driver driverBob = new Driver();
        driverBob.setName("Bob");
        driverBob.setLicenseNumber("415778TG");
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        driverService.create(driverAlex);
        driverService.create(driverBob);
        driverBob.setLicenseNumber("656178YU");
        driverService.update(driverBob);
        driverService.delete(driverAlex.getId());
        System.out.println(driverService.get(driverBob.getId()));
        driverService.getAll().forEach(System.out::println);
    }
}
