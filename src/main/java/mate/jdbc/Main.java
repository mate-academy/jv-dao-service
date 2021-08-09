package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    public static void main(String[] args) {
        Injector injector = Injector.getInstance("mate.jdbc");
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        Driver john = new Driver("John Linkman", "UT128-645");
        Driver samantha = new Driver("Samantha Johns", "IM651-257");
        Driver lukas = new Driver("Lukas Greenberg", "KT822-040");
        Driver alfred = new Driver("Alfred Lemme", "MY-214-003");

        driverService.create(john);
        driverService.create(samantha);
        driverService.create(lukas);
        driverService.create(alfred);

        System.out.println("All drivers list is:");
        driverService.getAll().forEach(System.out::println);

        System.out.println("\nThe driver with id = 3 is: " + driverService.get(3L));

        samantha.setName("Samantha Rock");
        driverService.update(samantha);
        System.out.println("\nAfter name changing Samantha Johns becomes: "
                + driverService.get(2L));

        driverService.delete(4L);
        System.out.println("\nAfter deleting Alfred all drivers list is:");
        driverService.getAll().forEach(System.out::println);
    }
}
