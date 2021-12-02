package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);

        Manufacturer lada = new Manufacturer("Lada", "Ukraine");
        Manufacturer porsche = new Manufacturer("Porsche", "USA");
        manufacturerService.create(porsche);
        manufacturerService.create(lada);
        manufacturerService.get(lada.getId());
        manufacturerService.getAll();
        lada.setCountry("Russia");
        manufacturerService.update(lada);
        manufacturerService.delete(porsche.getId());
        manufacturerService.getAll();

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        Driver driver1 = new Driver("driver1", "789");
        Driver driver2 = new Driver("driver2", "124");
        driverService.create(driver2);
        driverService.create(driver1);
        driverService.get(driver1.getId());
        driverService.getAll();
        driver1.setLicenseNumber("098");
        driverService.update(driver1);
        driverService.delete(driver2.getId());
    }
}
