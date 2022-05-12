package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
       ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        Manufacturer chryslerCar = new Manufacturer("Chrysler", "USA");
        Manufacturer hondaCar = new Manufacturer("Honda", "Japan");
        manufacturerService.create(chryslerCar);
        manufacturerService.create(hondaCar);
        chryslerCar.setCountry("Italy");
        manufacturerService.update(chryslerCar);
        manufacturerService.delete(hondaCar.getId());
        manufacturerService.getAll().forEach(System.out::println);
        Driver bob = new Driver("Bob", "123832874");
        Driver alice = new Driver("Alice", "09037847239");
        driverService.create(bob);
        driverService.create(alice);
        bob.setLicenseNumber("8888888888");
        driverService.update(bob);
        driverService.delete(alice.getId());
        driverService.getAll().forEach(System.out::println);
    }
}
