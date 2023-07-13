package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        System.out.println("*** Get All Manufacturers ***");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("*** Get Manufacturer #10 ***");
        System.out.println(manufacturerService.get(10L));

        Driver driverPedro = new Driver("Pedro", "100");
        Driver driverBob = new Driver("Bob", "101");
        Driver driverBogdan = new Driver("Bogdan", "102");
        Driver driverBruceWillis = new Driver("Bruce Willis", "103");
        Driver driverMichaelRourke = new Driver("Michael Rourke", "104");
        Driver driverGoldenDriver = new Driver("Golden Driver", "105");
        List<Driver> driversList = List.of(driverPedro, driverBob, driverBogdan,
                driverBruceWillis, driverMichaelRourke, driverGoldenDriver);

        DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);

        if (driverService.getAll().isEmpty()) {
            for (var driver : driversList) {
                driverService.create(driver);
            }
        }
        System.out.println("*** Get All Drivers***");
        driverService.getAll().forEach(System.out::println);

        System.out.println("*** Update Driver #1 ***");
        Driver driverForUpdate = new Driver(1L, "Updated Driver", "111");
        System.out.println(driverService.update(driverForUpdate));

        System.out.println("*** Get Driver #1 ***");
        System.out.println(driverService.get(1L));

        System.out.println("*** Delete Driver #6 ***");
        System.out.println(driverService.delete(6L));

        System.out.println("*** Get All Drivers***");
        driverService.getAll().forEach(System.out::println);
    }
}
