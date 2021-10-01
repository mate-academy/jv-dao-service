package mate.jdbc;

import lombok.extern.log4j.Log4j2;
import mate.jdbc.dao.ManufacturerDao;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Manufacturer;

@Log4j2
public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerDao manufacturerDao = (ManufacturerDao) injector.getInstance(ManufacturerDao.class);

        Manufacturer testMf = new Manufacturer();
        testMf.setName("JDBC2");
        testMf.setCountry("Ukraine");

        log.info("Added manufacturer: " + manufacturerDao.create(testMf));

        log.info("Info about manufacturer id: " + testMf.getId()
                + " = " + manufacturerDao.get(testMf.getId()));

        manufacturerDao.getAll().forEach(System.out::println);

    }
}
