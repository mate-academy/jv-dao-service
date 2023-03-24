package mate.jdbc;

import mate.jdbc.dao.DriverDao;
import mate.jdbc.dao.ManufacturerDao;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;

public class Main {
    private static final String NAME_OF_MANUFACTURER = "Ferrari";
    private static final String COUNTRY_OF_MANUFACTURER = "Italy";
    private static final String NAME_OF_MANUFACTURER_CHANGE = "Lamborghini";
    private static final String NAME_OF_DRIVER = "John";
    private static final String LICENSE_NUMBER_OF_DRIVER = "1366613";
    private static final String NAME_OF_DRIVER_CHANGE = "Chris";
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static ManufacturerDao manufacturerDao = (ManufacturerDao)
            injector.getInstance(ManufacturerDao.class);
    private static DriverDao driverDao = (DriverDao)
            injector.getInstance(DriverDao.class);

    public static void main(String[] args) {
        Manufacturer testManufacturer = new Manufacturer(NAME_OF_MANUFACTURER,
                COUNTRY_OF_MANUFACTURER);
        Driver testDriver = new Driver(NAME_OF_DRIVER, LICENSE_NUMBER_OF_DRIVER);
        manufacturerDao.create(testManufacturer);
        driverDao.create(testDriver);
        //getAll test
        System.out.println(manufacturerDao.getAll());
        System.out.println(driverDao.getAll());
        //get test
        System.out.println(manufacturerDao.get(testManufacturer.getId()));
        System.out.println(driverDao.get(testDriver.getId()));
        //update test
        testManufacturer.setName(NAME_OF_MANUFACTURER_CHANGE);
        manufacturerDao.update(testManufacturer);
        System.out.println(manufacturerDao.getAll());
        testDriver.setName(NAME_OF_DRIVER_CHANGE);
        driverDao.update(testDriver);
        System.out.println(driverDao.getAll());
        //delete test
        manufacturerDao.delete(testManufacturer.getId());
        System.out.println(manufacturerDao.getAll());
        driverDao.delete(testDriver.getId());
        System.out.println(driverDao.getAll());
    }
}
