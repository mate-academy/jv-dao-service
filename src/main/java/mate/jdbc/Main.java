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
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);

        Manufacturer zaz = manufacturerService.create(new Manufacturer("Zaz", "Ukraine"));
        Manufacturer dacia = manufacturerService.create(new Manufacturer("Dacia", "Romania"));
        Manufacturer seat = manufacturerService.create(new Manufacturer("Seat", "Spain"));

        Driver joey = driverService.create(new Driver("Joey", "КАІ 12345"));
        Driver ross = driverService.create(new Driver("Ross", "ГЕН 23456"));
        Driver chandler = driverService.create(new Driver("Chandler", "ПАТ 34567"));
        Driver monica = driverService.create(new Driver("Monica", "ТОВ 45678"));

        System.out.println(manufacturerService.update(zaz));
        System.out.println(manufacturerService.get(dacia.getId()));
        System.out.println(manufacturerService.delete(seat.getId()));
        System.out.println(manufacturerService.getAll());

        System.out.println(driverService.update(joey));
        System.out.println(driverService.get(ross.getId()));
        System.out.println(driverService.delete(chandler.getId()));
        System.out.println(driverService.getAll());
    }
}
