package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        Driver bob = new Driver("Matt", "57898");
        Driver rick = new Driver("John", "94863");
        driverService.create(bob);
        driverService.create(rick);
        rick.setLicenseNumber("93835");
        driverService.update(rick);
        driverService.delete(rick.getId());
        driverService.getAll().forEach(System.out::println);

    }
}
