package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = new Injector("mate");

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        System.out.println("Origin Manufacturer Table");
        manufacturerService.getAll().forEach(System.out::println);
        Manufacturer manufacturerToAdd = new Manufacturer("Smart", "Germany");
        Manufacturer addedManufacturerWithId = manufacturerService.create(manufacturerToAdd);
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("\nGetting added manufacturer by using method get");
        System.out.println(manufacturerService.get(addedManufacturerWithId.getId()) + "\n");
        addedManufacturerWithId.setName("Renault");
        addedManufacturerWithId.setCountry("France");
        manufacturerService.update(addedManufacturerWithId);
        System.out.println("\nTable with updated manufacturer");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println(manufacturerService.delete(addedManufacturerWithId.getId()));
        System.out.println("Table after deleting manufacturer");
        manufacturerService.getAll().forEach(System.out::println);
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        System.out.println("\nOrigin drivers table");
        driverService.getAll().forEach(System.out::println);
        Driver driverToAdd = new Driver("Alex", "lx975");
        Driver addedDriver = driverService.create(driverToAdd);
        driverService.getAll().forEach(System.out::println);
        System.out.println("\nGetting new added driver by using method get");
        System.out.println(driverService.get(addedDriver.getId()));
        addedDriver.setName("Kiril");
        addedDriver.setLicenseNumber("krl357");
        System.out.println("\nTable with updated driver");
        driverService.update(addedDriver);
        driverService.getAll().forEach(System.out::println);
        System.out.println("\nTable after deleting manufacturer");
        driverService.delete(addedDriver.getId());
        driverService.getAll().forEach(System.out::println);
    }
}
