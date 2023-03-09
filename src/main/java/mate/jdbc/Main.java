package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driverJohn = new Driver("John", "12345");
        Driver driverJimmy = new Driver("Jimmy", "67890");
        driverService.create(driverJohn);
        driverService.create(driverJimmy);
        System.out.println(driverService.get(driverJimmy.getId()) + "\n");
        driverService.delete(driverJohn.getId());
        driverJimmy.setLicenseNumber("10000");
        driverService.update(driverJimmy);
        driverService.getAll().forEach(System.out::println);

        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        Manufacturer mercedes = new Manufacturer("Mercedes", "Germany");
        Manufacturer ford = new Manufacturer("Ford", "USA");
        manufacturerService.create(mercedes);
        manufacturerService.create(ford);
        System.out.println(manufacturerService.get(ford.getId()) + "\n");
        manufacturerService.delete(ford.getId());
        mercedes.setName("BMW");
        manufacturerService.update(mercedes);
        manufacturerService.getAll().forEach(System.out::println);
    }
}
