package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver();
        driver.setName("Michel Rat");
        driver.setLicenseNumber("8-800-555-355");
        driverService.create(driver);

        driver.setLicenseNumber("345-66-5-345");
        driver.setName("Igor Terech");
        driverService.create(driver);

        driver.setLicenseNumber("65-566-555-5-315");
        driver.setName("Taras Boch");
        driverService.create(driver);

        driver.setLicenseNumber("45-664-555-66");
        driver.setName("Taras Boch");
        driverService.create(driver);

        driverService.delete(1L);
        driver.setName("Mick Rock");
        driver.setId(5L);
        driverService.update(driver);
        System.out.println(driverService.get(5L) + "\n");
        driverService.getAll().stream().forEach(System.out::println);

        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setCountry("Sweden");
        manufacturer.setName("Volvo");
        manufacturerService.create(manufacturer);

        manufacturer.setCountry("France");
        manufacturer.setName("Peugeot");
        manufacturerService.create(manufacturer);

        manufacturer.setCountry("Germany");
        manufacturer.setName("BMV");
        manufacturerService.create(manufacturer);

        manufacturer.setCountry("Germany");
        manufacturer.setName("Audi");
        manufacturerService.create(manufacturer);

        manufacturer.setCountry("Italy");
        manufacturer.setName("Maserati");
        manufacturerService.create(manufacturer);

        manufacturer.setCountry("Usa");
        manufacturer.setName("Ford");
        manufacturerService.create(manufacturer);

        manufacturer.setName("Mercedes-Benz");
        manufacturer.setId(6L);
        manufacturerService.update(manufacturer);

        manufacturer.setName("Tesla");
        manufacturer.setCountry("USA");
        manufacturerService.create(manufacturer);

        System.out.println(manufacturerService.get(7L) + "\n");
        manufacturerService.delete(6L);
        manufacturerService.getAll().stream().forEach(System.out::println);
    }
}
