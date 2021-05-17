package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final ManufacturerService manufacturerService =
            (ManufacturerService) injector.getInstance(ManufacturerService.class);
    private static final DriverService driverService =
            (DriverService) injector.getInstance(DriverService.class);

    public static void main(String[] args) {
        Manufacturer siemens = new Manufacturer("Siemens", "Germany");
        Manufacturer toshiba = new Manufacturer("Toshiba", "Japan");
        Manufacturer samsung = new Manufacturer("Samsung", "Korea");

        manufacturerService.create(siemens);
        manufacturerService.create(toshiba);
        manufacturerService.create(samsung);
        System.out.println(manufacturerService.getAll());
        System.out.println(manufacturerService.get(samsung.getId()));

        siemens.setName("Siemens-GMBH");
        samsung.setCountry("South Korea");

        System.out.println(manufacturerService.update(siemens));
        System.out.println(manufacturerService.update(samsung));
        System.out.println(manufacturerService.delete(siemens.getId()));
        System.out.println(manufacturerService.getAll());

        Driver mikaelSchumacher = new Driver("Mikael", "234835");
        Driver ayrtonSenna = new Driver("Ayrton", "137439");
        Driver lewisHamilton = new Driver("Lewis", "830482");

        driverService.create(mikaelSchumacher);
        driverService.create(ayrtonSenna);
        driverService.create(lewisHamilton);
        System.out.println(driverService.getAll());
        System.out.println(driverService.get(ayrtonSenna.getId()));

        mikaelSchumacher.setLicenseNumber("384972");
        lewisHamilton.setName("Lewis-Junior");
        driverService.update(mikaelSchumacher);
        driverService.update(lewisHamilton);
        System.out.println(driverService.getAll());
        System.out.println(driverService.delete(ayrtonSenna.getId()));
        System.out.println(driverService.getAll());
    }
}
