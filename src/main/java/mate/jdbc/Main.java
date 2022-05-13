package mate.jdbc;

import mate.jdbc.dao.DriverDao;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverDao driverDao =
                (DriverDao) injector.getInstance(DriverDao.class);
        Driver petro = new Driver();
        petro.setName("Petro");
        petro.setLicenseNumber("123654");
        driverDao.create(petro);

        Driver sasha = new Driver();
        sasha.setName("Sasha");
        sasha.setLicenseNumber("123604");
        driverDao.create(sasha);

        driverDao.getAll().forEach(System.out::println);
    }
}
