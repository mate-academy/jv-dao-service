package mate.jdbc;

import mate.jdbc.dao.DriverDao;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;

public class Main {
    public static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        // test your code here
        DriverDao driverDao =
                (DriverDao) injector.getInstance(DriverDao.class);

        // Create new Drivers
        Driver driverMike = new Driver();
        driverMike.setName("Mike");
        driverMike.setLicenseNumber("012345678");
        driverDao.create(driverMike);

        Driver driverAnna = new Driver();
        driverAnna.setName("Anna");
        driverAnna.setLicenseNumber("987654321");
        driverDao.create(driverAnna);

        //Get all Drivers
        System.out.println("All Drivers:");
        driverDao.getAll().forEach(System.out::println);

        //Update Drivers
        Driver driverMikeUpdate = new Driver();
        driverMikeUpdate.setId(1L);
        driverMikeUpdate.setLicenseNumber("8765432109");
        driverDao.update(driverMikeUpdate);

        //Get all Drivers
        System.out.println("All Drivers:");
        driverDao.getAll().forEach(System.out::println);

        //Delete Driver by id
        driverDao.delete(1L);

        //Get all Drivers
        System.out.println("All Drivers:");
        driverDao.getAll().forEach(System.out::println);

    }
}
