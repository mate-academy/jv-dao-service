package mate.jdbc;

import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;
import mate.jdbc.util.Injector;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer firstCar = new Manufacturer("Toyota", "Japan");
        Manufacturer secondCar = new Manufacturer("KIA", "Korea");
        manufacturerService.create(firstCar);
        manufacturerService.create(secondCar);
        firstCar.setName("Ford");
        manufacturerService.update(firstCar);
        manufacturerService.delete(firstCar.getId());
        manufacturerService.getAll().forEach(System.out::println);
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver firstDriver = new Driver("Poll", "542112");
        Driver secondDriver = new Driver("John", "625423");
        driverService.create(firstDriver);
        driverService.create(secondDriver);
        firstDriver.setName("Alice");
        driverService.update(firstDriver);
        driverService.delete(secondDriver.getId());
        driverService.getAll().forEach(System.out::println);
    }
}
