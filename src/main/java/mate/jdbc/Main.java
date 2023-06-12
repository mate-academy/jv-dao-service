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
        Driver volodymyr = driverService.create(new Driver("Volodymyr", "AO1234AB"));
        Driver petro = driverService.create(new Driver("Petro", "AB1454AB"));
        driverService.create(volodymyr);
        driverService.create(petro);

        System.out.println("all drivers: ");
        driverService.getAll().forEach(System.out::println);
        System.out.println(System.lineSeparator());

        Driver driver = driverService.get(volodymyr.getId());
        System.out.println("driver by id: " + volodymyr.getId());
        System.out.println(driver);
        System.out.println(System.lineSeparator());

        driver.setName("Misha");
        Driver updatedDriver = driverService.update(driver);
        System.out.println("updated driver: " + updatedDriver);
        System.out.println(System.lineSeparator());

        driverService.delete(petro.getId());
        System.out.println("All drivers: ");
        driverService.getAll().forEach(System.out::println);

        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        Manufacturer audi = manufacturerService.create(new Manufacturer("Audi", "Germany"));
        Manufacturer bmw = manufacturerService.create(new Manufacturer("BMW", "Germany"));
        manufacturerService.create(audi);
        manufacturerService.create(bmw);

        System.out.println("all manufacturers: ");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println(System.lineSeparator());

        Manufacturer manufacturer = manufacturerService.get(bmw.getId());
        System.out.println("manufacturer by id: " + bmw.getId());
        System.out.println(manufacturer);
        System.out.println(System.lineSeparator());

        manufacturer.setName("Tesla");
        Manufacturer updatedManufacturer = manufacturerService.update(manufacturer);
        System.out.println("updated manufacturer: " + updatedManufacturer);
        System.out.println(System.lineSeparator());

        manufacturerService.delete(bmw.getId());
        System.out.println("All manufacturers: ");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println(System.lineSeparator());
    }
}
