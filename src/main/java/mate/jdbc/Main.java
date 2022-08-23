package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver sem = new Driver();
        sem.setName("Sem");
        sem.setLicenseNumber("BYR32432423");
        Driver bob = new Driver();
        bob.setName("Bob");
        bob.setLicenseNumber("VUR32413413");
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        driverService.create(bob);
        driverService.create(sem);
        driverService.getAll().forEach(System.out::println);
        bob.setLicenseNumber("XXX213123213");
        driverService.update(bob);
        driverService.getAll().forEach(System.out::println);
        driverService.delete(bob.getId());
        driverService.getAll().forEach(System.out::println);

        Manufacturer opel = new Manufacturer();
        opel.setName("Opel");
        opel.setCountry("Germane");
        Manufacturer jeep = new Manufacturer();
        jeep.setName("Jeep");
        jeep.setCountry("USA");
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        manufacturerService.create(opel);
        manufacturerService.create(jeep);
        manufacturerService.getAll().forEach(System.out::println);
        opel.setCountry("France");
        manufacturerService.update(opel);
        manufacturerService.getAll().forEach(System.out::println);
        manufacturerService.delete(opel.getId());
        manufacturerService.getAll().forEach(System.out::println);
    }
}
