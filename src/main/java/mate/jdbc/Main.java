package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);
        Driver bob = new Driver("Bob", "NX28732");
        driverService.create(bob);
        bob.setLicenseNumber("NM395873057");
        driverService.update(bob);
        Driver meggie = new Driver("Meggie", "ZL982729842");
        driverService.create(meggie);
        Driver simon = new Driver("Simon", "GD283482462");
        driverService.create(simon);
        driverService.delete(meggie.getId());
        driverService.getAll().forEach(System.out::println);
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        Manufacturer saab = new Manufacturer("Saab", "Sweden");
        manufacturerService.create(saab);
        manufacturerService.delete(saab.getId());
        Manufacturer bentley = new Manufacturer("Bentley", "United Kingdom");
        manufacturerService.create(bentley);
        bentley.setCountry("Germany");
        manufacturerService.update(bentley);
        manufacturerService.getAll().forEach(System.out::println);
    }
}
