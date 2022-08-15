package mate.jdbc;

import mate.jdbc.model.Driver;
import mate.jdbc.services.DriverService;
import mate.jdbc.services.DriverServiceImpl;

public class Main {
    public static void main(String[] args) {
        Driver driverVasyl = new Driver("Vasyl Stupik", "12345678");
        Driver driverIgor = new Driver("Igor Dudnik", "22345678");
        DriverService driverService = new DriverServiceImpl();
        System.out.println(driverService.create(driverVasyl));
        System.out.println(driverService.get(driverVasyl.getId()).toString());
        System.out.println(driverService.create(driverIgor));
        System.out.println();
        driverService.getAll().forEach(System.out::println);
    }
}
