package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver bill = new Driver("Bill", "235m23");
        Driver john = new Driver("John", "432m34");
        driverService.create(bill);
        driverService.create(john);
        List<Driver> drivers = driverService.getAll();
        drivers.stream()
                        .forEach(System.out::println);
        driverService.get(john.getId());
        bill.setLicenseNumber("453m11");
        driverService.update(bill);
        System.out.println(driverService.get(bill.getId()));
        driverService.delete(bill.getId());
        System.out.println(driverService.get(bill.getId()));
    }
}
