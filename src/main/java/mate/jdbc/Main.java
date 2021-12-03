package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);

        Driver driver1 = new Driver("Yurii", "1234");
        Driver driver2 = new Driver("Dany..", "5678");

        driverService.create(driver1);
        driverService.create(driver2);
        System.out.println(driverService.getAll());
        driver1.setName("NewYurii");
        driver1.setLicenseNumber("5678");
        driverService.update(driver1);
        driverService.delete(2L);
        System.out.println("After updates: " + driverService.getAll());

        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer goodCar = new Manufacturer("Very good car", "Japan");
        manufacturerService.create(goodCar);
        Manufacturer regularCar = new Manufacturer("Regular", "Italy");
        manufacturerService.create(goodCar);
        Manufacturer thirdCar = new Manufacturer("Another good car", "Japan");
        manufacturerService.delete(2L);
        goodCar.setCountry("Armenia");
        manufacturerService.update(goodCar);
        System.out.println(manufacturerService.getAll());
    }
}
