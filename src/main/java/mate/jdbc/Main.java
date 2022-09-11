package mate.jdbc;

import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.DriverServiceImpl;

public class Main {
    public static void main(String[] args) {
        DriverService driverService = new DriverServiceImpl();
        Driver testDriver1 = new Driver(null, "Bob", "025164");
        Driver testDriver2 = new Driver(null, "Jon", "421548");
        Driver updateDriver1 = new Driver(5L,"Bob", "000666");
        //driverService.create(testDriver1);
        //driverService.create(testDriver2);
        //driverService.update(updateDriver1);
        //System.out.println(driverService.get(5L));
        driverService.delete(6L);
        driverService.getAll().forEach(System.out::println);
    }
}
