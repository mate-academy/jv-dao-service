package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);

        Manufacturer manufacturerTesla = new Manufacturer("Tesla", "USA");
        manufacturerService.create(manufacturerTesla);
        Manufacturer manufacturerKia = new Manufacturer("Kia", "Korea");
        manufacturerService.create(manufacturerKia);
        Manufacturer manufacturerDS = new Manufacturer("Citroen", "France");
        manufacturerService.create(manufacturerDS);
        manufacturerService.getAll().forEach(System.out::println);

        System.out.println(manufacturerService.get(manufacturerTesla.getId()));
        manufacturerDS.setName("DS");
        manufacturerService.update(manufacturerDS);
        manufacturerService.delete(manufacturerKia.getId());
        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);

        Driver driverOscar = new Driver("Oscar", "1ldlvik3");
        driverService.create(driverOscar);
        Driver driverSanta = new Driver("Santa", "ldk4mc6p");
        driverService.create(driverSanta);
        Driver driverKevin = new Driver("Kevin", "tandkf86");
        driverService.create(driverKevin);
        driverService.getAll().forEach(System.out::println);

        System.out.println(driverService.get(driverSanta.getId()));
        driverOscar.setName("Oscarino");
        driverService.update(driverOscar);
        driverService.delete(driverKevin.getId());
        driverService.getAll().forEach(System.out::println);

    }
}
