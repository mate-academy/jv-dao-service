package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver firstDriver = new Driver();
        firstDriver.setName("firstName");
        firstDriver.setLicenseNumber("firstNumber");
        Driver secondDriver = new Driver();
        secondDriver.setName("secondName");
        secondDriver.setLicenseNumber("secondNumber");
        Driver thirdDriver = new Driver();
        thirdDriver.setName("thirdName");
        thirdDriver.setLicenseNumber("thirdNumber");

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        System.out.println("-create method-");
        System.out.println(driverService.create(firstDriver));
        System.out.println(driverService.create(secondDriver));
        System.out.println(driverService.create(thirdDriver));

        System.out.println("-get method-");
        System.out.println(driverService.get(firstDriver.getId()));

        System.out.println("-getAll method-");
        List<Driver> allDrivers = driverService.getAll();
        allDrivers.forEach(System.out::println);

        secondDriver.setName("updatedName");
        driverService.update(secondDriver);
        driverService.delete(thirdDriver.getId());

        System.out.println("-getAll method after update and delete-");
        driverService.getAll().forEach(System.out::println);
    }
}
