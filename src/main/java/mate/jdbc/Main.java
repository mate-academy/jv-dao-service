package mate.jdbc;

import mate.jdbc.dao.ManufacturerDao;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driverFirst = new Driver("Sasha", "12345");
        Driver driverSecond = new Driver("Petro", "67890");
        Driver driverThird = new Driver("Vasia", "34567");

        driverFirst = driverService.create(driverFirst);
        driverSecond = driverService.create(driverSecond);
        driverThird = driverService.create(driverThird);

        System.out.println(driverService.get(3L));

        System.out.println(driverService.getAll());

        driverFirst.setLicenseNumber("54321");
        System.out.println(driverService.update(driverFirst));

        System.out.println(driverService.delete(2L));

        Manufacturer manufacturerFirst = new Manufacturer();
        manufacturerFirst.setName("First");
        manufacturerFirst.setCountry("First");

        Manufacturer manufacturerSecond = new Manufacturer();
        manufacturerSecond.setName("Second");
        manufacturerSecond.setCountry("Second");

        Manufacturer manufacturerThird = new Manufacturer();
        manufacturerThird.setName("Third");
        manufacturerThird.setCountry("Third");

        ManufacturerDao manufacturerDao =
                (ManufacturerDao) injector.getInstance(ManufacturerDao.class);
        manufacturerFirst = manufacturerDao.create(manufacturerFirst);
        manufacturerSecond = manufacturerDao.create(manufacturerSecond);
        manufacturerThird = manufacturerDao.create(manufacturerThird);

        System.out.println(manufacturerDao.get(4L).orElse(manufacturerThird));

        System.out.println(manufacturerDao.getAll());

        manufacturerSecond.setName("newSecond");
        manufacturerSecond.setCountry("newSecond");
        System.out.println(manufacturerDao.update(manufacturerSecond));

        manufacturerDao.delete(6L);
    }
}
