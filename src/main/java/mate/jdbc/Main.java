package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final ManufacturerService manufacturerService =
            (ManufacturerService) injector.getInstance(ManufacturerService.class);
    private static final DriverService driverService =
            (DriverService) injector.getInstance(DriverService.class);

    public static void main(String[] args) {
        /* Manufacturer section */
        System.out.println("Initial records");
        List<Manufacturer> manufacturerList = manufacturerService.getAll();
        manufacturerList.forEach(System.out::println);

        System.out.println(System.lineSeparator() + "After adding record");
        Manufacturer manufacturer = new Manufacturer("Embraer", "Brazil");
        manufacturerService.create(manufacturer);
        manufacturerList = manufacturerService.getAll();
        manufacturerList.forEach(System.out::println);

        System.out.println(System.lineSeparator() + "Search result of record 8");
        try {
            manufacturer = manufacturerService.get(8L);
            System.out.println(manufacturer);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(System.lineSeparator() + "After updating record 2");
        manufacturer = new Manufacturer(2L, "Bombardier", "Seychelles");
        manufacturerService.update(manufacturer);
        manufacturerList = manufacturerService.getAll();
        manufacturerList.forEach(System.out::println);

        System.out.println(System.lineSeparator() + "After deleting record 9");
        boolean deleteResult = manufacturerService.delete(9L);
        manufacturerList = manufacturerService.getAll();
        manufacturerList.forEach(System.out::println);
        System.out.println(deleteResult);

        /* Driver section */
        System.out.println("Initial records");
        List<Driver> driverList = driverService.getAll();
        driverList.forEach(System.out::println);

        System.out.println(System.lineSeparator() + "After adding record");
        Driver driver = new Driver("Peter", "AE174856");
        driverService.create(driver);
        driverList = driverService.getAll();
        driverList.forEach(System.out::println);

        System.out.println(System.lineSeparator() + "Search result of record 2");
        try {
            driver = driverService.get(2L);
            System.out.println(driver);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(System.lineSeparator() + "After updating record 2");
        driver = new Driver(2L, "John", "EE999999");
        driverService.update(driver);
        driverList = driverService.getAll();
        driverList.forEach(System.out::println);

        System.out.println(System.lineSeparator() + "After deleting record 2");
        deleteResult = driverService.delete(2L);
        driverList = driverService.getAll();
        driverList.forEach(System.out::println);
        System.out.println(deleteResult);
    }
}
