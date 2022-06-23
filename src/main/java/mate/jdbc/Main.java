package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver driverAlice = new Driver();
        driverAlice.setLicenseNumber("12345");
        driverAlice.setName("Alice");

        Driver driverBob = new Driver();
        driverBob.setLicenseNumber("67890");
        driverBob.setName("Bob");

        DriverService driverService
                = (DriverService)injector.getInstance(DriverService.class);

        System.out.println("Creating of new drivers: "
                + driverService.create(driverAlice)
                + driverService.create(driverBob)
                + System.lineSeparator());

        System.out.println("Get by id: "
                + driverService.get(1L)
                + System.lineSeparator());

        System.out.println("Get all: ");
        driverService.getAll()
                .forEach(System.out::println);

        System.out.println(System.lineSeparator());
        System.out.println("Update driver Alice: ");
        driverAlice.setName("Nick");
        driverAlice.setLicenseNumber("54321");
        System.out.println(driverService.update(driverAlice));

        System.out.println(System.lineSeparator());
        System.out.println("After delete driver Alice:");
        if (driverService.delete(1L)) {
            driverService.getAll()
                    .forEach(System.out::println);
        }
    }
}
