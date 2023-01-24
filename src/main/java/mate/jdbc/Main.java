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

        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        List<Manufacturer> manufacturerList = List.of(
                new Manufacturer("Dodge", "USA"),
                new Manufacturer("Ford", "USA"),
                new Manufacturer("Subaru", "Japan"),
                new Manufacturer("Audi", "German")
        );
        Manufacturer manufacturerToAdd = new Manufacturer("Fiat", "France");
        manufacturerList.forEach(manufacturerService::create);
        manufacturerService.create(manufacturerToAdd);
        manufacturerService.update(manufacturerToAdd);
        manufacturerService.get(manufacturerList.get(1).getId());
        manufacturerService.delete(manufacturerList.get(0).getId());
        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        List<Driver> driverList = List.of(
                new Driver("Vasiliy", "АХ3123ВС"),
                new Driver("Petya", "АХ5123СВ"),
                new Driver("Misha", "АН1821ВС"),
                new Driver("Vladislav", "КХ7777КХ")
        );
        Driver driverToAdd = new Driver("Taras", "АХ4123НВ");
        driverList.forEach(driverService::create);
        driverService.create(driverToAdd);
        driverService.update(driverToAdd);
        driverService.get(driverList.get(1).getId());
        driverService.delete(driverList.get(0).getId());
        driverService.getAll().forEach(System.out::println);
    }
}
