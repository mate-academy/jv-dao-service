package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufactureService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufactureService manufactureService =
                (ManufactureService) injector.getInstance(ManufactureService.class);

        Manufacturer bmw = new Manufacturer(1L, "BMW", "Germany");
        System.out.println("create manufacturer");
        System.out.println(manufactureService.create(bmw) + System.lineSeparator());
        System.out.println("get manufacturer");
        System.out.println(manufactureService.get(bmw.getId()) + System.lineSeparator());
        List<Manufacturer> manufacturers = manufactureService.getAll();
        System.out.println("getAll manufacturers");
        for (Manufacturer manufacturer : manufacturers) {
            System.out.println(manufacturer);
        }
        System.out.println();
        bmw.setName("MINI");
        System.out.println("update manufacturer");
        System.out.println(manufactureService.update(bmw) + System.lineSeparator());
        System.out.println("delete manufacturer");
        System.out.println(manufactureService.delete(bmw.getId()) + System.lineSeparator());

        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);

        Driver bob = new Driver(1L, "Bob", "1010101");
        System.out.println("create driver");
        System.out.println(driverService.create(bob) + System.lineSeparator());
        System.out.println("get driver");
        System.out.println(driverService.get(bob.getId()) + System.lineSeparator());
        List<Driver> drivers = driverService.getAll();
        System.out.println("getAll drivers");
        for (Driver driver : drivers) {
            System.out.println(driver);
        }
        System.out.println();
        bob.setName("BOB");
        System.out.println("update driver");
        System.out.println(driverService.update(bob) + System.lineSeparator());
        System.out.println("delete driver");
        System.out.println(driverService.delete(bob.getId()));
    }
}
