package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);

        Manufacturer tempManufacturer = new Manufacturer("Kia", "South Korea");
        Manufacturer toyota = new Manufacturer("Toyota", "Japan");
        manufacturerService.create(tempManufacturer);
        manufacturerService.create(toyota);
        tempManufacturer.setName("BMW");
        tempManufacturer.setCountry("Germany");
        manufacturerService.update(tempManufacturer);
        System.out.println(manufacturerService.get(tempManufacturer.getId()));
        manufacturerService.delete(tempManufacturer.getId());
        System.out.println(manufacturerService.getAll());

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver tempDriver = new Driver("Ihor", "11111");
        Driver artur = new Driver("Artur", "11112");
        driverService.create(tempDriver);
        tempDriver.setName("Nikita");
        tempDriver.setLicenseNumber("11113");
        driverService.update(tempDriver);
        System.out.println(driverService.get(tempDriver.getId()));
        driverService.delete(tempDriver.getId());
        System.out.println(driverService.getAll());
    }
}
