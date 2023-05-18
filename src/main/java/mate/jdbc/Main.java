package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriveService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriveService driveService = (DriveService) injector.getInstance(DriveService.class);
        printAll(driveService);
        Driver petro = new Driver("Petro", "68724");
        driveService.create(petro);
        printAll(driveService);
        System.out.println("Driver with id 2 :" + driveService.get(2L));
        Driver newDriver = new Driver(1L, "Ivan", "87986");
        driveService.update(newDriver);
        printAll(driveService);
        driveService.delete(3L);
        printAll(driveService);
    }

    private static void printAll(DriveService driveService) {
        System.out.println("All drivers:");
        List<Driver> drivers = driveService.getAll();
        drivers.forEach(System.out::println);
    }
}
