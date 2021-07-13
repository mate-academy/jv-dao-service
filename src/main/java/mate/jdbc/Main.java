package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final ManufacturerService manufacturerService = (ManufacturerService) injector
            .getInstance(ManufacturerService.class);
    private static final DriverService driverService = (DriverService) injector
            .getInstance(DriverService.class);

    public static void main(String[] args) {
        Manufacturer manufacturer1 = new Manufacturer("ZAZ", "Ukraine");
        manufacturer1 = manufacturerService.create(manufacturer1);
        Manufacturer manufacturer2 = new Manufacturer("LADA", "Russia");
        manufacturer2 = manufacturerService.create(manufacturer2);
        manufacturer2.setName("Kyiv-Lada");
        manufacturerService.update(manufacturer2);
        manufacturerService.getAll().forEach(System.out::println);
        Driver driver1 = new Driver("Piter", "SDL123123");
        driver1 = driverService.create(driver1);
        driver1.setLicenseNumber("RTY1238");
        driverService.delete(driver1.getId());
        Driver driver2 = new Driver("Dimonchik", "SDL123123");
        driver2 = driverService.create(driver2);
        driverService.getAll().forEach(System.out::println);
    }
}
