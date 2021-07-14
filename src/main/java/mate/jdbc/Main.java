package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final DriverService driverService =
            (DriverService) injector.getInstance(DriverService.class);
    private static final ManufacturerService manufacturerService =
            (ManufacturerService) injector.getInstance(ManufacturerService.class);

    public static void main(String[] args) {
        Manufacturer toyotaCar = new Manufacturer("toyota", "Germany");
        Manufacturer bmwCar = new Manufacturer("bmw", "Germany");

        System.out.println(manufacturerService.create(toyotaCar));
        System.out.println(manufacturerService.create(bmwCar));

        toyotaCar.setCountry("Ukraine");
        System.out.println(manufacturerService.update(toyotaCar));
        System.out.println(manufacturerService.delete(bmwCar.getId()));
        System.out.println(manufacturerService.get(toyotaCar.getId()));

        manufacturerService.getAll().forEach(System.out::println);

        Driver olegDriver = new Driver("Oleg", "123456");
        Driver bogdanDriver = new Driver("Bogdan", "456789");

        System.out.println(driverService.create(olegDriver));
        System.out.println(driverService.create(bogdanDriver));

        System.out.println(driverService.get(bogdanDriver.getId()));
        System.out.println(driverService.delete(olegDriver.getId()));

        driverService.getAll().forEach(System.out::println);
    }
}
