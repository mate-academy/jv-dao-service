package mate.jdbc;

import mate.jdbc.dao.DriverDao;
import mate.jdbc.dao.ManufacturerDao;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;

public class Main {
    private static Injector injector = Injector.getInstance("mate");

    public static void main(String[] args) {
        DriverDao driverDao = (DriverDao) injector.getInstance(DriverDao.class);
        Driver driver = new Driver("Statik", "BEe");
        driverDao.create(driver);
        driver.setName("Stas");
        driverDao.update(driver);
        driverDao.delete(1L);
        driverDao.getAll().forEach(System.out::println);
        ManufacturerDao manufacturerDao =
                (ManufacturerDao) injector
                        .getInstance(ManufacturerDao.class);
        Manufacturer manufacturer = new Manufacturer("Alex", "Ukraine");
        manufacturerDao.create(manufacturer);
        driver.setName("Lecha");
        manufacturerDao.update(manufacturer);
        manufacturerDao.delete(1L);
        manufacturerDao.getAll().forEach(System.out::println);
    }
}
