package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Mercedes");
        manufacturer.setCountry("Germany");
        System.out.println(manufacturerService.create(manufacturer));
        System.out.println(manufacturerService.get(20L));
        System.out.println(manufacturerService.getAll());
        manufacturer.setCountry("Germany_Stuttgart");
        System.out.println(manufacturerService.update(manufacturer));
        System.out.println(manufacturerService.delete(1L));
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver();
        driver.setName("Yuliya");
        driver.setLicenseNumber("Sen19");
        System.out.println(driverService.create(driver));
        System.out.println(driverService.get(1L));
        System.out.println(driverService.getAll());
        driver.setName("Yuliya_Senchenko");
        System.out.println(driverService.update(driver));
        System.out.println(driverService.delete(2L));
    }
}
