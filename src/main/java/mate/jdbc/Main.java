package mate.jdbc;

import java.util.Optional;
import mate.jdbc.dao.DriverDao;
import mate.jdbc.dao.ManufacturerDao;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Manufacturer manufacturerBmw = new Manufacturer();
        manufacturerBmw.setName("BMW");
        manufacturerBmw.setCountry("Germany");
        Manufacturer manufacturerLexus = new Manufacturer();
        manufacturerLexus.setName("Lexus");
        manufacturerLexus.setCountry("Japan");
        Manufacturer manufacturerVolkswagen = new Manufacturer();
        manufacturerVolkswagen.setName("Volkswagen");
        manufacturerVolkswagen.setCountry("German");
        ManufacturerDao manufacturerDao = (ManufacturerDao) injector.getInstance(
                ManufacturerDao.class);
        Manufacturer manufacturer1 = manufacturerDao.create(manufacturerBmw);
        Manufacturer manufacturer2 = manufacturerDao.create(manufacturerLexus);
        Manufacturer manufacturer3 = manufacturerDao.create(manufacturerVolkswagen);
        System.out.println(manufacturer1);
        System.out.println(manufacturer2);
        System.out.println(manufacturer3);

        manufacturerDao.getAll().forEach(System.out::println);

        System.out.println(manufacturerDao.delete(manufacturer1.getId()));

        manufacturerBmw.setName("Audi");
        Manufacturer manufacturerBmwUpdate = manufacturerDao.update(manufacturerBmw);
        System.out.println(manufacturerBmwUpdate);

        Optional<Manufacturer> manufacturerOptional = manufacturerDao.get(manufacturer2.getId());
        System.out.println(manufacturerOptional);

        Driver driverBmw = new Driver();
        driverBmw.setName("Andre");
        driverBmw.setLicenseNumber("A12345");
        Driver driverLexus = new Driver();
        driverLexus.setName("Sergey");
        driverLexus.setLicenseNumber("S45678");
        Driver driverVolkswagen = new Driver();
        driverVolkswagen.setName("Petro");
        driverVolkswagen.setLicenseNumber("P14785");
        DriverDao driverDao = (DriverDao) injector.getInstance(DriverDao.class);
        Driver driver1 = driverDao.create(driverBmw);
        Driver driver2 = driverDao.create(driverLexus);
        Driver driver3 = driverDao.create(driverVolkswagen);
        System.out.println(driver1);
        System.out.println(driver2);
        System.out.println(driver3);

        driverDao.getAll().forEach(System.out::println);

        System.out.println(driverDao.delete(driver1.getId()));

        driverBmw.setName("Shura");
        Driver driverBmwUpdate = driverDao.update(driverBmw);
        System.out.println(driverBmwUpdate);

        Optional<Driver> driverOptional = driverDao.get(driver2.getId());
        System.out.println(driverOptional);
    }
}
