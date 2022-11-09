package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver bob = new Driver(1L, "Bob", "AE-76359853");
        Driver alice = new Driver(2L, "Alice", "AE-34764643");
        driverService.create(bob);
        driverService.create(alice);
        System.out.println(driverService.getAll());
        bob.setLicenseNumber("AE-34654833");
        System.out.println(driverService.update(bob));

        ManufacturerService testService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        Manufacturer audi = new Manufacturer(1L, "Audi", "Germany");
        Manufacturer volvo = new Manufacturer(2L, "Volvo", "Sweden");
        testService.create(audi);
        testService.create(volvo);
        System.out.println(testService.getAll());
        System.out.println(testService.delete(2L));
    }
}
