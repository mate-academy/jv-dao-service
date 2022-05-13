package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver petro = new Driver();
        petro.setName("Petro");
        petro.setLicenseNumber("123654");
        driverService.create(petro);

        Driver sasha = new Driver();
        sasha.setName("Sasha");
        sasha.setLicenseNumber("123604");
        driverService.create(sasha);

        driverService.getAll().forEach(System.out::println);
    }
}
