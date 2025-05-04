package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driver1 = new Driver("Igor","12");
        Driver driver2 = new Driver("Anne","983");
        System.out.println(driverService.create(driver1));
        System.out.println(driverService.create(driver2));
        driverService.getAll().stream().forEach(System.out::println);
        driver1.setLicenseNumber("3939");
        System.out.println("Driver before update " + driverService.get(driver1.getId()));
        driverService.update(driver1);
        System.out.println("Driver after update " + driverService.get(driver1.getId()));
        driverService.delete(driver1.getId());
        System.out.println("Drivers after delete...");
        driverService.getAll().forEach(System.out::println);
    }
}


