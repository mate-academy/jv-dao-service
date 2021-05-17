package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    public static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        Manufacturer samsung = new Manufacturer("Samsung", "Korea");
        manufacturerService.create(samsung);
        Manufacturer apple = new Manufacturer("Apple", "USA");
        manufacturerService.create(apple);
        Manufacturer xiaomi = new Manufacturer("Xiaomi", "China");
        manufacturerService.create(xiaomi);

        Manufacturer manufacturerFromDb = manufacturerService.get(apple.getId());
        System.out.println(manufacturerFromDb);
        samsung.setName("Samsung Electronics");
        manufacturerService.update(samsung);
        manufacturerService.delete(xiaomi.getId());
        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver petro = new Driver("Petro", "1234");
        driverService.create(petro);
        Driver ivan = new Driver("Ivan", "6666");
        driverService.create(ivan);
        Driver yarik = new Driver("Yarik", "9876");
        driverService.create(yarik);

        Driver driverFromDb = driverService.get(ivan.getId());
        System.out.println(driverFromDb);
        yarik.setLicenseNumber("4545");
        driverService.update(yarik);
        driverService.delete(petro.getId());
        List<Driver> drivers = driverService.getAll();
        drivers.forEach(System.out::println);
    }
}
