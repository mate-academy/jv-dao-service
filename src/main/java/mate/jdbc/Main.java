package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturerSkechers = new Manufacturer("Skechers", "USA");
        manufacturerService.create(manufacturerSkechers);
        Manufacturer manufacturerBershka = new Manufacturer("Bershka", "Ukraine");
        manufacturerService.create(manufacturerBershka);

        manufacturerBershka.setCountry("Moldova");
        manufacturerService.update(manufacturerBershka);

        manufacturerService.get(manufacturerBershka.getId());
        manufacturerService.delete(manufacturerSkechers.getId());

        manufacturerService.getAll();

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driverIvan = new Driver("Ivan", "1234");
        driverService.create(driverIvan);
        Driver driverSasha = new Driver("Sasha", "5678");
        driverService.create(driverSasha);

        driverSasha.setName("Alexandr");
        driverService.update(driverSasha);

        driverService.get(driverIvan.getId());
        driverService.get(driverSasha.getId());
        driverService.delete(driverIvan.getId());

        driverService.getAll();
    }
}
