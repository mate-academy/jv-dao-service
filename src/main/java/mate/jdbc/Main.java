package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufactureService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final ManufactureService manufactureDaoService = (ManufactureService)
            injector.getInstance(ManufactureService.class);
    private static final DriverService driverDaoService = (DriverService)
            injector.getInstance(DriverService.class);

    public static void main(String[] args) {
        Manufacturer nike = new Manufacturer("Nike","USA");

        Manufacturer adidas = new Manufacturer("Adidas","Island");

        Manufacturer puma = new Manufacturer("Puma", "England");

        manufactureDaoService.create(nike);
        manufactureDaoService.create(adidas);
        manufactureDaoService.create(puma);

        System.out.println(manufactureDaoService.get(nike.getId()));

        manufactureDaoService.getAll().forEach(System.out::println);

        puma.setCountry("Iran");
        manufactureDaoService.update(puma);

        manufactureDaoService.delete(adidas.getId());

        Driver bob = new Driver("Bob","12121");
        Driver peter = new Driver("Peter-Pi","3.141592");
        Driver lucky = new Driver("Lucky","777");

        driverDaoService.create(bob);
        driverDaoService.create(peter);
        driverDaoService.create(lucky);

        System.out.println(manufactureDaoService.get(peter.getId()));

        driverDaoService.getAll().forEach(System.out::println);

        bob.setLicenseNumber("ll-893");
        driverDaoService.update(bob);

        driverDaoService.delete(lucky.getId());
    }
}
