package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector myInject = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        // test your code here
        final DriverService driverService = (DriverService)
                myInject.getInstance(DriverService.class);
        final ManufacturerService manufacturerService = (ManufacturerService)
                myInject.getInstance(ManufacturerService.class);

        final Manufacturer.Builder germanManufacturer =
                new Manufacturer.Builder().setCountry("Germany");
        final Manufacturer.Builder franceManufacturer =
                new Manufacturer.Builder().setCountry("France");
        final Manufacturer.Builder japanManufacturer =
                new Manufacturer.Builder().setCountry("Japan");

        manufacturerService.create(germanManufacturer.setName("Opel").build());
        manufacturerService.create(franceManufacturer.setName("Renault").build());
        List<Manufacturer> manufacturers = manufacturerService.getAll();
        manufacturers.forEach(System.out::println);
        manufacturerService.delete(1L);
        manufacturerService.update(japanManufacturer.setId(2L).setName("Nissan").build());
        System.out.println(manufacturerService.get(1L));
        System.out.println(manufacturerService.get(2L));

        Driver.Builder driverBuilder = new Driver.Builder();
        driverService.create(driverBuilder.setName("Vasil").setLicenseNumber("2317245").build());
        driverService.create(driverBuilder.setName("Kolya").setLicenseNumber("6243121").build());
        List<Driver> drivers = driverService.getAll();
        drivers.forEach(System.out::println);
        driverService.delete(2L);
        driverService.update(driverBuilder
                .setId(1L).setName("Victor").setLicenseNumber("54654454").build());
        System.out.println(driverService.get(1L));
        System.out.println(driverService.get(2L));
    }
}
