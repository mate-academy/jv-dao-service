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
        System.out.println(driverService.get(driverOne.getId()));
        Driver driverThree = driverService
                .update(new Driver(driverOne.getId(),"Valentino Rossi", "KV573988"));
        driverService.delete(driverOne.getId());
        System.out.println(driverService.getAll());

        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturerOne = new Manufacturer("DeLorean DMC-12, 1981", "USA");
        Manufacturer manufacturerTwo = new Manufacturer("Nissan Leopard, 1980", "Japan");
        manufacturerService.create(manufacturerOne);
        manufacturerService.create(manufacturerTwo);
        List<Manufacturer> manufacturers = manufacturerService.getAll();
        System.out.println(manufacturers);
        System.out.println(manufacturerService.get(manufacturerOne.getId()));
        Manufacturer manufacturerThree = manufacturerService
                .update(new Manufacturer(manufacturerOne.getId(),
                        "Mercedes-Benz 126, 1987", "Germany"));
        manufacturerService.delete(manufacturerOne.getId());
        System.out.println(manufacturerService.getAll());
    }
}
