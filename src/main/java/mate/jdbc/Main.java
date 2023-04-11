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
        manufacturerService.create(new Manufacturer(0L,"BMW","Germany"));
        manufacturerService.create(new Manufacturer(0L,"Audi","Germany"));
        System.out.println("All information from manufacturers table: ");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("Information about element with id 10");
        System.out.println(manufacturerService.get(10L));
        System.out.println("Information in manufacturers table after update element with id 10: ");
        manufacturerService.update(new Manufacturer(10L, "Audi Q8", "Germany"));
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("Information in manufacturers after delete element with id 9");
        manufacturerService.delete(9L);
        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        driverService.create(new Driver(0L,"John","123"));
        driverService.create(new Driver(0L,"Alice","456"));
        System.out.println(System.lineSeparator() + "All information from drivers table: ");
        driverService.getAll().forEach(System.out::println);
        System.out.println("Information about element with id 1");
        System.out.println(driverService.get(1L));
        System.out.println("Information in drivers table after update element with id 1: ");
        driverService.update(new Driver(1L, "Bob", "123B"));
        driverService.getAll().forEach(System.out::println);
        System.out.println("Information in drivers table after delete element with id 1");
        driverService.delete(1L);
        driverService.getAll().forEach(System.out::println);
    }
}
