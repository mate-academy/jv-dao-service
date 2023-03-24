package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");
    private static DriverService driverService =
            (DriverService) injector.getInstance(DriverService.class);

    public static void main(String[] args) {
        Driver driver1 = new Driver("Vitalii", "77777777");
        Driver driver2 = new Driver("Alisa", "234567844");
        Driver driver3 = new Driver("Mark", "987766552");
        System.out.println(driverService.create(driver1));
        System.out.println(driverService.create(driver2));
        System.out.println(driverService.create(driver3));
        System.out.println(driverService.getAll());
        Driver mark = driverService.get(3L);
        System.out.println(mark);
        mark.setLicenseNumber("11111111111");
        System.out.println(driverService.update(mark));
        System.out.println(driverService.delete(3L));
        System.out.println(driverService.getAll());

    }
}
