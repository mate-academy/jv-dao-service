package mate.jdbc;

import mate.jdbc.dao.DriverDao;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver kitti = new Driver();
        kitti.setName("Kate");
        kitti.setLicenseNumber("Q1W2E3");
        Driver bob = new Driver();
        bob.setName("Bob");
        bob.setLicenseNumber("4R5T6Y");

        DriverService driverService = (DriverService) injector.getInstance(DriverDao.class);
        driverService.create(kitti);
        driverService.create(bob);

        kitti.setLicenseNumber("1Z2X3C");
        driverService.update(kitti);

        System.out.println(driverService.get(bob.getId()));
        driverService.delete(bob.getId());
        driverService.getAll().forEach(System.out::println);
    }
}
