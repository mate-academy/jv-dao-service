package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final ManufacturerService manufacturerService = (ManufacturerService)
            injector.getInstance(ManufacturerService.class);
    private static final DriverService driverService = (DriverService)
            injector.getInstance(DriverService.class);

    public static void main(String[] args) {
        Manufacturer kraz = new Manufacturer("kraz", "Ukraine");
        Manufacturer bogdan = new Manufacturer("Bogdan", "Ukraine");
        manufacturerService.create(kraz);
        manufacturerService.create(bogdan);

        manufacturerService.getAll().forEach(System.out::println);

        System.out.println(manufacturerService.get(kraz.getId()));

        kraz.setName("KRAZ");
        kraz.setCountry("UKRAINE");
        System.out.println(manufacturerService.update(kraz));

        System.out.println(manufacturerService.delete(kraz.getId()));

        // Driver

        Driver oleg = new Driver("Oleg", "000001");
        Driver bob = new Driver("Bob", "000002");
        driverService.create(oleg);
        driverService.create(bob);

        driverService.getAll().forEach(System.out::println);

        System.out.println(driverService.get(oleg.getId()));

        oleg.setName("Alice");
        oleg.setLicenseNumber("000003");
        System.out.println(driverService.update(oleg));

        System.out.println(driverService.delete(oleg.getId()));
    }
}
