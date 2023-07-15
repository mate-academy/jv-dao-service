package mate.jdbc;

import mate.jdbc.dao.DriverDao;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver driver = new Driver("bob", "number");
        DriverDao driverDao = (DriverDao) injector.getInstance(DriverDao.class);
        driver = driverDao.create(driver);
        driver.setName("Bobchello");
        driverDao.update(driver);
        driverDao.getAll().forEach(System.out::println);
        System.out.println(driverDao.get(driver.getId()));
        System.out.println(driverDao.delete(driver.getId()));
    }
}
