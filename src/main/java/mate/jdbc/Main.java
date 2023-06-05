package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector
            = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Manufacturer manufacturers = new Manufacturer();
        manufacturers.setName("Nissan");
        manufacturers.setCountry("Japan");

        Manufacturer updatedManufacturers = new Manufacturer();
        updatedManufacturers.setId(4L);
        updatedManufacturers.setName("Audi");
        updatedManufacturers.setCountry("Germany");

        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);

        System.out.println("The Manufacturer table :");
        manufacturerService.getAll().forEach(System.out::println);

        System.out.println("\nThe Manufacturer table has been supplemented "
                + "with the following values: \n"
                + manufacturerService.create(manufacturers) + "\n");
        System.out.println("Get manufacturer by id: \n"
                + manufacturerService.get(35L) + "\n");
        System.out.println("The Manufacturer table has been updated "
                + "with the following values: \n"
                + manufacturerService.update(updatedManufacturers) + "\n");
        System.out.println("Manufacturer deleted: \n"
                + manufacturerService.delete(4L) + "\n");
        System.out.println("Updated manufacturer table: \n"
                + manufacturerService.getAll());

        Driver drivers = new Driver();
        drivers.setName("Anatoliy");
        drivers.setLicenseNumber("12345678");

        Driver updatedDriver = new Driver();
        updatedDriver.setId(3L);
        updatedDriver.setName("Ivan");
        updatedDriver.setLicenseNumber("444");

        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);

        System.out.println("The Driver table :");
        driverService.getAll().forEach(System.out::println);

        System.out.println("\nThe Driver table has been supplemented "
                + "with the following values: \n"
                + driverService.create(drivers) + "\n");
        System.out.println("Get information about driver by id: \n"
                + driverService.get(1L) + "\n");
        System.out.println("The Driver table has been updated "
                + "with the following values: \n"
                + driverService.update(updatedDriver) + "\n");
        System.out.println("The information about driver was deleted, id: \n"
                + driverService.delete(3L) + "\n");
        System.out.println("Updated drivers table: \n"
                + driverService.getAll());
    }
}
