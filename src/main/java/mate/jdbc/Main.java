package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.DriverServiceImpl;
import mate.jdbc.service.ManufacturerService;
import mate.jdbc.service.ManufacturerServiceImpl;

public class Main {
    public static final String PACKAGE_NAME = "mate.jdbc";
    private static Injector injector = Injector.getInstance(PACKAGE_NAME);

    public static void main(String[] args) {
        DriverServiceImpl driverService =
                (DriverServiceImpl) injector.getInstance(DriverService.class);

        Driver jack = driverService.create(new Driver("Jack", "110011"));
        System.out.println(driverService.get(jack.getId()));
        jack.setLicenseNumber("991399");
        driverService.update(jack);
        System.out.println(driverService.get(jack.getId()));
        System.out.println("result of delete(jack) operation: "
                + driverService.delete(jack.getId()));
        driverService.getAll().forEach(System.out::println);
        System.out.println(System.lineSeparator());

        ManufacturerServiceImpl manufacturerService =
                (ManufacturerServiceImpl) injector.getInstance(ManufacturerService.class);
        manufacturerService.getAll().forEach(System.out::println);
    }
}
