package mate.jdbc;

import mate.jdbc.dao.DriverDao;
import mate.jdbc.dao.ManufacturerDao;
import mate.jdbc.dao.impl.DriverDaoImpl;
import mate.jdbc.dao.impl.ManufacturerDaoImpl;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        ManufacturerDao manufacturerDao = new ManufacturerDaoImpl();
        System.out.println(manufacturerDao.get(1L).get());
        manufacturerDao.create(new Manufacturer("Fiat", "Italian"));
        manufacturerDao.update(new Manufacturer(2L,"Audi", "Germany"));
        manufacturerDao.delete(14L);
        manufacturerDao.getAll().forEach(System.out::println);

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        DriverDao driverDao = new DriverDaoImpl();
        System.out.println(driverDao.get(1L).get());
        driverDao.create(new Driver("Tom", 245689L));
        driverDao.update(new Driver(3L,"Sofia", 256321L));
        driverDao.delete(3L);
        driverDao.getAll().forEach(System.out::println);

        driverDao.getAll().forEach(System.out::println);

    }
}
