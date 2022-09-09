package mate.jdbc;

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

        Manufacturer astonMartin = new Manufacturer();

        astonMartin.setName("Aston Martin");
        astonMartin.setCountry("United Kingdom");

        System.out.println("Create manufacturer");
        System.out.println(manufacturerService.create(astonMartin));

        System.out.println("Get manufacturer by id");
        Manufacturer getManufacturer = manufacturerService.get(astonMartin.getId());
        System.out.println(getManufacturer);

        System.out.println("Get all manufacturer");
        manufacturerService.getAll().forEach(System.out::println);

        System.out.println("Update manufacturer");
        astonMartin.setCountry("England");
        System.out.println(manufacturerService.update(astonMartin));

        System.out.println("Delete driver");
        boolean deleteManufacturer = manufacturerService.delete(astonMartin.getId());
        System.out.println(deleteManufacturer);

        Driver valera = new Driver();

        valera.setName("Valera");
        valera.setLicenseNumber("007");

        final DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);

        System.out.println("Create driver");
        System.out.println(driverService.create(valera));

        System.out.println("Get driver by id");
        Driver getDriver = driverService.get(valera.getId());
        System.out.println(getDriver);

        System.out.println("Get all drivers");
        driverService.getAll().forEach(System.out::println);

        System.out.println("Update driver");
        valera.setLicenseNumber("001");
        System.out.println(driverService.update(valera));

        System.out.println("Delete driver");
        boolean deleteDriver = driverService.delete(valera.getId());
        System.out.println(deleteDriver);
    }
}
