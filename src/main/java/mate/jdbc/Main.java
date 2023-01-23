package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        Driver driverOne = new Driver("Shinyo Nakano", "NO467386");
        Driver driverTwo = new Driver("Tetsuya Harada", "SK867442");
        driverService.create(driverOne);
        driverService.create(driverTwo);
        List<Driver> drivers = driverService.getAll();
        System.out.println(drivers);
        System.out.println(driverService.get(1L));
        Driver driverThree = driverService
                .update(new Driver(1L,"Valentino Rossi", "KV573988"));
        driverService.delete(1L);
        System.out.println(driverService.getAll());

        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturerOne = new Manufacturer("DeLorean DMC-12, 1981", "USA");
        Manufacturer manufacturerTwo = new Manufacturer("Nissan Leopard, 1980", "Japan");
        manufacturerService.create(manufacturerOne);
        manufacturerService.create(manufacturerTwo);
        List<Manufacturer> manufacturers = manufacturerService.getAll();
        System.out.println(manufacturers);
        System.out.println(manufacturerService.get(1L));
        Manufacturer manufacturerThree = manufacturerService
                .update(new Manufacturer(1L,"Mercedes-Benz 126, 1987", "Germany"));
        manufacturerService.delete(2L);
        System.out.println(manufacturerService.getAll());
    }
}
