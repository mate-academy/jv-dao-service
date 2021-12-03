package mate.jdbc;

import java.util.List;
import mate.jdbc.dao.CarDriverDao;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.CarDriver;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        CarDriverDao carDriverDao =
                (CarDriverDao) injector.getInstance(CarDriverDao.class);

        List<CarDriver> carDrivers = carDriverDao.getAll();
        System.out.println("List from DB:");
        carDrivers.stream().forEach(System.out::println);

        CarDriver driverBenL1 = carDriverDao.get(1L).orElse(null);
        driverBenL1.setLicenseNumber("LBen1");
        System.out.println("Updated manufacturer to " + carDriverDao.update(driverBenL1));
        CarDriver driverJohnL2 = carDriverDao.get(2L).get();
        driverJohnL2.setLicenseNumber("L2John");
        carDriverDao.update(driverJohnL2);

        carDrivers = carDriverDao.getAll();
        System.out.println("List with changes:");
        carDrivers.stream().forEach(System.out::println);

        System.out.println(carDriverDao.delete(4L));
        System.out.println("Get MERCEDES: " + carDriverDao.get(driverBenL1.getId()).orElse(null));
        System.out.println("Get deleted KIA: " + carDriverDao.get(4L));
        System.out.println("Get wrong id: " + carDriverDao.get(55L).orElse(null));
    }
}
