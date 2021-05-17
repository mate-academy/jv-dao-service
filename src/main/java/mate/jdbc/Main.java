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
        Driver driverTaras = new Driver("Taras","13424");
        Driver driverOleg = new Driver("Oleg","45729");
        System.out.println(driverService.create(driverOleg));
        System.out.println(driverService.create(driverTaras));
        System.out.println(driverService.get(driverOleg.getId()));
        System.out.println(driverService.delete(driverTaras.getId()));
        driverOleg.setName("Andriy");
        System.out.println(driverService.update(driverOleg));
        System.out.println(driverService.getAll());

        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer apple = new Manufacturer("Apple", "USA");
        Manufacturer xiaomi = new Manufacturer("Xiaomi", "China");
        Manufacturer samsung = new Manufacturer("Samsung", "Korea;");
        System.out.println(manufacturerService.create(apple));
        System.out.println(manufacturerService.create(xiaomi));
        System.out.println(manufacturerService.create(samsung));
        System.out.println(manufacturerService.get(apple.getId()));
        System.out.println(manufacturerService.delete(xiaomi.getId()));
        apple.setName("Yabko");
        System.out.println(manufacturerService.update(apple));
        System.out.println(manufacturerService.getAll());
    }
}
