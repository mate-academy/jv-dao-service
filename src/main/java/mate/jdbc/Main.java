package mate.jdbc;

import java.util.List;
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

        List<Driver> drivers = List.of(
                new Driver("Igor", "fe0077"),
                new Driver("Vasyl", "dv6666"),
                new Driver("Ivan", "ch1234"),
                new Driver("Stepan", "ys7412"));

        drivers.forEach(driverService::create);
        Driver driverPavlo = new Driver("Pavlo", "pm1234");
        driverService.create(driverPavlo);
        driverPavlo.setLicenseNumber("aa0000");
        driverService.update(driverPavlo);
        driverService.delete(2L);
        driverService.getAll().forEach(System.out::println);

        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);

        List<Manufacturer> manufacturers = List.of(
                new Manufacturer("Opel", "Germany"),
                new Manufacturer("Ford", "USA"),
                new Manufacturer("KIA", "China"));

        manufacturers.forEach(manufacturerService::create);
        Manufacturer manufacturerSubaru = new Manufacturer("Subaru", "Japan");
        manufacturerService.create(manufacturerSubaru);
        manufacturerSubaru.setCountry("Ukraine");
        manufacturerService.update(manufacturerSubaru);
        manufacturerService.delete(1L);
        manufacturerService.delete(4L);
        manufacturerService.getAll().forEach(System.out::println);
    }
}
