package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver();
        driver.setName("Alex");
        driver.setLicenseNumber("123");
        //driverService.create(driver);
        //System.out.println(driverService.get(1L));
        //driverService.getAll().forEach(System.out::println);
        /*driver.setId(1L);
        driver.setLicenseNumber("T123");
        driverService.update(driver);*/
        driverService.delete(2L);
    }
}
