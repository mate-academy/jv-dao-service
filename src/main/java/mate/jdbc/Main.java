package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        Driver firstDriver = new Driver();
        firstDriver.setName("Matt");
        firstDriver.setLicenseNumber("57898");
        driverService.create(firstDriver);
        driverService.delete(firstDriver.getId());

        Driver secondDriver = new Driver("John", "94863");
        driverService.create(secondDriver);
        secondDriver.setLicenseNumber("93835");
        driverService.update(secondDriver);

        driverService.getAll().forEach(System.out::println);
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        manufacturerService.getAll().forEach(System.out::println);

    }
}
