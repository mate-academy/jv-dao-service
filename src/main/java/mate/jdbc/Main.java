package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver driverBob = new Driver();
        driverBob.setName("Bob");
        driverBob.setLicenseNumber("12345");

        Driver driverBill = new Driver();
        driverBill.setName("Bill");
        driverBill.setLicenseNumber("56789");

        Manufacturer manufacturerBmw = new Manufacturer();
        manufacturerBmw.setName("BMW");
        manufacturerBmw.setCountry("Germany");

        Manufacturer manufacturerFord = new Manufacturer();
        manufacturerFord.setName("Ford");
        manufacturerFord.setCountry("USA");

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);

        driverService.create(driverBob);
        driverService.create(driverBill);
        manufacturerService.create(manufacturerBmw);
        manufacturerService.create(manufacturerFord);

        manufacturerService.getAll().forEach(System.out::println);
        driverService.getAll().forEach(System.out::println);
    }
}
