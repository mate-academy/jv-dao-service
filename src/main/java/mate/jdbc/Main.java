package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.services.DriverService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        Driver driverAlex = new Driver(null, "Alex", "777");
        Long driverAlexId = driverService.create(driverAlex).getId();
        System.out.println("\n***\ndriver alex is created");
        System.out.println(driverService.get(driverAlexId));
        driverService.delete(driverAlexId);
        System.out.println("\n***\ndriver alex is deleted");

        Driver driverBob = new Driver(null, "Bob", "888");
        Long driverBobId = driverService.create(driverBob).getId();
        System.out.println("\n***\ndriver bob is created");
        System.out.println(driverService.get(driverBobId));
        driverBob.setId(driverBobId);
        driverBob.setLicenseNumber("666");
        driverService.update(driverBob);
        System.out.println("\n***\ndriver bob is updated");
        System.out.println(driverService.get(driverBobId));

        Driver driverAlice = new Driver(null, "Alice", "999");
        driverService.create(driverAlice);
        System.out.println("\n***\ndriver alice is created");

        System.out.println("\n***\nall drivers\n***");
        driverService.getAll().forEach(System.out::println);
    }
}
