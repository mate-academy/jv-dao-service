package mate.jdbc;

import mate.jdbc.dao.DriverDao;
import mate.jdbc.dao.ManufacturerDao;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        // test your code here
        ManufacturerDao manufacturerDao = (ManufacturerDao) injector
                .getInstance(ManufacturerDao.class);
        System.out.println("Test create manufacturer");
        Manufacturer ford = new Manufacturer("FORD", "USA");
        ford = manufacturerDao.create(ford);
        Manufacturer audi = new Manufacturer("AUDI", "Germany");
        audi = manufacturerDao.create(audi);
        Manufacturer lanos = new Manufacturer("LANOS", "UKRAINE");
        lanos = manufacturerDao.create(lanos);
        System.out.println("Test getAll manufacturer");
        manufacturerDao.getAll().forEach(System.out::println);
        System.out.println("Test update. Changed name in lanos variable to tesla");
        lanos.setName("tesla");
        manufacturerDao.update(lanos);
        manufacturerDao.getAll().forEach(System.out::println);
        System.out.println("Test get manufacturer");
        System.out.println(manufacturerDao.get(lanos.getId()));
        System.out.println("Test delete manufacturer");
        manufacturerDao.delete(audi.getId());
        System.out.println("================================");
        manufacturerDao.getAll().forEach(System.out::println);
        System.out.println(ford.getId());

        DriverDao driverDao = (DriverDao) injector
                .getInstance(DriverDao.class);
        System.out.println("Test create driver");
        Driver bob = new Driver("Bob", "AS4356QQ");
        bob = driverDao.create(bob);
        Driver alice = new Driver("Alice", "FR5748IO");
        alice = driverDao.create(alice);
        Driver jonh = new Driver("Jonh", "GF6534TY");
        jonh = driverDao.create(jonh);
        System.out.println("Test getAll driver");
        driverDao.getAll().forEach(System.out::println);
        System.out.println("Test update. Changed name in Bob variable to Ivan");
        bob.setName("Ivan");
        driverDao.update(bob);
        driverDao.getAll().forEach(System.out::println);
        System.out.println("Test get driver");
        System.out.println(driverDao.get(bob.getId()));
        System.out.println("Test delete driver");
        driverDao.delete(alice.getId());
        driverDao.getAll().forEach(System.out::println);
    }
}
