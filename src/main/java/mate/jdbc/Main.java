package mate.jdbc;

import mate.jdbc.dao.DriverDao;
import mate.jdbc.dao.ManufacturerDao;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerDao manufacturerDao = (ManufacturerDao)
                injector.getInstance(ManufacturerDao.class);

        Manufacturer manufacturerJohn = new Manufacturer();
        manufacturerJohn.setName("John");
        manufacturerJohn.setCountry("Italy");
        System.out.println(manufacturerDao.create(manufacturerJohn));

        Manufacturer manufacturerBob = new Manufacturer();
        manufacturerBob.setName("Bob");
        manufacturerBob.setCountry("France");
        System.out.println(manufacturerDao.create(manufacturerBob));

        DriverDao driverDao = (DriverDao)
                injector.getInstance(DriverDao.class);

        Driver driverOleh = new Driver();
        driverOleh.setName("Oleh");
        driverOleh.setLicenseNumber("8764876");
        System.out.println(driverDao.create(driverOleh));

        Driver driverOstap = new Driver();
        driverOstap.setName("Ostap");
        driverOstap.setLicenseNumber("3423524");
        System.out.println(driverDao.create(driverOstap));

        System.out.println(manufacturerDao.get(2L));
        System.out.println(driverDao.get(2L));

        manufacturerJohn.setCountry("Finland");
        manufacturerDao.update(manufacturerJohn);

        driverOstap.setLicenseNumber("478395");
        driverDao.update(driverOstap);

        manufacturerDao.getAll().forEach(System.out::println);
        driverDao.getAll().forEach(System.out::println);

        System.out.println(manufacturerDao.delete(2L));
        System.out.println(driverDao.delete(3L));
    }
}
