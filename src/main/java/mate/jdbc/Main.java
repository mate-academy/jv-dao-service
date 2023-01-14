package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {

    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);
        driverService.getAll().forEach(System.out::println);
        Driver ivan = new Driver();
        ivan.setName("Ivan");
        ivan.setLicenseNumber("22500335");
        System.out.println(driverService.create(ivan));
        driverService.getAll().forEach(System.out::println);
        ivan.setLicenseNumber("22550335");
        ivan.setId(ivan.getId());
        System.out.println(driverService.update(ivan));
        driverService.getAll().forEach(System.out::println);
        System.out.println(driverService.get(3L));
        System.out.println(driverService.delete(1L));
        driverService.getAll().forEach(System.out::println);
    }
}
