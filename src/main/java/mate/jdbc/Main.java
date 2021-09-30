package mate.jdbc;

import mate.jdbc.dao.DriverDao;
import mate.jdbc.dao.ManufacturerDao;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;

public class Main {
    public static void main(String[] args) {
        Injector injector = Injector.getInstance("mate.jdbc");
        ManufacturerDao manufacturerDao = (ManufacturerDao) injector
                .getInstance(ManufacturerDao.class);
        DriverDao driverDao = (DriverDao) injector.getInstance(DriverDao.class);

        driverDao.getAll().forEach(System.out::println);
        System.out.println();
        Driver driver = driverDao.get(1L).orElse(new Driver());
        driver.setId(2L);
        driver.setName("Boss");
        driverDao.update(driver);
        System.out.println();
        driverDao.getAll().forEach(System.out::println);
        driverDao.delete(2L);
        System.out.println();
        driverDao.getAll().forEach(System.out::println);
        System.out.println();
        manufacturerDao.getAll().forEach(System.out::println);
    }
}
