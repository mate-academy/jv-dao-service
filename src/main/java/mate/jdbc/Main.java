package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        driverService.getAll().forEach(System.out::println);
        //create drivers
        System.out.println("Create new drivers...");
        Driver oleg = new Driver("Oleg", "1234567");
        driverService.create(oleg);
        Driver igor = new Driver("Igor", "2345678");
        driverService.create(igor);
        Driver yaroslav = new Driver("Yaroslav", "3456789");
        driverService.create(yaroslav);
        //System.lineSeparator();
        //show all drivers
        System.out.println("Show all created drivers:");
        System.out.println(driverService.get(1L));
        System.out.println(driverService.get(2L));
        System.out.println(driverService.get(3L));
        //System.lineSeparator();
        //update driver Igor, id = 2
        System.out.println("Update driver Igor...");
        Driver olga = new Driver(2L,"Olga", "4567890");
        driverService.update(olga);
        //System.lineSeparator();
        //delete driver
        System.out.println("Delete driver Yaroslav...");
        driverService.delete(3L);
        //System.lineSeparator();
        //show all drivers again
        System.out.println("Show all drivers again:");
        driverService.getAll().forEach(System.out::println);
    }
}
