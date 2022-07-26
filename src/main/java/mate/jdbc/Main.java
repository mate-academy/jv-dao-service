package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    public static void main(String[] args) {
        Injector injector = Injector.getInstance("mate.jdbc");
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);

        Driver newDriver = new Driver();
        newDriver.setName("Julia");
        newDriver.setLicenseNumber("10985RG");
        System.out.println("New driver was created: " + driverService.create(newDriver));

        System.out.println(System.lineSeparator()
                + "Driver by id: " + newDriver.getId()
                + " was found: " + driverService.get(newDriver.getId()));

        newDriver.setLicenseNumber("03293VB");
        System.out.println(System.lineSeparator()
                + "Driver" + newDriver.getName()
                + " was updated: " + driverService.update(newDriver));

        driverService.delete(newDriver.getId());
        System.out.println(System.lineSeparator()
                + "Driver by id: "
                + newDriver.getId() + " was deleted");
        System.out.println(System.lineSeparator()
                + "All drivers: ");
        driverService.getAll().forEach(System.out::println);

        Manufacturer newManufacturer = new Manufacturer();
        newManufacturer.setName("Peugeot");
        newManufacturer.setCountry("France");

        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);

        Manufacturer createdManufacturer = manufacturerService.create(newManufacturer);
        System.out.println(System.lineSeparator()
                + "New manufacturer was created: " + createdManufacturer);

        System.out.println(System.lineSeparator()
                + "Manufacturer was found: "
                + manufacturerService.get(createdManufacturer.getId()));

        createdManufacturer.setName("Citroen");
        System.out.println(System.lineSeparator()
                + "Manufacturer by id: " + newManufacturer.getId()
                + " was updated: " + manufacturerService.update(createdManufacturer));

        manufacturerService.delete(createdManufacturer.getId());
        System.out.println(System.lineSeparator()
                + "Manufacturer by id: " + newManufacturer.getId()
                + " was deleted.");

        System.out.println(System.lineSeparator()
                + "All manufacturers: ");
        manufacturerService.getAll().forEach(System.out::println);
    }
}
