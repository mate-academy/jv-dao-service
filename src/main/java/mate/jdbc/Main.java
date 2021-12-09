package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import service.DriverService;
import service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer volkswagen = manufacturerService
                .create(new Manufacturer("Volkswagen", "Germany"));
        Manufacturer skoda = manufacturerService
                .create(new Manufacturer("Skoda", "Czech Republic"));
        Manufacturer hyundai = manufacturerService
                .create(new Manufacturer("Hyundai", "Republic of Korea"));
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println(manufacturerService.delete(volkswagen.getId()));
        hyundai.setCountry("Korea");
        manufacturerService.update(hyundai);
        System.out.println(manufacturerService.get(hyundai.getId()));

        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver aleks = driverService.create(new Driver("Aleks", "DK012345D"));
        Driver sergey = driverService.create(new Driver("Sergey", "AA54321D"));
        Driver boris = driverService.create(new Driver("Boris", "BS56789B"));
        driverService.getAll().forEach(System.out::println);
        System.out.println(driverService.delete(sergey.getId()));
        aleks.setName("Aleksandr");
        driverService.update(aleks);
        System.out.println(driverService.get(aleks.getId()));
    }
}
