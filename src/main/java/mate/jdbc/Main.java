package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);

        Manufacturer bmw = new Manufacturer(null, "BMW", "Germany");
        Manufacturer audi = new Manufacturer(null, "Audi", "Ukraine");
        Manufacturer mercedes = new Manufacturer(null, "Mercedes", "Germany");

        manufacturerService.create(bmw);
        manufacturerService.create(audi);
        manufacturerService.create(mercedes);
        manufacturerService.getAll().forEach(System.out::println);

        audi.setCountry("Germany");
        manufacturerService.update(audi);
        System.out.println(manufacturerService.get(audi.getId()));
        manufacturerService.getAll().forEach(System.out::println);

        manufacturerService.delete(audi.getId());
        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        Driver ilya = new Driver(null, "Ilya", "AA 123456");
        Driver igor = new Driver(null, "Igor", "AA 246890");
        Driver andrey = new Driver(null, "Andrey", "VI 086412");

        driverService.create(ilya);
        driverService.create(igor);
        driverService.create(andrey);
        driverService.getAll().forEach(System.out::println);

        ilya.setLicenseNumber("AA 052812");

        driverService.update(ilya);
        System.out.println(driverService.get(ilya.getId()));
        driverService.getAll().forEach(System.out::println);

        driverService.delete(andrey.getId());
        driverService.getAll().forEach(System.out::println);
    }
}
