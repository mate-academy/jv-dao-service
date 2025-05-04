package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector
            = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        final ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        final DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Manufacturer ford = new Manufacturer();
        ford.setName("FORD");
        ford.setCountry("USA");
        manufacturerService.create(ford);
        Manufacturer audi = new Manufacturer();
        audi.setName("AUDI");
        audi.setCountry("Germany");
        manufacturerService.create(audi);
        Driver driverFord = new Driver();
        driverFord.setName("Yura");
        driverFord.setLicenseNumber("12345");
        driverService.create(driverFord);
        Driver driverAudi = new Driver();
        driverAudi.setName("Nadia");
        driverAudi.setLicenseNumber("56789");
        driverService.create(driverAudi);
        driverService.delete(2L);
        manufacturerService.delete(1L);
        driverAudi.setId(4L);
        driverAudi.setName("BMW");
        driverAudi.setLicenseNumber("23456");
        driverService.update(driverAudi);
        Driver driverHonda = new Driver(5L, "Igor", "54321");
        driverService.update(driverHonda);
        driverService.getAll().forEach(System.out::println);
    }
}
