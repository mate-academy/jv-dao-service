package mate.jdbc;

import mate.jdbc.dao.DriverServiceDao;
import mate.jdbc.dao.DriverServiceDaoImpl;
import mate.jdbc.dao.ManufacturerDao;
import mate.jdbc.dao.ManufacturerDaoImpl;
import mate.jdbc.lib.Injector;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerDao manufacturerDao = new ManufacturerDaoImpl();
        manufacturerDao.getAll().forEach(System.out::println);
        DriverServiceDao driverServiceDao = new DriverServiceDaoImpl();
        driverServiceDao.getAll().forEach(System.out::println);
    }
}
