package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    public static void main(String[] args) {
        Injector injector = Injector.getInstance("mate.jdbc");
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver driverBob = driverService.create(
                new Driver("Bob", "123456"));
        Driver driverAlice = driverService.create(
                new Driver("Alice", "654321"));
        Driver driverJohn = driverService.create(
                new Driver("John", "123654"));
        driverService.update(
                new Driver(driverBob.getId(), "Patricia", "918273"));
        driverService.delete(driverAlice.getId());
        System.out.println(driverService.get(driverBob.getId()));
        driverService.getAll().forEach(System.out::println);
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturerAudi = manufacturerService.create(
                new Manufacturer("Audi", "Germany"));
        Manufacturer manufacturerDaewoo = manufacturerService.create(
                new Manufacturer("Daewoo", "Ukraine"));
        Manufacturer manufacturerKia = manufacturerService.create(
                new Manufacturer("KIA", "South Korea"));
        manufacturerService.update(
                new Manufacturer(manufacturerAudi.getId(), "Rolls Royce", "UK"));
        manufacturerService.delete(manufacturerDaewoo.getId());
        System.out.println(manufacturerService.get(manufacturerAudi.getId()));
        manufacturerService.getAll().forEach(System.out::println);
    }
}
