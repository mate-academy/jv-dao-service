package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector INJECTOR = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {

        ManufacturerService manufacturerService = (ManufacturerService) INJECTOR
                .getInstance(ManufacturerService.class);
        System.out.println("All manufacturers :");
        manufacturerService.getAll().forEach(System.out::println);
        Manufacturer manufacturerCreate = manufacturerService
                .create(new Manufacturer("bilson","German"));
        System.out.println("Get created  where manufacturer id = " + manufacturerCreate.getId());
        System.out.println(manufacturerService.get(manufacturerCreate.getId()));
        System.out.println("Get manufacture where id = " + manufacturerCreate.getId());
        System.out.println(manufacturerService.get(manufacturerCreate.getId()));
        manufacturerService.delete(manufacturerCreate.getId());
        System.out.println("All manufacturers after delete:");
        manufacturerService.getAll().forEach(System.out::println);
        DriverService driverService = (DriverService) INJECTOR.getInstance(DriverService.class);
        System.out.println("All drivers :");
        driverService.getAll().forEach(System.out::println);
        Driver driverCreate = driverService.create(new Driver("Bober","German"));
        System.out.println("Get created  where driver id = " + driverCreate.getId());
        System.out.println(driverService.get(driverCreate.getId()));
        System.out.println("Get driver where id = 1");
        System.out.println(driverService.get(driverCreate.getId()));
        driverService.delete(driverCreate.getId());
        System.out.println("All drivers after delete:");
        driverService.getAll().forEach(System.out::println);
    }
}
