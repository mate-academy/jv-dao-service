package mate.jdbc;

import mate.jdbc.dao.DriverDao;
import mate.jdbc.dao.DriverDaoImpl;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.ManufacturerService;
import java.util.List;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        // test your code here
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);

        manufacturerService.truncate();

        Manufacturer bmwManufacturer = new Manufacturer("BMW", "Germany");
        Manufacturer mercedesManufacturer = new Manufacturer("Mercedes", "Germany");
        Manufacturer toyotaManufacturer = new Manufacturer("Toyota", "Japan");

        System.out.println(manufacturerService.create(bmwManufacturer));
        System.out.println(manufacturerService.create(mercedesManufacturer));
        System.out.println(manufacturerService.create(toyotaManufacturer));

        System.out.println(manufacturerService.get(1L));
        System.out.println(manufacturerService.get(2L));
        System.out.println(manufacturerService.get(3L));
        System.out.println(manufacturerService.get(100L));

        mercedesManufacturer.setName("Mercedes Benz");
        System.out.println(manufacturerService.update(mercedesManufacturer));

        System.out.println(manufacturerService.delete(3L));

        List<Manufacturer> all = manufacturerService.getAll();
        System.out.println(all);

        DriverDao driverDao = new DriverDaoImpl();
        driverDao.truncate();
        Driver driver = new Driver("Bob", "123456");
        System.out.println(driverDao.create(driver));
        System.out.println(driverDao.get(1L));
        driver.setName("Alice");
        System.out.println(driverDao.update(driver));
        System.out.println(driverDao.delete(1L));
        System.out.println(driverDao.getAll());
    }
}
