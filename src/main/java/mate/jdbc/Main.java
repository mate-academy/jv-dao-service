package mate.jdbc;

import mate.jdbc.dao.DriverDao;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc.dao");

    public static void main(String[] args) {
        DriverDao driverDao = (DriverDao) injector.getInstance(DriverDao.class);
        Driver max = new Driver("mad_max", "no_license_never_was");
        Driver alonso = new Driver("fernando", "McLaren#666");
        max = driverDao.create(max);
        alonso = driverDao.create(alonso);
        driverDao.getAll().forEach(System.out::println);
        System.lineSeparator();
        alonso.setLicenseNumber("renault#777");
        driverDao.update(alonso);
        System.out.println(driverDao.get(alonso.getId()));
        driverDao.delete(max.getId());
        driverDao.getAll().forEach(System.out::println);
    }
}
