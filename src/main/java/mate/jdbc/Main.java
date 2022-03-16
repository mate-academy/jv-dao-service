package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);

        Driver bob = new Driver();
        bob.setName("Bob");
        bob.setLicenceNumber("12345");
        bob = driverService.create(bob);

        Driver alice = new Driver();
        alice.setName("Alice");
        alice.setLicenceNumber("56789");
        alice = driverService.create(alice);

        Driver tom = new Driver();
        tom.setName("Tom");
        tom.setLicenceNumber("22222");
        tom = driverService.create(tom);

        System.out.println(driverService.get(bob.getId()));
        System.out.println(driverService.get(alice.getId()));
        System.out.println(driverService.get(tom.getId()));
        System.out.println();

        alice.setLicenceNumber("99999");
        driverService.update(alice);

        driverService.getAll().forEach(System.out::println);

        boolean delete = driverService.delete(bob.getId());
        if (delete) {
            System.out.println("Driver: " + bob.getName()
                    + " was deleted");
        }
    }
}
