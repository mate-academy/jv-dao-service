package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.setName("Alice");
        driver.setLicenseNumber("5678");

        Driver updatedDriver = new Driver();
        updatedDriver.setId(2L);
        updatedDriver.setName("Bob");
        updatedDriver.setLicenseNumber("575757");
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);

        Driver createdDriver = driverService.create(driver);
        System.out.println(createdDriver);
        System.out.println(driverService.get(2L));
        System.out.println(driverService.update(updatedDriver));
        System.out.println(driverService.delete(3L));
        driverService.getAll()
                .forEach(System.out::println);
    }
}
