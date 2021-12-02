package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);

        driverService.getAll()
                .forEach(System.out::println);
        Driver driverFromDB = driverService.get(1L);
        Driver createdDriver = driverService.create(new Driver("Bob", "3123"));

        driverFromDB.setName("updatedName");
        driverFromDB.setLicenseNumber("updatedLicense");
        Driver updateDriver = driverService.update(driverFromDB);

        boolean deleteDriver = driverService.delete(1L);
    }
}
