package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        //Driver driver = new Driver();
        //driver.setName("Ann");
        //driver.setLicenseNumber("5555");
        //driver.setId(5L);
        //driverService.create(driver);
        //System.out.println(driverService.getAll());
        //System.out.println(driverService.get(5L));
        //driverService.delete(5L);
        //driverService.update(driver);
        //System.out.println(driverService.getAll());
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Renault");
        manufacturer.setCountry("France");
        manufacturer.setId(13L);
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        //manufacturerService.create(manufacturer);
        //manufacturerService.delete(5L);
        //manufacturerService.update(manufacturer);
        System.out.println(manufacturerService.get(16L));
        System.out.println(manufacturerService.getAll());

    }
}
