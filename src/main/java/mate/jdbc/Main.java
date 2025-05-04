package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver driverAlex = new Driver();
        driverAlex.setName("Alex");
        driverAlex.setLicenseNumber("123456");

        Driver driverKate = new Driver();
        driverKate.setName("Kate");
        driverKate.setLicenseNumber("789123");

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        driverService.create(driverAlex);
        driverService.create(driverKate);
        driverService.getAll().forEach(System.out::println);

        System.out.println(driverService.get(driverAlex.getId()));
        System.out.println(driverService.get(driverKate.getId()));

        System.out.println(driverService.delete(driverAlex.getId()));

        driverKate.setName("Kateryna");
        driverKate.setLicenseNumber("456789");
        System.out.println(driverService.update(driverKate));
    }
}
