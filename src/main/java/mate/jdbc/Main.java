package mate.jdbc;

import lombok.extern.log4j.Log4j2;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

@Log4j2
public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Manufacturer testMf = new Manufacturer();
        testMf.setName("JDBC2");
        testMf.setCountry("Ukraine");
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);

        log.info("Added manufacturer: " + manufacturerService.create(testMf));

        log.info("Info about manufacturer id: " + testMf.getId()
                + " = " + manufacturerService.get(testMf.getId()));

        testMf.setName("Kia ");
        testMf.setCountry("Korea");
        testMf.setId(30L);

        log.info("Updated manufacturer with id: " + testMf.getId()
                + ". New data: " + manufacturerService.update(testMf));

        manufacturerService.getAll().forEach(System.out::println);

        log.info("Deleted manufacturer: [" + manufacturerService.delete(testMf.getId())
                + "] for id: " + testMf.getId());

        Driver testDriver = new Driver();
        testDriver.setName("Gadiya Petrovich");
        testDriver.setLicenseNumber("BE23763P");
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        log.info("Added driver: " + driverService.create(testDriver));

        log.info("Info about driver id: " + testDriver.getId()
                + " = " + driverService.get(testDriver.getId()));

        testDriver.setName("Izeslav");
        testDriver.setLicenseNumber("AP38478X");
        testDriver.setId(30L);

        log.info("Updated driver with id: " + testDriver.getId()
                + ". New data: " + driverService.update(testDriver));

        driverService.getAll().forEach(System.out::println);

        log.info("Deleted driver: [" + driverService.delete(testDriver.getId())
                + "] for id: " + testDriver.getId());
    }
}
