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
        Driver driver = new Driver();

        driver.setName("Vasyl");
        driver.setLicenseNumber("DF12432");
        driverService.create(driver);

        driver.setName("Sergiy");
        driver.setLicenseNumber("ER64232");
        driverService.create(driver);

        driver.setName("Alina");
        driver.setName("SD078932");
        driverService.create(driver);

        System.out.println(driverService.get(1L));
        System.out.println(driverService.get(3L));

        driver.setId(2L);
        driver.setName("Daryna");
        driver.setLicenseNumber("XZ642387");
        driverService.update(driver);

        driverService.delete(1L);

        System.out.println(driverService.getAll());

        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);

        Manufacturer manufacturer = new Manufacturer();

        manufacturer.setName("BMW");
        manufacturer.setCountry("Germany");
        manufacturerService.create(manufacturer);

        manufacturer.setName("Ford");
        manufacturer.setCountry("USA");
        manufacturerService.create(manufacturer);

        manufacturer.setName("Volkswagen");
        manufacturer.setCountry("Germany");
        manufacturerService.create(manufacturer);

        System.out.println(manufacturerService.get(1L));
        System.out.println(manufacturerService.get(2L));

        manufacturer.setId(1L);
        manufacturer.setName("Citroen");
        manufacturer.setCountry("France");
        manufacturerService.update(manufacturer);

        manufacturerService.delete(3L);

        System.out.println(manufacturerService.getAll());
    }
}
