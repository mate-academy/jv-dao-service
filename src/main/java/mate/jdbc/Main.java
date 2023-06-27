package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.setName("Anatoliy");
        driver.setLicenseNumber("BX9024AA");
        Driver driver2 = new Driver();
        driver2.setName("Andrii");
        driver2.setLicenseNumber("TH6775BI");
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        driverService.create(driver);
        driverService.create(driver2);
        driverService.getAll().forEach(System.out::println);
        System.out.println("--------------------------");
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("honda");
        manufacturer.setCountry("japan");
        Manufacturer manufacturer2 = new Manufacturer();
        manufacturer2.setName("volvo");
        manufacturer2.setCountry("sweden");
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        manufacturerService.create(manufacturer);
        manufacturerService.create(manufacturer2);
        manufacturerService.getAll().forEach(System.out::println);
    }
}
