package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);
        Map<String,String> driversMap = Map.of(
                "Maksym","123456",
                "Maryna","654321",
                "Sergey","789012",
                "Svitlana","210987",
                "Olena","567890"
                );

        List<Driver> drivers = new ArrayList<>();
        driversMap.forEach((k,v) -> {
            Driver driver = new Driver();
            driver.setName(k);
            driver.setLicenseNumber(v);
            drivers.add(driver);
        });
        for (Driver driver : drivers) {
            Driver addedDriver = driverService.create(driver);
            System.out.println("Create method. Driver added: '"
                    + addedDriver + "' to the database.");
        }
        System.out.println("---------------------");
        System.out.println("GetAll method. List of drivers in the DB");
        List<Driver> allDrivers = driverService.getAll();
        allDrivers.forEach(System.out::println);
        System.out.println("---------------------");
        Long id = 4L;
        System.out.println("Get method. Driver with id " + id + " is:");
        Driver getDriver = driverService.get(id);
        System.out.println(getDriver);
        System.out.println("---------------------");
        System.out.println("Update method. Driver with id " + id + " is update:");
        Driver newDriver = new Driver();
        newDriver.setId(4L);
        newDriver.setName("Vasil");
        newDriver.setLicenseNumber("918273");
        Driver updateDriver = driverService.update(newDriver);
        System.out.println(updateDriver);
        System.out.println("---------------------");
        System.out.println("Delete method. Manufacturer with id " + id + " is deleted.");
        driverService.delete(id);
        System.out.println("List of manufacturers in the DB");
        List<Driver> allDriversRemain = driverService.getAll();
        allDriversRemain.forEach(System.out::println);
    }
}
