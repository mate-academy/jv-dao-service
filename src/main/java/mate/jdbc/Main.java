package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Manufacturer bmw = new Manufacturer("BMW", "Germany");
        Manufacturer toyota = new Manufacturer("Toyota", "Japan");
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        System.out.println(manufacturerService.create(bmw));
        System.out.println(manufacturerService.create(toyota));
        System.out.println(manufacturerService.get(1L));
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println(manufacturerService.update(
                new Manufacturer(1L, "KIA", "Korea")));
        System.out.println(manufacturerService.delete(1L));
        System.out.println("-------------------------------");
        Driver ivan = new Driver("Ivan", "AA7777XA");
        Driver petro = new Driver("Petro", "BC1715CE");
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        System.out.println(driverService.create(ivan));
        System.out.println(driverService.create(petro));
        System.out.println(driverService.get(1L));
        driverService.getAll().forEach(System.out::println);
        System.out.println(driverService.update(
                new Driver(1L, "Oleg", "AO2121CD")));
        System.out.println(driverService.delete(1L));
    }
}
