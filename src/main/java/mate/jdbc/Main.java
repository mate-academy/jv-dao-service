package mate.jdbc;

import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;
import mate.jdbc.util.Injector;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverServicece = (DriverService)
                injector.getInstance((DriverService.class));
        Driver driverVictor = new Driver(1L,"Victor", "123456");
        Driver driverBob = new Driver(2L,"Bob", "987654");
        Driver driverMax = new Driver(3L, "Max", "111222");
        driverServicece.create(driverVictor);
        driverServicece.create(driverBob);
        driverServicece.create(driverMax);
        System.out.println(driverServicece.get(2L));
        driverBob.setLicenseNumber("AC9999New");
        driverServicece.update(driverBob);
        driverServicece.delete(1L);
        driverServicece.getAll().forEach(System.out::println);
    }
}
