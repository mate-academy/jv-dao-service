package mate.jdbc;

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
    private static final Long TEST_ID = 1L;

    public static void main(String[] args) {
        System.out.println("Driver's service CRUD tests:");
        Driver firstDriver = driverService.create(new Driver("Elvira_Solnyshkina", "AA1234567CK"));
        Driver secondDriver = driverService.create(new Driver("Robert_Martin", "ST3213213LY"));
        System.out.println(firstDriver);
        System.out.println(secondDriver);
        System.out.println(driverService.get(TEST_ID));
        driverService.update(new Driver(TEST_ID, "Sophia_Copolla", "BB7654321CL"));
        driverService.getAll().forEach(System.out::println);
        driverService.delete(TEST_ID);
        driverService.getAll().forEach(System.out::println);
        System.out.println("Manufacturer's service CRUD tests:");
        Manufacturer manufacturerSuzuki = manufacturerService
                .create(new Manufacturer("Suzuki", "Japan"));
        Manufacturer manufacturerFord = manufacturerService.create(new Manufacturer("Ford", "USA"));
        System.out.println(manufacturerSuzuki);
        System.out.println(manufacturerFord);
        System.out.println(manufacturerService.get(TEST_ID));
        manufacturerService.update(new Manufacturer(TEST_ID, "Citroen", "France"));
        manufacturerService.getAll().forEach(System.out::println);
        manufacturerService.delete(TEST_ID);
        manufacturerService.getAll().forEach(System.out::println);
    }
}
