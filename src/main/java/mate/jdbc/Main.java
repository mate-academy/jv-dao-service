package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        manufacturerService.getAll().forEach(System.out::println);

        Driver alice = new Driver();
        alice.setName("Alise");
        alice.setLicenseNumber("22222");

        Driver john = new Driver();
        john.setName("John");
        john.setLicenseNumber("33333");

        Driver jack = new Driver();
        jack.setName("Jack");
        jack.setLicenseNumber("44444");

        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);

        System.out.println("_______create driver _________");
        System.out.println("Was created: " + driverService.create(alice));
        System.out.println("Was created: " + driverService.create(john));
        System.out.println("Was created: " + driverService.create(jack));

        System.out.println("_______get driver by id_________");
        System.out.println(driverService.get(alice.getId()));
        System.out.println(driverService.get(john.getId()));
        System.out.println(driverService.get(jack.getId()));

        System.out.println("_______update driver ___________");
        alice.setName("AlIsE");
        alice.setLicenseNumber("77");
        Driver updateAlice = driverService.update(alice);
        System.out.println(updateAlice);

        System.out.println("_______delete driver ___________");
        System.out.println("Was the driver " + jack.getName() + " removed? - "
                + driverService.delete(jack.getId()));

        System.out.println("_______get all drivers ___________");
        driverService.getAll().forEach(System.out::println);
    }
}
