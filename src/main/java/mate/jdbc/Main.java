package mate.jdbc;

import java.util.ArrayList;
import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        List<Driver> drivers = getDrivers();
        getDrivers().forEach(System.out::println);

        Driver getDriver = driverService.get(2L);
        System.out.println(getDriver);

        List<Driver> allDriversFromDB = driverService.getAll();
        System.out.println(allDriversFromDB);

        Driver denis = new Driver();
        denis.setId(1L);
        denis.setName("Denis");
        denis.setLicenseNumber("0007");
        driverService.update(denis);
        System.out.println(denis);

        boolean isDeletedDriver = driverService.delete(3L);
        System.out.println(isDeletedDriver);
    }

    private static List<Driver> getDrivers() {
        Driver anna = new Driver();
        anna.setName("Anna");
        anna.setLicenseNumber("0001");
        Driver bruce = new Driver();
        bruce.setName("Bruce");
        bruce.setLicenseNumber("0002");
        Driver colin = new Driver();
        colin.setName("Colin");
        colin.setLicenseNumber("0003");
        List<Driver> allDrivers = new ArrayList<>();
        allDrivers.add(anna);
        allDrivers.add(bruce);
        allDrivers.add(colin);
        return allDrivers;
    }
}
