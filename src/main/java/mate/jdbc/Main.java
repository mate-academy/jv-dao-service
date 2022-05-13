package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.servise.DriverService;
import mate.jdbc.servise.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);

        Driver firstDriver = new Driver();
        firstDriver.setName("Michalich");
        firstDriver.setLicenseNumber("8-800");
        System.out.println(driverService.create(firstDriver));
        firstDriver.setLicenseNumber("8-800-555-3535");
        driverService.update(firstDriver);

        Driver secondDriver = new Driver();
        secondDriver.setName("Bogdan");
        secondDriver.setLicenseNumber("1337");
        System.out.println(driverService.create(secondDriver));
        driverService.delete(secondDriver.getId());

        driverService.getAll().forEach(System.out::println);

        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        Manufacturer firstManufacturer = new Manufacturer(null, "Tesla", "USA");
        System.out.println(manufacturerService.create(firstManufacturer));
        manufacturerService.delete(firstManufacturer.getId());

        Manufacturer secondManufacturer = new Manufacturer(null, "Opel", "Germany");
        System.out.println(manufacturerService.create(secondManufacturer));
        secondManufacturer.setName("BMW");
        manufacturerService.update(secondManufacturer);

        manufacturerService.getAll().forEach(System.out::println);
    }
}
