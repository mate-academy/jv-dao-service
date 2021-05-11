package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final ManufacturerService manufacturerService
            = (ManufacturerService) injector.getInstance(ManufacturerService.class);
    private static final DriverService driverService
            = (DriverService) injector.getInstance(DriverService.class);

    public static void main(String[] args) {
        Manufacturer apple = new Manufacturer();
        apple.setName("Apple");
        apple.setCountry("United States");

        Manufacturer lenovo = new Manufacturer();
        lenovo.setName("Lenovo");
        lenovo.setCountry("China");

        Manufacturer xiaomi = new Manufacturer();
        xiaomi.setName("Xiaomi");
        xiaomi.setCountry("China");

        System.out.println(".....Save manufacturers to DB.....");
        System.out.printf("Apple manufacturer saved to DB %s%n",
                manufacturerService.create(apple));
        System.out.printf("Lenovo manufacturer saved to DB %s%n",
                manufacturerService.create(lenovo));
        System.out.printf("Xiaomi manufacturer saved to DB %s%n",
                manufacturerService.create(xiaomi));
        System.out.println();

        System.out.println(".....Remove manufacturer from DB.....");
        System.out.println(manufacturerService.delete(xiaomi.getId()));
        System.out.println();

        System.out.println(".....Show all data from DB.....");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println();

        System.out.println(".....Update manufacturer in DB.....");
        apple.setName("Samsung");
        System.out.printf("New element in DB %s%n", manufacturerService.update(apple));
        System.out.println();

        System.out.println("....Get manufacturer from DB.....");
        System.out.println(manufacturerService.get(apple.getId()));
        System.out.println();

        Driver bob = new Driver();
        bob.setName("Bob");
        bob.setLicenseNumber("123456789");

        Driver alice = new Driver();
        alice.setName("Alice");
        alice.setLicenseNumber("987654321");

        System.out.println(".....Save drivers to DB.....");
        System.out.printf("Driver Bob saved to DB %s%n",
                driverService.create(bob));
        System.out.printf("Driver Alice saved to DB %s%n",
                driverService.create(alice));
        System.out.println();

        System.out.println(".....Remove driver from DB.....");
        System.out.println(driverService.delete(alice.getId()));
        System.out.println();

        System.out.println(".....Show all drivers from DB.....");
        driverService.getAll().forEach(System.out::println);
        System.out.println();

        System.out.println(".....Update driver in DB.....");
        bob.setLicenseNumber("999999999");
        System.out.printf("New driver in DB %s%n", driverService.update(bob));
        System.out.println();

        System.out.println("....Get driver from DB.....");
        System.out.println(driverService.get(bob.getId()));
    }
}
