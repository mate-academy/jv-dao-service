package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.services.DriverService;
import mate.jdbc.services.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver max = new Driver("mad Max", "no_license_never_was");
        Driver alonso = new Driver("Fernando", "McLaren#666");
        max = driverService.create(max);
        alonso = driverService.create(alonso);
        driverService.getAll().forEach(System.out::println);
        alonso.setLicenseNumber("renault#777");
        driverService.update(alonso);
        System.out.println(driverService.get(alonso.getId()));
        driverService.delete(max.getId());
        driverService.getAll().forEach(System.out::println);

        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        Manufacturer mcLaren = new Manufacturer("Bruce McLaren Motor Racing Ltd", "UK");
        Manufacturer redBull = new Manufacturer("Red Bull GmbH", "Austria");
        mcLaren = manufacturerService.create(mcLaren);
        redBull = manufacturerService.create(redBull);
        manufacturerService.getAll().forEach(System.out::println);
        mcLaren.setName("McLaren Technology Group");
        manufacturerService.update(mcLaren);
        System.out.println(manufacturerService.get(mcLaren.getId()));
        manufacturerService.delete(redBull.getId());
        manufacturerService.getAll().forEach(System.out::println);
    }
}
