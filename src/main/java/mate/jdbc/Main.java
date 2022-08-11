package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        System.out.println("Create five drivers.");
        Driver john = new Driver("John", "AAA-00001");
        Driver kate = new Driver("Kate", "AAA-00002");
        Driver pamela = new Driver("Pamela", "AAA-00003");
        Driver steve = new Driver("Steve", "AAA-00004");
        Driver adam = new Driver("Adam", "AAA-00005");
        driverService.create(john);
        driverService.create(kate);
        driverService.create(pamela);
        driverService.create(steve);
        driverService.create(adam);
        driverService.getAll().forEach(System.out::println);

        System.out.println("Get driver with id: 1.");
        System.out.println(driverService.get(john.getId()));

        System.out.println("Delete driver with id: 3");
        System.out.println(driverService.delete(pamela.getId()));
        driverService.getAll().forEach(System.out::println);

        System.out.println("Update driver with name: Steve - change license number.");
        steve.setLicenseNumber("AAA-00006");
        driverService.update(steve);
        driverService.getAll().forEach(System.out::println);

    }
}
