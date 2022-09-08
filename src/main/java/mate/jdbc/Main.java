package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        final ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);

        System.out.println("Create(): ");
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Volvo");
        manufacturer.setCountry("Germany");
        Manufacturer createdManufacturer = manufacturerService.create(manufacturer);
        System.out.println(createdManufacturer);

        System.out.println("Get(): ");
        Manufacturer getManufacturer = manufacturerService.get(manufacturer.getId());
        System.out.println(getManufacturer);

        System.out.println("Update(): ");
        manufacturer.setName("Toyota");
        Manufacturer updatedManufacturer = manufacturerService.update(manufacturer);
        System.out.println(updatedManufacturer);

        System.out.println("Delete(): ");
        boolean deletedManufacturer = manufacturerService.delete(manufacturer.getId());
        System.out.println(deletedManufacturer);

        System.out.println("GetAll(): ");
        System.out.println(manufacturerService.getAll());

        final DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);

        System.out.println("Create():");
        Driver driver = new Driver();
        driver.setName("Chris");
        driver.setLicenseNumber("11223344");
        Driver createdDriver = driverService.create(driver);
        System.out.println(createdDriver);

        System.out.println("Get(): ");
        Driver getDriver = driverService.get(driver.getId());
        System.out.println(getDriver);

        System.out.println("Update(): ");
        driver.setName("Fred");
        Driver updatedDriver = driverService.update(driver);
        System.out.println(updatedDriver);

        System.out.println("Delete(): ");
        boolean deletedDriver = driverService.delete(driver.getId());
        System.out.println(deletedDriver);

        System.out.println("GetAll(): ");
        List<Driver> drivers = driverService.getAll();
        drivers.forEach(System.out::println);
    }
}
