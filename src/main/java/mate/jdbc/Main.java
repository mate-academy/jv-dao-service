package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        // test your code here
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);

        System.out.println("*** Step 1. Get all manufacturer");
        for (Manufacturer manufacturer: manufacturerService.getAll()) {
            System.out.println(manufacturer);
        }

        System.out.println("*** Step 2. Insert drivers");
        Driver martin = new Driver(null, "Frank Martin", "BD2 MGF 06");
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        martin = driverService.create(martin);
        System.out.println(martin);
        Driver morales = new Driver(null, "Daniel Morales", "724 LNB 13");
        morales = driverService.create(morales);
        System.out.println(morales);
        Driver torreto = new Driver(null, "Dominic Toretto", "JSM 586");
        torreto = driverService.create(torreto);
        System.out.println(torreto);

        System.out.println("*** Step 3. Get all drivers");
        for (Driver driver: driverService.getAll()) {
            System.out.println(driver);
        }

        System.out.println("*** Step 4. Update driver");
        morales.setLicenseNumber("2001 ZY 13");
        morales = driverService.update(morales);
        System.out.println(morales);

        System.out.println("*** Step 5. Delete driver");
        System.out.println(driverService.delete(torreto.getId()));
    }
}
