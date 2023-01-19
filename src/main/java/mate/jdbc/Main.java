package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver mykyta = new Driver();
        mykyta.setName("Mykyta");
        mykyta.setLicenseNumber("1111");
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        driverService.create(mykyta);
        System.out.println("Get all drivers from drivers table"
                + driverService.getAll());
        System.out.println("Get driver with id = 1 from drivers table "
                + driverService.get(mykyta.getId()));
        mykyta.setLicenseNumber("2222");
        driverService.update(mykyta);
        System.out.println("Deleting driver with id = 5 from drivers table"
                + driverService.delete(mykyta.getId()));
        driverService.getAll().forEach(System.out::println);

        Manufacturer honda = new Manufacturer();
        honda.setName("Honda");
        honda.setCountry("China");
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        manufacturerService.create(honda);
        honda.setCountry("Japan");
        manufacturerService.update(honda);
        System.out.println("Getting manufacturer Ford "
                + manufacturerService.get(honda.getId()));
        manufacturerService.delete(honda.getId());
        manufacturerService.getAll().forEach(System.out::println);
    }
}
