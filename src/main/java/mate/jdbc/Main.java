package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        // test your code here
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);

        manufacturerService.create(new Manufacturer("Audi","Germany"));
        manufacturerService.create(new Manufacturer("BMW","Germany"));
        System.out.println("All information from manufacturers table: ");
        manufacturerService.getAll().forEach(System.out::println);

        System.out.println(System.lineSeparator() + "Information about element with id 1");
        Manufacturer manufacturerWithId1 = manufacturerService.get(1L);
        System.out.println(manufacturerWithId1 + System.lineSeparator());

        System.out.println("Information in manufacturers table after update element with id 1: ");
        manufacturerWithId1.setName("Audi Q8");
        manufacturerService.update(manufacturerWithId1);
        manufacturerService.getAll().forEach(System.out::println);

        System.out.println(System.lineSeparator()
                + "Information in manufacturers after delete element with id 1");
        manufacturerService.delete(manufacturerWithId1.getId());
        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        driverService.create(new Driver("John","123"));
        driverService.create(new Driver("Alice","456"));
        System.out.println(System.lineSeparator() + "All information from drivers table: ");
        driverService.getAll().forEach(System.out::println);

        System.out.println(System.lineSeparator() + "Information about element with id 1");
        Driver driverWithId1 = driverService.get(1L);
        System.out.println(driverWithId1);

        System.out.println(System.lineSeparator()
                + "Information in drivers table after update element with id 1: ");
        driverWithId1.setName("Bob");
        driverWithId1.setLicenseNumber("123B");
        driverService.update(driverWithId1);
        driverService.getAll().forEach(System.out::println);

        System.out.println(System.lineSeparator()
                + "Information in drivers table after delete element with id 1");
        driverService.delete(driverWithId1.getId());
        driverService.getAll().forEach(System.out::println);
    }
}
