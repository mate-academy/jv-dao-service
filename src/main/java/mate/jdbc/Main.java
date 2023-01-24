package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driverOne = new Driver();
        driverOne.setName("Lolik");
        driverOne.setLicenseNumber("12345");
        driverService.create(driverOne);
        Driver driverTwo = new Driver();
        driverTwo.setName("Stepan");
        driverTwo.setLicenseNumber("67890");
        driverService.create(driverTwo);
        Driver driverThree = new Driver();
        driverThree.setName("Petro");
        driverThree.setLicenseNumber("17498");
        driverService.create(driverThree);
        driverService.getAll().forEach(System.out::println);
        driverTwo.setLicenseNumber("09876");
        driverService.update(driverTwo);
        driverService.delete(driverThree.getId());
        System.out.println(driverService.get(driverOne.getId()));
        driverService.getAll().forEach(System.out::println);
    }
}
