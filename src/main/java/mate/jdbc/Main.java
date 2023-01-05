package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        // get all test (worked)
        System.out.println(driverService.getAll());
        //get by index (worked)
        System.out.println(driverService.get(2L));
        //get by index (with is_deleted = TRUE) (thrown nosuchelementexp)
        System.out.println(driverService.get(3L));
        //create new driver (worked)
        Driver driverBogdan = new Driver();
        driverBogdan.setName("Bogdan");
        driverBogdan.setLicenseNumber("229932");
        driverBogdan = driverService.create(driverBogdan);
        System.out.println(driverBogdan);
        //update bogdan driver (worked)
        driverBogdan.setLicenseNumber("1245362");
        System.out.println(driverService.update(driverBogdan));
        //delete bogdan driver :( (worked...)
        System.out.println(driverService.delete(driverBogdan.getId()));
    }
}
