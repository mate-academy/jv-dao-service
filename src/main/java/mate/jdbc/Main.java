package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.servise.DriverService;

public class Main {
    private static final Injector injector =
            Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        //added driver to DB
        Driver driverFirst = new Driver("Rita", "B1111");
        Driver driverSecond = new Driver("Oscar", "C1112");
        Driver driverThird = new Driver("Moony", "A01");
        Driver driverForth = new Driver("Galo", "D07");
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        driverService.create(driverFirst);
        driverService.create(driverSecond);
        driverService.create(driverThird);
        Driver createdDriverForth = driverService.create(driverForth);
        System.out.println("Added data to driver table:");
        List<Driver> driverList = driverService.getAll();
        driverList.forEach(System.out::println);
        //get driver by id and update it
        System.out.println("Get driver from DB by id = " + createdDriverForth.getId()
                + " and update info.");
        createdDriverForth.setLicenseNumber("B007");
        Driver updateDriverFirst = driverService.update(createdDriverForth);
        System.out.println(updateDriverFirst);
        //soft delete driver by id
        System.out.println("Data from DB after deleted drive by id = "
                + updateDriverFirst.getId());
        driverService.delete(updateDriverFirst.getId());
        driverService.getAll().forEach(System.out::println);
    }
}
