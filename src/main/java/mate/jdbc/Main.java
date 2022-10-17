package mate.jdbc;

import mate.jdbc.dao.DriverDao;
import mate.jdbc.dao.DriverDaoImpl;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver driverOne = new Driver();
        driverOne.setName("Andrii");
        driverOne.setLicenseNumber("122444");

        Driver driverTwo = new Driver();
        driverTwo.setName("Oleksandr");
        driverTwo.setLicenseNumber("224880");

        Driver driverThree = new Driver();
        driverThree.setName("Volodymyr");
        driverThree.setLicenseNumber("224557");

        DriverDao driverDao = new DriverDaoImpl();

        System.out.println("Creating new driver: " + driverOne.getName());
        driverDao.create(driverOne);
        System.out.println("Creating new driver: " + driverTwo.getName());
        driverDao.create(driverTwo);
        System.out.println("Creating new driver: " + driverThree.getName());
        driverDao.create(driverThree);

        System.out.println("All drivers list: ");
        System.out.println(driverDao.getAll());

        System.out.println("Update driver " + driverOne.getName() + " license number");
        driverOne.setLicenseNumber("457888");
        driverDao.update(driverOne);

        System.out.println("All drivers list: ");
        System.out.println(driverDao.getAll());

        System.out.println("Delete driver: " + driverThree.getName()
                + " with id: " + driverThree.getId());
        System.out.println(driverDao.delete(driverTwo.getId()));

        System.out.println("All drivers list: ");
        System.out.println(driverDao.getAll());
    }
}
