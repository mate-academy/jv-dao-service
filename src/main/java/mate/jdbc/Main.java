package mate.jdbc;

import mate.jdbc.dao.DriverDao;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverDao driverDao = (DriverDao) injector.getInstance(DriverDao.class);
        driverDao.getAll().forEach(System.out::println);
    }
}
