package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);

        System.out.println("DriverService test:\nCreate method tests:");
        Driver firstDriver = new Driver("Samuel", "40395");
        System.out.println(driverService.create(firstDriver));
        Driver secondDriver = new Driver("BOGDAN", "666666");
        System.out.println(driverService.create(secondDriver));
        Driver thirdDriver = new Driver("Speedy", "123456");
        System.out.println(driverService.create(thirdDriver));

        System.out.println("\nUpdate / delete / get methods tests:");
        System.out.println(driverService.update(secondDriver));
        System.out.println(driverService.delete(thirdDriver.getId()));
        System.out.println(driverService.get(firstDriver.getId()));

        System.out.println("\nGetAll method test:");
        System.out.println(driverService.getAll());

        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);

        System.out.println("\nManufacturerService test:\nCreate method tests:");
        Manufacturer firstManufacturer = new Manufacturer("Audi", "Germany");
        System.out.println(manufacturerService.create(firstManufacturer));
        Manufacturer secondManufacturer = new Manufacturer("BMW", "Germany");
        System.out.println(manufacturerService.create(secondManufacturer));
        Manufacturer thirdManufacturer = new Manufacturer("Ford", "USA");
        System.out.println(manufacturerService.create(thirdManufacturer));

        System.out.println("\nUpdate / delete / get methods tests:");
        System.out.println(manufacturerService.update(secondManufacturer));
        System.out.println(manufacturerService.delete(thirdDriver.getId()));
        System.out.println(manufacturerService.get(firstManufacturer.getId()));

        System.out.println("\nGetAll method test:");
        System.out.println(manufacturerService.getAll());
    }
}
