package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        final DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        final ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);

        Manufacturer firstManufacturer = new Manufacturer("first", "firstCountry");
        Manufacturer secondManufacturer = new Manufacturer("second", "secondCountry");
        manufacturerService.create(firstManufacturer);
        manufacturerService.create(secondManufacturer);
        System.out.println(manufacturerService.getAll());
        firstManufacturer.setName("noFirst");
        manufacturerService.update(firstManufacturer);
        System.out.println(manufacturerService.getAll());
        manufacturerService.delete(1L);
        System.out.println(manufacturerService.getAll());

        Driver firstDriver = new Driver("first", "firstNumber");
        Driver secondDriver = new Driver("second", "secondNumber");
        driverService.create(firstDriver);
        driverService.create(secondDriver);
        System.out.println(driverService.getAll());
        firstDriver.setName("noFirst");
        driverService.update(firstDriver);
        System.out.println(driverService.getAll());
        driverService.delete(1L);
        System.out.println(driverService.getAll());

    }
}
