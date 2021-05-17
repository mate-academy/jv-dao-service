package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer perfume = new Manufacturer("Paco Rabanne", "France");
        Manufacturer rockStarNorth = new Manufacturer("RDR2", "USA");
        Manufacturer microsoft = new Manufacturer("XBOX", "USA");

        manufacturerService.create(perfume);
        manufacturerService.create(rockStarNorth);
        manufacturerService.create(microsoft);
        manufacturerService.getAll().forEach(System.out::println);
        manufacturerService.get(rockStarNorth.getId());

        rockStarNorth.setName("GTA5");
        manufacturerService.update(perfume);
        manufacturerService.delete(microsoft.getId());
        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driverMax = new Driver("Max", "d123456");
        Driver driverRoman = new Driver("Roman", "d234567");
        Driver driverVlad = new Driver("Vlad", "d345678");

        driverService.create(driverMax);
        driverService.create(driverRoman);
        driverService.create(driverVlad);
        driverService.getAll().forEach(System.out::println);
        driverService.get(driverRoman.getId());

        driverRoman.setLicenseNumber("N19122");
        driverService.update(driverRoman);
        driverService.delete(driverVlad.getId());
        driverService.getAll().forEach(System.out::println);
    }
}
