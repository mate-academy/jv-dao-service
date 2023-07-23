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
        driverService.getAll().forEach(System.out::println);
        Driver driverIlya = new Driver();
        driverIlya.setName("Ilya");
        driverIlya.setLicenseNumber("789654");
        System.out.println(driverService.create(driverIlya));

        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        manufacturerService.getAll().forEach(System.out::println);
        Manufacturer manufacturerVolvo = new Manufacturer();
        manufacturerVolvo.setName("Volvo");
        manufacturerVolvo.setCountry("Switzerland");
        System.out.println(manufacturerService.create(manufacturerVolvo));
    }
}
