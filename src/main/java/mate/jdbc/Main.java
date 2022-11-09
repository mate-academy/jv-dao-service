package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver("FinalTestName", "FinalTestLicense");
        driverService.create(driver);
        System.out.println(driverService.get(driver.getId()));
        driver.setName("NowExactlyFinallyTestName");
        driverService.update(driver);
        driverService.delete(driver.getId());
        driverService.getAll().forEach(System.out::println);

        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer("Audi", "China");
        manufacturerService.create(manufacturer);
        System.out.println(manufacturerService.get(manufacturer.getId()));
        manufacturer.setCountry("Italy");
        manufacturerService.update(manufacturer);
        manufacturerService.delete(manufacturer.getId());
        manufacturerService.getAll().forEach(System.out::println);
    }
}
