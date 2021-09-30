package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        System.out.println("The result of the method getAll() "
                + "from ManufacturerServiceImpl Class: ");
        manufacturerService.getAll().stream().forEach(System.out::println);

        Manufacturer getToyota = manufacturerService.get(6L);
        System.out.println("The result of the method get() from ManufacturerServiceImpl Class: "
                + getToyota);
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Toyota");
        manufacturer.setCountry("USA");
        Manufacturer toyota = manufacturerService.create(manufacturer);
        System.out.println("The result of the method create() from ManufacturerServiceImpl Class: "
                + toyota);

        manufacturer.setName("Toyota Motor Corporation");
        Manufacturer updatedToyota = manufacturerService.update(manufacturer);
        System.out.println("The result of the method update() from ManufacturerServiceImpl Class: "
                + updatedToyota);
        boolean deletedManufacturer = manufacturerService.delete(toyota.getId());
        System.out.println("The result of the method delete() from ManufacturerServiceImpl Class: "
                + deletedManufacturer);

        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);
        System.out.println("The result of the method getAll() from DriverServiceImpl Class: ");
        driverService.getAll().stream().forEach(System.out::println);

        Driver driverInfo = driverService.get(4L);
        System.out.println("The result of the method get() from DriverServiceImpl Class: "
                + driverInfo);

        Driver driver = new Driver("Bob", "23456789");
        driverService.create(driver);
        System.out.println("The result of the method create() "
                + "from DriverServiceImpl Class: " + driver);

        driver.setLicenseNumber("12309812");
        Driver updatedDriverData = driverService.update(driver);
        System.out.println("The result of the method update() from DriverServiceImpl Class: "
                + updatedDriverData);

        boolean deletedDriverData = driverService.delete(driver.getId());
        System.out.println("The result of the method delete() from DriverServiceImpl Class: "
                + deletedDriverData);
    }
}
