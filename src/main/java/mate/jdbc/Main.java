package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        Manufacturer bmwGermany = new Manufacturer("BMW", "Germany");
        Manufacturer skodaCzech = new Manufacturer("Skoda", "Czech");
        manufacturerService.create(bmwGermany);
        manufacturerService.create(skodaCzech);
        manufacturerService.getAll().forEach(System.out::println);
        bmwGermany.setCountry("Ukraine");
        manufacturerService.update(bmwGermany);
        System.out.println("-=-=-=-");
        System.out.println(manufacturerService.get(bmwGermany.getId()));
        System.out.println(manufacturerService.delete(bmwGermany.getId()));

        System.out.println("-=-=-=-");

        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);
        Driver bobBobenko = new Driver("Bob", "a-0001");
        Driver aliceAlicenko = new Driver("Alice", "a-0002");
        driverService.create(bobBobenko);
        driverService.create(aliceAlicenko);
        driverService.getAll().forEach(System.out::println);
        bobBobenko.setName("Bob Bobenko");
        driverService.update(bobBobenko);
        System.out.println("-=-=-=-");
        System.out.println(driverService.get(bobBobenko.getId()));
        System.out.println(driverService.delete(aliceAlicenko.getId()));
    }
}
