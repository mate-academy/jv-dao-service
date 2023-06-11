package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        testDriverService(driverService);
        testManufacturerService(manufacturerService);
    }

    private static void testManufacturerService(ManufacturerService manufacturerService) {
        Manufacturer bugatti = new Manufacturer();
        bugatti.setCountry("Italy");
        bugatti.setName("Bugatti");
        System.out.println("Create Manufacturer in database: \n"
                + manufacturerService.create(bugatti));

        bugatti.setCountry("Germany");
        System.out.println("Update Manufacturer country in database: \n"
                + manufacturerService.update(bugatti));

        Manufacturer toyota = new Manufacturer();
        toyota.setName("Toyota");
        toyota.setCountry("Japan");
        System.out.println("Add new Manufacturer to database: \n"
                + manufacturerService.create(toyota));

        System.out.println("Get all Manufacturer: \n" + manufacturerService.getAll());

        System.out.println("Delete Bugatti: \n" + manufacturerService.delete(bugatti.getId()));

        System.out.println("Get Toyota: \n" + manufacturerService.get(toyota.getId()));
    }

    private static void testDriverService(DriverService driverService) {
        Driver vasiliy = new Driver();
        vasiliy.setName("Vasiliy");
        vasiliy.setLicenseNumber("1234");
        System.out.println("Create Driver in database: \n"
                + driverService.create(vasiliy));

        vasiliy.setLicenseNumber("4567");
        System.out.println("Update Driver licence in database: \n"
                + driverService.update(vasiliy));

        Driver sonya = new Driver();
        sonya.setName("Sonya");
        sonya.setLicenseNumber("3456");
        System.out.println("Add new Driver to database: \n"
                + driverService.create(sonya));

        System.out.println("Get all Drivers: \n" + driverService.getAll());

        System.out.println("Delete Vasiliy: \n" + driverService.delete(vasiliy.getId()));

        System.out.println("Get Sonya: \n" + driverService.get(sonya.getId()));
    }
}
