package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final String INJECTOR_INSTANCE = "mate.jdbc";

    public static void main(String[] args) {
        Injector serviceInjector = Injector.getInstance(INJECTOR_INSTANCE);
        ManufacturerService manufacturerService = (ManufacturerService) serviceInjector
                .getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Ford");
        manufacturer.setCountry("USA");
        manufacturerService.create(manufacturer);
        manufacturer.setName("Tata");
        manufacturer.setCountry("India");
        manufacturerService.create(manufacturer);
        manufacturer.setName("BMW");
        manufacturer.setCountry("Germany");
        manufacturerService.create(manufacturer);
        manufacturerService.get((long) 1);
        System.out.println(manufacturer);
        manufacturerService.delete(2);
        manufacturerService.getAll().forEach(System.out::println);
        manufacturer.setId((long) 3);
        manufacturer.setName("Bugatti");
        manufacturer.setCountry("Italy");
        manufacturerService.update(manufacturer);
        manufacturerService.getAll().forEach(System.out::println);
        DriverService driverService = (DriverService) serviceInjector
                .getInstance(DriverService.class);
        Driver driver = new Driver();
        driver.setName("Igor");
        driver.setLicenseNumber("UA9812S04");
        driverService.create(driver);
        driver.setName("Kolya");
        driver.setLicenseNumber("UA7712S09");
        driverService.create(driver);
        driver.setName("Bohdan");
        driver.setLicenseNumber("UA3908S03");
        driverService.create(driver);
        driverService.get((long) 1);
        driverService.delete(2);
        driverService.getAll().forEach(System.out::println);
        driver.setId((long) 3);
        driver.setName("Gogi");
        driver.setLicenseNumber("UA3117S09");
        driverService.update(driver);
        driverService.getAll().forEach(System.out::println);
    }
}
