package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver bob = driverService.create(new Driver("Bob", "123"));
        Driver merlin = driverService.create(new Driver("Merlin", "456"));
        Driver robert = driverService.create(new Driver("Robert", "789"));
        Driver updateRobertLicense = new Driver(robert.getId(), robert.getName(), "987");
        System.out.println(driverService.update(updateRobertLicense));
        System.out.println(driverService.delete(merlin.getId()));
        driverService.getAll().forEach(System.out::println);

        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer ford = manufacturerService.create(new Manufacturer("Ford", "USA"));
        Manufacturer bmw = manufacturerService.create(new Manufacturer("BMW", "Germany"));
        Manufacturer bogdan = manufacturerService.create(new Manufacturer("Bogdan", "Ukraine"));
        Manufacturer updateBmw = new Manufacturer(bmw.getId(), bmw.getName(), "Poland");
        System.out.println(manufacturerService.update(updateBmw));
        System.out.println(manufacturerService.delete(ford.getId()));
        manufacturerService.getAll().forEach(System.out::println);
    }
}
