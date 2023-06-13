package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    public static void main(String[] args) {
        Injector injector = Injector.getInstance("mate.jdbc");
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);

        Manufacturer porshe = new Manufacturer("Porshe", "Italy");
        Manufacturer ford = new Manufacturer("Ford", "USA");
        System.out.println(manufacturerService.create(porshe));
        System.out.println(manufacturerService.create(ford));
        System.out.println(manufacturerService.create(porshe));
        System.out.println(manufacturerService.get(porshe.getId()));
        System.out.println(manufacturerService.delete(porshe.getId()));
        System.out.println(manufacturerService.update(new Manufacturer(2L,"Toyota","Korea")));

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        Driver dilan = new Driver("Dilan", "DL00923");
        Driver alice = new Driver("Alice", "DL00211");
        System.out.println(driverService.create(dilan));
        System.out.println(driverService.create(alice));
        System.out.println(driverService.get(dilan.getId()));
        System.out.println(driverService.delete(alice.getId()));
        System.out.println(driverService.update(new Driver(2L,"Billy","DL00001")));
        driverService.getAll().forEach(System.out::println);
    }
}
