package mate.jdbc;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) throws SQLException {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);

        List<Manufacturer> manufacturerList = Arrays.asList(
                new Manufacturer("Renault", "France"),
                new Manufacturer("Shevrolet", "USA"),
                new Manufacturer("Audi", "USA"));

        manufacturerList.forEach(manufacturer -> manufacturerService.create(manufacturer));

        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("List of created manufacturers\n");

        Manufacturer manufacturerWhichWasGot = manufacturerService.get(Long.valueOf(73));
        System.out.println(manufacturerWhichWasGot);
        System.out.println("Manufacturer which was got by ID\n");

        manufacturerWhichWasGot.setCountry("Germany");
        System.out.println(manufacturerService.update(manufacturerWhichWasGot));
        System.out.println("Manufacturer which was updated\n");

        manufacturerService.delete(manufacturerWhichWasGot.getId());
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("List of manufacturers without deleted one\n");

        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);

        List<Driver> drivers = Arrays.asList(
                new Driver("Mika Hakkinen", "Fin_1998,1999"),
                new Driver("Kimi Raikkonen", "Fin_2007"),
                new Driver("Jenson Button", "Ger_2009"));

        drivers.forEach(driver -> driverService.create(driver));

        driverService.getAll().forEach(System.out::println);
        System.out.println("List of created drivers\n");

        Driver driverWhichWasGot = driverService.get(Long.valueOf(8));
        System.out.println(driverWhichWasGot);
        System.out.println("Driver which was got by ID\n");

        driverWhichWasGot.setLicenseNumber("GB_2009");
        System.out.println(driverService.update(driverWhichWasGot));
        System.out.println("Driver which was updated\n");

        driverService.delete(Long.valueOf(9));
        driverService.getAll().forEach(System.out::println);
        System.out.println("List of drivers without deleted one");
    }
}
