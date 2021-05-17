package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Manufacturer newManufacturer = new Manufacturer();
        newManufacturer.setName("msa");
        newManufacturer.setCountry("japan");

        Driver newDriver = new Driver();
        newDriver.setName("compact");
        newDriver.setLicenseNumber("TH4568");

        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);

        manufacturerService.create(newManufacturer);
        driverService.create(newDriver);
        System.out.println(System.lineSeparator());
        manufacturerService.getAll().forEach(System.out::println);
        driverService.getAll().forEach(System.out::println);

        System.out.println(manufacturerService.get(newManufacturer.getId()));
        System.out.println(driverService.get(newDriver.getId()));

        newManufacturer.setName("msi");
        newManufacturer.setCountry("taiwan");
        newDriver.setName("contact");
        newDriver.setLicenseNumber("PO5486");
        manufacturerService.update(newManufacturer);
        driverService.update(newDriver);
        manufacturerService.getAll().forEach(System.out::println);
        driverService.getAll().forEach(System.out::println);

        manufacturerService.delete(newManufacturer.getId());
        driverService.delete(newDriver.getId());
        manufacturerService.getAll().forEach(System.out::println);
        driverService.getAll().forEach(System.out::println);
    }
}
