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
        Manufacturer nissan = new Manufacturer(null,"Nissan", "Japan");
        Manufacturer tesla = new Manufacturer(null, "Tesla", "USA");
        manufacturerService.create(nissan);
        manufacturerService.create(tesla);
        System.out.println("\n=== Added 2 manufacturers ===\n");
        manufacturerService.getAll().forEach(System.out::println);

        tesla.setCountry("Ukraine");
        manufacturerService.update(tesla);
        System.out.println("\n=== Updated Tesla manufacturer ===\n");
        System.out.println(manufacturerService.get(tesla.getId()));

        manufacturerService.delete(nissan.getId());
        System.out.println("\n=== Deleted Nissan manufacturer ===\n");
        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver bob = new Driver(null, "Bob", "LN444333OP");
        Driver alice = new Driver(null, "Alice", "LN666999OP");
        driverService.create(bob);
        driverService.create(alice);
        System.out.println("\n=== Added 2 drivers ===\n");
        driverService.getAll().forEach(System.out::println);

        alice.setLicenseNumber("UA555000DP");
        driverService.update(alice);
        System.out.println("\n=== Updated Alice driver ===\n");
        System.out.println(driverService.get(alice.getId()));

        driverService.delete(bob.getId());
        System.out.println("\n=== Deleted Bob driver ===\n");
        driverService.getAll().forEach(System.out::println);
    }
}
