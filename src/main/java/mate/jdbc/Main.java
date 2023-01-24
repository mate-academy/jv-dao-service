package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");
    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver firstDriver = new Driver();
        firstDriver.setName("Armen");
        firstDriver.setLicenseNumber("111");
        driverService.create(firstDriver);
        Driver secondDriver = new Driver();
        secondDriver.setName("Giwi");
        secondDriver.setLicenseNumber("555");
        driverService.create(secondDriver);
        Driver thirdDriver = new Driver();
        thirdDriver.setName("Koba");
        thirdDriver.setLicenseNumber("666");
        driverService.create(thirdDriver);
        firstDriver.setName("Ashot");
        driverService.update(firstDriver);
        driverService.delete(secondDriver.getId());
        driverService.getAll().forEach(System.out::println);
    }
}
