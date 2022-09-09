package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final String PACKAGE_NAME = "mate.jdbc";

    public static void main(String[] args) {
        Injector injector = Injector.getInstance(PACKAGE_NAME);
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);

        Manufacturer opel = new Manufacturer("Opel", "Germany");
        Manufacturer fiat = new Manufacturer("Fiat", "France");
        Manufacturer tesla = new Manufacturer("Tesla", "USA");
        manufacturerService.create(opel);
        manufacturerService.create(fiat);
        manufacturerService.create(tesla);

        System.out.println("Create manufacturers: ");
        manufacturerService.getAll().forEach(System.out::println);

        System.out.println("Change Opel country to Ukraine");

        opel.setCountry("Ukraine");
        manufacturerService.update(opel);
        System.out.println(manufacturerService.get(opel.getId()));

        System.out.println("Remove fiat from DB");

        manufacturerService.delete(fiat.getId());
        manufacturerService.getAll().forEach(System.out::println);

        Driver smith = new Driver("Smith", "AX368");
        Driver larry = new Driver("Larry", "RX555");

        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);

        System.out.println("Create drivers: ");

        driverService.create(smith);
        driverService.create(larry);
        driverService.getAll().forEach(System.out::println);

        System.out.println("Change larry license number");

        larry.setLicenseNumber("AA602");
        driverService.update(larry);
        System.out.println(driverService.get(larry.getId()));

        System.out.println("Remove smith smith from DB");

        driverService.delete(smith.getId());
        driverService.getAll().forEach(System.out::println);
    }
}
