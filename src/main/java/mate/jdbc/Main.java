package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Toyota");
        manufacturer.setCountry("Japan");
        Manufacturer toyotaManufacturer = manufacturerService.create(manufacturer);
        Manufacturer toyotaManufacturerFromDB =
                manufacturerService.get(toyotaManufacturer.getId());
        toyotaManufacturerFromDB.setName("Honda");
        Manufacturer hondaManufacturer = manufacturerService.update(toyotaManufacturerFromDB);
        manufacturerService.delete(hondaManufacturer.getId());
        System.out.println(manufacturerService.getAll());

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        Driver driver = new Driver();
        driver.setName("Maksym");
        driver.setLicenseNumber("12345");
        Driver driverMaksym = driverService.create(driver);
        Driver driverMaksymFromDB = driverService.get(driverMaksym.getId());
        driverMaksymFromDB.setLicenseNumber("6789");
        Driver updatedDriverMaksym = driverService.update(driverMaksymFromDB);
        driverService.delete(updatedDriverMaksym.getId());
        System.out.println(driverService.getAll());
    }
}
