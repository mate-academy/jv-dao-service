package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        System.out.println("Get all drivers:");
        driverService.getAll().forEach(System.out::println);
        System.out.println();

        System.out.println("Create driver Johny and Cathrine:");
        Driver johny = new Driver("Johny", "GHJ78");
        Driver cathrine = new Driver("Cathrine", "A67Ad");
        Driver driverJohny = driverService.create(johny);
        Driver driverCathrine = driverService.create(cathrine);

        System.out.println("Update driver Johny - change name to Philip");
        driverJohny.setName("Philip");
        driverService.update(driverJohny);
        System.out.println(driverService.get(1L));

        System.out.println("Delete driver with id 2");
        driverService.delete(2L);
        System.out.println();
        driverService.getAll().forEach(System.out::println);
    }
}
