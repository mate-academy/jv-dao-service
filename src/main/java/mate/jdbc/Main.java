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
        Driver driver1 = new Driver("Bob", "123456");
        Driver driver2 = new Driver("Alice", "654321");
        Driver driver3 = new Driver("John", "123654");
        driverService.create(driver2);
        driverService.create(driver3);
        driverService.create(driver1);
        driverService.update(new Driver(1L, "Patricia", "918273"));
        driverService.delete(2L);
        System.out.println(driverService.get(1L));
        driverService.getAll().forEach(System.out::println);
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer1 = new Manufacturer("Audi", "Germany");
        Manufacturer manufacturer2 = new Manufacturer("Daewoo", "Ukraine");
        Manufacturer manufacturer3 = new Manufacturer("KIA", "South Korea");
        manufacturerService.create(manufacturer1);
        manufacturerService.create(manufacturer2);
        manufacturerService.create(manufacturer3);
        manufacturerService.update(new Manufacturer(1L,"Rolls Royce", "UK"));
        manufacturerService.delete(2L);
        System.out.println(manufacturerService.get(1L));
        manufacturerService.getAll().forEach(System.out::println);
    }
}
