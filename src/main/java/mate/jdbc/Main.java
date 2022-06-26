package mate.jdbc;

import mate.jdbc.dao.DriverDao;
import mate.jdbc.dao.ManufacturerDao;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc.dao");

    public static void main(String[] args) {
        DriverDao driverDao = (DriverDao) injector.getInstance(DriverDao.class);
        Driver max = new Driver("mad Max", "no_license_never_was");
        Driver alonso = new Driver("Fernando", "McLaren#666");
        max = driverDao.create(max);
        alonso = driverDao.create(alonso);
        driverDao.getAll().forEach(System.out::println);
        alonso.setLicenseNumber("renault#777");
        driverDao.update(alonso);
        System.out.println(driverDao.get(alonso.getId()).get());
        driverDao.delete(max.getId());
        driverDao.getAll().forEach(System.out::println);

        ManufacturerDao manufacturerDao = (ManufacturerDao) injector
                .getInstance(ManufacturerDao.class);
        Manufacturer mcLaren = new Manufacturer("Bruce McLaren Motor Racing Ltd", "UK");
        Manufacturer redBull = new Manufacturer("Red Bull GmbH", "Austria");
        mcLaren = manufacturerDao.create(mcLaren);
        redBull = manufacturerDao.create(redBull);
        manufacturerDao.getAll().forEach(System.out::println);
        mcLaren.setName("McLaren Technology Group");
        manufacturerDao.update(mcLaren);
        System.out.println(manufacturerDao.get(mcLaren.getId()).get());
        manufacturerDao.delete(redBull.getId());
        manufacturerDao.getAll().forEach(System.out::println);
    }
}
