package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        // test your code here
        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);
        Driver peter = new Driver("Peter","1234567");
        System.out.println("Create driver with name=Peter, licence number=1234567: "
                + driverService.create(peter));;
        Driver bob = new Driver("Bob","98765432");
        System.out.println("Create driver with name=Bob, licence number=98765432: "
                + driverService.create(bob));;
        System.out.println("Get driver peter: " + driverService
                .get(peter.getId()));;
        System.out.println("Get all drivers: " + driverService.getAll());;
        peter.setName("Mark");
        peter.setLicenseNumber("12131415");
        System.out.println("Update driver with name=Mark, licence number=12131415: "
                + driverService.update(peter));;
        System.out.println("Delete driver peter: "
                + driverService.delete(peter.getId()));
    }
}
