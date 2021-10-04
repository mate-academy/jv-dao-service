package mate.jdbc;

import mate.jdbc.dao.DriverDao;
import mate.jdbc.dao.ManufacturerDao;
import mate.jdbc.lib.Injector;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerDao manufacturerDao = (ManufacturerDao) injector
                .getInstance(ManufacturerDao.class);
        DriverDao driverDao = (DriverDao) injector
                .getInstance(DriverDao.class);
        driverDao.getAll().forEach(System.out::println);
        System.out.println(driverDao.get(1L));
    }
}
