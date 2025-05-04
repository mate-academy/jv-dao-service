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
        Manufacturer mercedes = new Manufacturer(null, "Mercedes", "Germany");
        Manufacturer audi = new Manufacturer(null, "Audi", "Germany");
        Manufacturer tesla = new Manufacturer(null, "Tesla", "USA");
        mercedes = manufacturerService.create(mercedes);
        audi = manufacturerService.create(audi);
        tesla = manufacturerService.create(tesla);
        System.out.println("Create 3 manufacturers");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("***");
        tesla.setName("Toyota");
        manufacturerService.update(tesla);
        System.out.println("Change manufacturer name Tesla to Toyota");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("***");
        manufacturerService.delete(mercedes.getId());
        System.out.println("Delete manufacturer mercedes from database");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("***");
        Manufacturer getManufacturer = manufacturerService.get(audi.getId());
        System.out.println("Get manufacturer Audi from database");
        System.out.println(getManufacturer);

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver bob = new Driver(null,"Bob","123456789LN");
        Driver alice = new Driver(null,"Alice","123456788LN");
        Driver alex = new Driver(null,"Alex","123456787LN");
        bob = driverService.create(bob);
        alice = driverService.create(alice);
        alex = driverService.create(alex);
        System.out.println("Create 3 drivers");
        driverService.getAll().forEach(System.out::println);
        System.out.println("***");
        alex.setName("alice");
        driverService.update(alex);
        System.out.println("Change driver name Alex to Alice");
        driverService.getAll().forEach(System.out::println);
        System.out.println("***");
        driverService.delete(bob.getId());
        System.out.println("Delete driver Bob from database");
        driverService.getAll().forEach(System.out::println);
        System.out.println("***");
        Driver getDriver = driverService.get(alice.getId());
        System.out.println("Get driver Alice from database");
        System.out.println(getDriver);
    }
}
