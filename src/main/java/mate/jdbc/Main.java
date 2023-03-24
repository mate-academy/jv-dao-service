package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static DriverService driverService
            = (DriverService) injector.getInstance(DriverService.class);
    private static ManufacturerService manufacturerDao
            = (ManufacturerService) injector.getInstance(ManufacturerService.class);

    public static void main(String[] args) {
        // Create models Drivers, Manufacturers
        Driver driver = new Driver("Bohdan", "lic0285442_2456cer");
        System.out.println(driverService.create(driver));
        Manufacturer manufacturerModel1 = new Manufacturer();
        manufacturerModel1.setName("Bohdan");
        manufacturerModel1.setCountry("Ukraine");
        Manufacturer manufacturerModel2 = new Manufacturer();
        manufacturerModel2.setName("Ivan");
        manufacturerModel2.setCountry("United States of America");
        manufacturerDao.create(manufacturerModel1);
        manufacturerDao.create(manufacturerModel2);
        // Read data Drivers, Manufacturers
        System.out.println(manufacturerDao.get(manufacturerModel1.getId()));
        System.out.println(manufacturerDao.getAll());
        System.out.println(driverService.get(driver.getId()));
        System.out.println(driverService.getAll());
        // Update data Drivers, Manufacturers
        driver.setName("Myhaylo");
        driverService.update(driver);
        System.out.println(driverService.getAll());
        manufacturerModel1.setName("Taras");
        manufacturerModel1.setCountry("Brazilia");
        manufacturerDao.update(manufacturerModel1);
        System.out.println(manufacturerDao.getAll());
        // Delete data Drivers, Manufacturers
        driverService.delete(driver.getId());
        System.out.println(driverService.getAll());
        manufacturerDao.delete(manufacturerModel2.getId());
        System.out.println(manufacturerDao.getAll());
    }
}
