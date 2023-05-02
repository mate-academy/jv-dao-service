package mate.jdbc;

import mate.jdbc.dao.ManufacturerDao;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;

public class Main {
    public static void main(String[] args) {
        final Injector injector = Injector.getInstance("mate.jdbc");
        final DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        final ManufacturerDao manufacturerDao =
                (ManufacturerDao) injector.getInstance(ManufacturerDao.class);

        Manufacturer manufacturerA = new Manufacturer("A", "AA");
        Manufacturer manufacturerB = new Manufacturer("B", "BB");
        Manufacturer manufacturerC = new Manufacturer("C", "CC");
        Manufacturer manufacturerD = new Manufacturer("D", "DD");
        Manufacturer manufacturerE = new Manufacturer("E", "EE");
        System.out.println(manufacturerDao.create(manufacturerA));
        System.out.println(manufacturerDao.create(manufacturerB));
        System.out.println(manufacturerDao.create(manufacturerC));
        System.out.println(manufacturerDao.create(manufacturerD));
        System.out.println(manufacturerDao.create(manufacturerE));
        System.out.println(manufacturerDao.get(1L));
        manufacturerDao.getAll().forEach(System.out::println);
        manufacturerE.setName("EEE");
        manufacturerE.setCountry("EEEEE");
        System.out.println(manufacturerDao.update(manufacturerE));
        manufacturerDao.getAll().forEach(System.out::println);
        manufacturerDao.delete(manufacturerE.getId());
        manufacturerDao.getAll().forEach(System.out::println);

        Driver driverA = new Driver("A", "AA");
        Driver driverB = new Driver("B", "BB");
        Driver driverC = new Driver("C", "CC");
        Driver driverD = new Driver("D", "DD");
        Driver driverE = new Driver("E", "EE");

        System.out.println(driverService.create(driverA));
        System.out.println(driverService.create(driverB));
        System.out.println(driverService.create(driverC));
        System.out.println(driverService.create(driverD));
        System.out.println(driverService.create(driverE));
        System.out.println(driverService.get(1L));
        driverService.getAll().forEach(System.out::println);
        driverE.setName("EEE");
        driverE.setLicenseNumber("EEEEE");
        System.out.println(driverService.update(driverE));
        driverService.getAll().forEach(System.out::println);
        driverService.delete(driverE.getId());
        driverService.getAll().forEach(System.out::println);
    }
}
