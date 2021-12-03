package mate.jdbc;

import java.util.List;
import mate.jdbc.dao.DriverDao;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverDao driverDao =
                (DriverDao) injector.getInstance(DriverDao.class);

        List<Driver> drivers = driverDao.getAll();
        System.out.println("List from DB:");
        drivers.stream().forEach(System.out::println);

        Driver driverBenL1 = driverDao.get(1L).orElse(null);
        driverBenL1.setLicenseNumber("LBen1");
        System.out.println("Updated manufacturer to " + driverDao.update(driverBenL1));
        Driver driverJohnL2 = driverDao.get(2L).get();
        driverJohnL2.setLicenseNumber("L2John");
        driverDao.update(driverJohnL2);

        drivers = driverDao.getAll();
        System.out.println("List with changes:");
        drivers.stream().forEach(System.out::println);

        System.out.println(driverDao.delete(4L));
        System.out.println("Get MERCEDES: " + driverDao.get(driverBenL1.getId()).orElse(null));
        System.out.println("Get deleted KIA: " + driverDao.get(4L));
        System.out.println("Get wrong id: " + driverDao.get(55L).orElse(null));
    }
}
