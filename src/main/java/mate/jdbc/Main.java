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
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);

        Manufacturer manufacturer1 = new Manufacturer();
        manufacturer1.setName("Toyota");
        manufacturer1.setCountry("Japan");
        Manufacturer manufacturer1Ret = manufacturerService.create(manufacturer1);
        System.out.println(manufacturer1Ret);

        Manufacturer manufacturer = manufacturerService.get(11L);
        System.out.println(manufacturer);

        Manufacturer manufacturer13 = new Manufacturer(13L, "Mercedes", "Germany");
        System.out.println(manufacturerService.update(manufacturer13));

        System.out.println(manufacturerService.delete(11L));
        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        Driver driver1 = new Driver();
        driver1.setName("Andrew Walkman");
        driver1.setLicenseNumber("D3783938292");
        Driver driver1Ret = driverService.create(driver1);
        System.out.println(driver1Ret);

        Driver driver = driverService.get(1L);
        System.out.println(driver);

        Driver driver11 = new Driver(1L, "John 1", "D1111");
        System.out.println(driverService.update(driver11));

        System.out.println(driverService.delete(5L));

        List<Driver> allDrivers = driverService.getAll();
        allDrivers.forEach(System.out::println);

    }
}
