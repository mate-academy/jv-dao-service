package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver dmytro = new Driver("Dmytro","k112233sw");
        Driver boris = new Driver("Boris","k556677sw");
        System.out.println("Drivers table before operations:");
        driverService.getAll().forEach(System.out::println);
        System.out.println("Adding drivers into table...");
        driverService.create(dmytro);
        driverService.create(boris);
        System.out.println("Table after adding drivers:");
        driverService.getAll().forEach(System.out::println);
        System.out.println("Updating Dmytro's license number...");
        dmytro.setLicenseNumber("k777777sw");
        driverService.update(dmytro);
        System.out.println("Checking if Dmytro's info is updated:");
        driverService.get(dmytro.getId());
        System.out.println("Deleting Dmytro and checking table after all operations:");
        driverService.delete(dmytro.getId());
        driverService.getAll().forEach(System.out::println);
    }
}
