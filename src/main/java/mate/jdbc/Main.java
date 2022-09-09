package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Manufacturer audi = new Manufacturer();
        audi.setName("Audi");
        audi.setCountry("Germany");
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        System.out.println("Create:");
        System.out.println(manufacturerService.create(audi));
        Manufacturer mercedes = new Manufacturer();
        mercedes.setName("Mercedes");
        mercedes.setCountry("Germany");
        System.out.println(manufacturerService.create(mercedes));
        System.out.println("------------------------------");
        System.out.println("Get:");
        System.out.println(manufacturerService.get(audi.getId()));
        System.out.println("------------------------------");
        System.out.println("Update:");
        audi.setName("BMW");
        System.out.println(manufacturerService.update(audi));
        System.out.println("------------------------------");
        System.out.println("GetAll:");
        System.out.println(manufacturerService.getAll());
        System.out.println("------------------------------");
        System.out.println("Delete:");
        System.out.println(manufacturerService.delete(1L));

        Driver bob = new Driver();
        bob.setName("Bob");
        bob.setLicenseNumber("123456");
        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);
        System.out.println("Create:");
        System.out.println(driverService.create(bob));
        Driver alice = new Driver();
        alice.setName("Alice");
        alice.setLicenseNumber("253689");
        System.out.println(driverService.create(alice));
        System.out.println("------------------------------");
        System.out.println("Get:");
        System.out.println(driverService.get(bob.getId()));
        System.out.println("------------------------------");
        System.out.println("Update:");
        audi.setName("Bruce");
        System.out.println(driverService.update(bob));
        System.out.println("------------------------------");
        System.out.println("GetAll:");
        System.out.println(driverService.getAll());
        System.out.println("------------------------------");
        System.out.println("Delete:");
        System.out.println(driverService.delete(1L));
    }
}
