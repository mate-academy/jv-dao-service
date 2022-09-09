package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        Manufacturer toyota = new Manufacturer(null,"Toyota", "Japan");
        Manufacturer bmw = new Manufacturer(null,"BMW", "Germany");
        toyota = manufacturerService.create(toyota);
        bmw = manufacturerService.create(bmw);
        System.out.println("Create 2 manufacturers");
        manufacturerService.getAll().forEach(System.out::println);

        manufacturerService.delete(bmw.getId());
        System.out.println("Delete BMW manufacturer");
        manufacturerService.getAll().forEach(System.out::println);

        toyota.setCountry("Korea");
        manufacturerService.update(toyota);
        System.out.println("Update Toyota manufacturer");
        System.out.println(manufacturerService.get(toyota.getId()));
        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver mike = new Driver(null, "Mike", "AE4552UA");
        driverService.create(mike);
        System.out.println("Add driver");
        driverService.getAll().forEach(System.out::println);

        mike.setLicenseNumber("AA0001UA");
        driverService.update(mike);
        System.out.println("Update driver Mike");
        System.out.println(driverService.get(mike.getId()));

        driverService.delete(mike.getId());
        System.out.println("Delete driver Mike");
        driverService.getAll().forEach(System.out::println);
    }
}
