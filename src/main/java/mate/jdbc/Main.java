package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Manufacturer volvo = new Manufacturer("Volvo", "Sweden");
        Manufacturer mercedes = new Manufacturer("Mercedes", "Germany");
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);

        manufacturerService.create(volvo);
        manufacturerService.create(mercedes);
        System.out.println(manufacturerService.get(mercedes.getId()));
        mercedes.setName("Mercedes-AMG");
        manufacturerService.update(mercedes);
        manufacturerService.delete(volvo.getId());
        manufacturerService.getAll().forEach(System.out::println);

        Driver bob = new Driver("Bob", "ab1234");
        Driver anna = new Driver("Anna", "cd5678");
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        driverService.create(bob);
        driverService.create(anna);
        System.out.println(driverService.get(anna.getId()));
        anna.setLicenseNumber("a3333");
        driverService.update(anna);
        driverService.delete(bob.getId());
        driverService.getAll().forEach(System.out::println);
    }
}
