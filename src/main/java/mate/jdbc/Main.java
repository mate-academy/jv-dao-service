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

        Manufacturer lexus = new Manufacturer("Lexus", "Japan");
        Manufacturer kia = new Manufacturer("Kia", "North Korea");
        Manufacturer subaru = new Manufacturer("Subaru", "Japan");

        manufacturerService.create(lexus);
        manufacturerService.create(kia);
        manufacturerService.create(subaru);

        manufacturerService.getAll().forEach(System.out::println);

        kia.setCountry("South Korea");
        manufacturerService.update(kia);
        System.out.println(manufacturerService.get(kia.getId()));

        System.out.println(manufacturerService.delete(subaru.getId()));

        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);

        Driver bobby = new Driver("Bobby", "12345");
        Driver alison = new Driver("Alison", "67899");
        Driver jerry = new Driver("Jerry", "00000");

        driverService.create(bobby);
        driverService.create(alison);
        driverService.create(jerry);

        driverService.getAll().forEach(System.out::println);

        alison.setLicenseNumber("67890");
        driverService.update(alison);
        System.out.println(driverService.get(alison.getId()));

        System.out.println(driverService.delete(bobby.getId()));
    }
}
