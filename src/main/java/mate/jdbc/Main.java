package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driverBob = new Driver("Bob", "1234");
        Driver driverAlice = new Driver("Alice", "4567");
        Driver driverBill = new Driver("Bill", "7890");
        driverService.create(driverAlice);
        driverService.create(driverBill);
        driverService.create(driverBob);
        System.out.println(driverService.get(driverAlice.getId()));
        System.out.println("-------------------------------------------------");
        System.out.println(driverService.getAll());
        System.out.println("-------------------------------------------------");
        driverService.delete(driverAlice.getId());
        System.out.println(driverService.getAll());
        System.out.println("-------------------------------------------------");
        driverBob.setLicenseNumber("0001");
        System.out.println(driverService.get(driverBob.getId()));
    }
}
