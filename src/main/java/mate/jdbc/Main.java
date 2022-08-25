package mate.jdbc;

import mate.jdbc.dao.ManufacturerDao;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerDao manufacturerDao =
                (ManufacturerDao) injector.getInstance(ManufacturerDao.class);
        Manufacturer manufacturerAudi = new Manufacturer(null, "Nissan", "Japan");
        Manufacturer manufacturerBmw = new Manufacturer(null, "Porsche", "Germany");
        manufacturerAudi = manufacturerDao.create(manufacturerAudi);
        manufacturerBmw = manufacturerDao.create(manufacturerBmw);
        System.out.println("Added two manufacturers");
        manufacturerDao.getAll().forEach(System.out::println);
        manufacturerAudi.setCountry("Ukraine");
        manufacturerDao.update(manufacturerAudi);
        System.out.println("Updated audi manufacturer");
        manufacturerDao.getAll().forEach(System.out::println);
        manufacturerDao.delete(manufacturerBmw.getId());
        System.out.println("Deleted BMW manufacturer");
        manufacturerDao.getAll().forEach(System.out::println);
        System.out.println("Got audi manufacturer");
        System.out.println(manufacturerDao.get(manufacturerAudi.getId()));

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver bobDriver = new Driver("Bob","1234567");
        Driver alisaDriver = new Driver("Alisa", "7654321");
        driverService.create(bobDriver);
        driverService.create(alisaDriver);
        driverService.getAll().forEach(System.out::println);
        System.out.println(driverService.get(bobDriver.getId()));
        Driver mikeDriver = new Driver();
        mikeDriver.setId(alisaDriver.getId());
        mikeDriver.setName("Mike");
        mikeDriver.setLicenseNumber("34567");
        driverService.update(mikeDriver);
        driverService.delete(bobDriver.getId());
        driverService.getAll().forEach(System.out::println);
    }
}

