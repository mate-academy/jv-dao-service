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
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Hyundai");
        manufacturer.setCountry("South Korea");
        Manufacturer savedManufacturer = manufacturerService.create(manufacturer);
        System.out.println("New manufacturer has been created: " + savedManufacturer);

        Long id = 7L;
        manufacturer = manufacturerService.get(id);
        System.out.println("Manufacturer was received from DB: " + manufacturer);

        manufacturer.setId(7L);
        manufacturer.setName("Citroen");
        manufacturer.setCountry("France");
        Manufacturer updatedManufacturer = manufacturerService.update(manufacturer);
        System.out.println("Manufacturer has been changed: " + updatedManufacturer);

        id = 7L;
        if (manufacturerService.delete(id)) {
            System.out.println("Manufacturer with id " + id + " was successfully deleted from DB");
        }

        List<Manufacturer> manufacturersList = manufacturerService.getAll();
        System.out.println("Full list of manufacturers:");
        manufacturersList.forEach(System.out::println);

        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver();
        driver.setName("Anton");
        driver.setLicenseNumber("00000002");
        Driver savedDriver = driverService.create(driver);
        System.out.println("New driver has been created: " + savedDriver);

        id = 2L;
        driver = driverService.get(id);
        System.out.println("Driver was received from DB: " + driver);

        driver.setId(2L);
        driver.setName("Igor");
        driver.setLicenseNumber("00000003");
        Driver updatedDriver = driverService.update(driver);
        System.out.println("Driver has been changed: " + updatedDriver);

        id = 2L;
        if (driverService.delete(id)) {
            System.out.println("Driver with id " + id + " was successfully deleted from DB");
        }

        List<Driver> driversList = driverService.getAll();
        System.out.println("Full list of drivers:");
        driversList.forEach(System.out::println);
    }
}
