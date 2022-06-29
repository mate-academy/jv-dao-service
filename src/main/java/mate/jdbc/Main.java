package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver kolya = new Driver("Kolya", "1954854");
        driverService.create(kolya);
        Driver jora = new Driver("Jora", "6254853");
        driverService.create(jora);
        Driver zoya = new Driver("Zoya", "5482358");
        driverService.create(zoya);
        System.out.println("Drivers was created...");
        System.out.println("Show Drivers by id 1, 2 and 3");
        System.out.println(driverService.get(1L));
        System.out.println(driverService.get(2L));
        System.out.println(driverService.get(3L));
        Driver ilona = new Driver(1L,"Ilona", "5482358");
        driverService.update(ilona);
        System.out.println("Updated Driver by id 1 to Ilona");
        driverService.delete(2L);
        System.out.println("Driver by id 2 was deleted...");
        System.out.println("Show all drivers");
        List<Driver> drivers = driverService.getAll();
        drivers.forEach(System.out::println);
    }
}
