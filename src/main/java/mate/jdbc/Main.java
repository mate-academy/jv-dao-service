package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);

        Driver stepan = new Driver("Stepan", "d11");
        Driver ivan = new Driver("Ivan", "d12");
        Driver peter = new Driver("Peter", "d10");
        driverService.create(stepan);
        driverService.create(ivan);
        driverService.create(peter);

        Driver ivanLicense = new Driver(1L, "Ivan", "d1");
        driverService.update(ivanLicense);

        System.out.println(driverService.get(1L));
        System.out.println(driverService.delete(2L));

        driverService.getAll().forEach(System.out::println);
    }
}
