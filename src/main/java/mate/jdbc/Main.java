package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverDaoService;
import mate.jdbc.service.ManufactureDaoService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final ManufactureDaoService manufactureDaoService = (ManufactureDaoService)
            injector.getInstance(ManufactureDaoService.class);
    private static final DriverDaoService driverDaoService = (DriverDaoService)
            injector.getInstance(DriverDaoService.class);

    public static void main(String[] args) {
        Manufacturer nike = new Manufacturer();
        nike.setName("Nike");
        nike.setCountry("USA");

        Manufacturer adidas = new Manufacturer();
        adidas.setName("Adidas");
        adidas.setCountry("Island");

        Manufacturer puma = new Manufacturer();
        puma.setName("Puma");
        puma.setCountry("England");

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
