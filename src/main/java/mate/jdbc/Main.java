package mate.jdbc;

import mate.jdbc.dao.DriverDao;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;

public class Main {
    public static void main(String[] args) {
        Injector injector = Injector.getInstance("mate.jdbc");
        DriverDao driverDao = (DriverDao) injector.getInstance(DriverDao.class);

        Driver driver = new Driver(0L, "Driver 1", "111111111000");
        driverDao.create(driver);
        driverDao.getAll().forEach(System.out::println);
        driver = new Driver(5L, "Driver 5", "111111111000");
        driverDao.update(driver);
        System.out.println(driverDao.delete(5L));
        System.out.println(driverDao.get(6L));
        System.out.println(driverDao.get(5L));
    }
}
