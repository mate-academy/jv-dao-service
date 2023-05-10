package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector
            .getInstance("mate.jdbc");
    private static final DriverService driverService = (DriverService) injector
            .getInstance(DriverService.class);
    private static final ManufacturerService manufacturerService = (ManufacturerService) injector
            .getInstance(ManufacturerService.class);

    public static void main(String[] args) {
        System.out.println("Testing DriverService methods:");
        Driver driver = driverService.create(new Driver("Ivan", "NX550369"));
        driverService.create(new Driver("Bogdan", "SB999256"));
        System.out.println("method \"get(" + driver.getId() + ")\" was called");
        System.out.println(driverService.get(driver.getId()));
        List<Driver> drivers = driverService.getAll();
        System.out.println("method \"getAll()\" was called");
        drivers.forEach(System.out::println);
        driver.setLicenceNumber("FX992080");
        driverService.update(driver);
        drivers = driverService.getAll();
        System.out.println("Data for driver with id " + driver.getId() + " was updated");
        drivers.forEach(System.out::println);
        driverService.delete(driver.getId());
        drivers = driverService.getAll();
        System.out.println("Driver with id " + driver.getId() + " was deleted");
        drivers.forEach(System.out::println);
        System.out.println("Testing ManufacturerService methods:");
        Manufacturer manufacturer = manufacturerService
                .create(new Manufacturer(null, "Tesla", "USA"));
        manufacturerService.create(new Manufacturer(null, "Volkswagen", "Germany"));
        manufacturerService.create(new Manufacturer(null, "Toyota", "Japan"));
        System.out.println("method \"get(" + manufacturer.getId() + ")\" was called");
        System.out.println(manufacturerService.get(manufacturer.getId()));
        List<Manufacturer> manufacturers = manufacturerService.getAll();
        System.out.println("method \"getAll()\" was called");
        manufacturers.forEach(System.out::println);
        manufacturer.setName("LuAZ");
        manufacturer.setCountry("Ukraine");
        manufacturerService.update(manufacturer);
        System.out.println("Data for manufacturer with id "
                + manufacturer.getId() + " was updated");
        manufacturers = manufacturerService.getAll();
        manufacturers.forEach(System.out::println);
        manufacturerService.delete(manufacturer.getId());
        System.out.println("manufacturer with id " + manufacturer.getId() + " was deleted");
        manufacturers = manufacturerService.getAll();
        manufacturers.forEach(System.out::println);
    }
}
