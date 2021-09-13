package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;
import mate.jdbc.service.impl.DriverServiceImpl;

public class Main {
    private static final String PACKAGE_NAME = "mate.jdbc";
    private static Injector injector = Injector.getInstance(PACKAGE_NAME);

    public static void main(String[] args) {
        driverTest();
//        manufacturerTest();
    }

    private static void driverTest() {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        System.out.println("\t\tTESTS FOR DRIVERS");
        System.out.println("\nTest for getAll()");
        System.out.println("DriverList: " + driverService.getAll());

        System.out.println("\nTest for create");
        Driver andrey = new Driver("Andrey", "1234567");
        System.out.println(driverService.create(andrey));

        System.out.println("\nTest for update");
        Long id = 1L;
        Driver alexander = new Driver("Alexander", "4534222");
        alexander.setId(id);
        System.out.println(driverService.update(alexander));

        System.out.println("\nTest for get");
        System.out.println(driverService.get(id));

        System.out.println("\nTest for delete");
        id = 2L;
        System.out.println(driverService.delete(id));
        System.out.println(driverService.get(id));
    }

    private static void manufacturerTest() {
        ManufacturerService manufacturerService = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        System.out.println("\t\tTESTS FOR MANUFACTURER");
        System.out.println("Test for getAll()");
        System.out.println("DriverList: " + manufacturerService.getAll());

        System.out.println("\nTest for create");
        Manufacturer company1 = new Manufacturer("Company1", "USA");
        System.out.println(manufacturerService.create(company1));

        System.out.println("\nTest for update");
        Long id = 4L;
        Manufacturer company111 = new Manufacturer("Company111", "USA");
        company111.setId(id);
        System.out.println(manufacturerService.update(company111));

        System.out.println("\nTest for get");
        System.out.println(manufacturerService.get(id));

        System.out.println("\nTest for delete");
        id = 6L;
        System.out.println(manufacturerService.delete(id));
    }
}
