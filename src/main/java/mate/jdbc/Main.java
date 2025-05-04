package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver vitya = new Driver();
        vitya.setName("Vitya");
        vitya.setLicenseNumber("2121");

        driverService.create(vitya);
        vitya.setName("Viktor");
        vitya.setLicenseNumber("9090");
        driverService.update(vitya);
        System.out.println(driverService.get(vitya.getId()));
        driverService.getAll().forEach(System.out::println);
        System.out.println("deletion successful: " + driverService.delete(vitya.getId()));

        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer bmv = new Manufacturer();
        bmv.setName("Austria");
        bmv.setCountry("Germany");

        manufacturerService.create(bmv);
        bmv.setCountry("Germany");
        manufacturerService.update(bmv);
        System.out.println(manufacturerService.get(bmv.getId()));
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("deletion successful: " + manufacturerService.delete(bmv.getId()));
    }
}
