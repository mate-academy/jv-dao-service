package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");
    private static final Long WRONG_ID = 200L;

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturerSandro = new Manufacturer("Sandro", "France");
        Manufacturer manufacturerMaje = new Manufacturer("Maje", "France");
        Manufacturer manufacturerZara = new Manufacturer("Zara", "Spain");

        manufacturerService.create(manufacturerSandro);
        manufacturerService.create(manufacturerMaje);
        manufacturerService.create(manufacturerZara);
        manufacturerService.getAll().forEach(System.out::println);
        manufacturerService.get(manufacturerMaje.getId());

        manufacturerSandro.setCountry("Spain");
        manufacturerService.update(manufacturerSandro);
        manufacturerService.delete(manufacturerZara.getId());
        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driverBob = new Driver("Bob", "N1234");
        Driver driverMax = new Driver("Max", "N127689");
        Driver driverSam = new Driver("Sam", "N19121");

        driverService.create(driverBob);
        driverService.create(driverMax);
        driverService.create(driverSam);
        driverService.getAll().forEach(System.out::println);
        driverService.get(driverMax.getId());

        driverBob.setLicenseNumber("N19122");
        driverService.update(driverBob);
        driverService.delete(driverSam.getId());
        driverService.getAll().forEach(System.out::println);
        driverService.get(WRONG_ID);
    }
}
