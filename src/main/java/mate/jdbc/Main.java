package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        //ManufacturerService Test

        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);

        System.out.println("Create manufacturers");
        Manufacturer bmw = new Manufacturer("bmw", "Germany");
        manufacturerService.create(bmw);

        Manufacturer tesla = new Manufacturer("tesla", "USA");
        manufacturerService.create(tesla);

        Manufacturer volkswagen = new Manufacturer("volkswagen", "Germany");
        manufacturerService.create(volkswagen);

        System.out.println("Get all manufacturers");
        manufacturerService.getAll().forEach(System.out::println);

        System.out.println("Set country to manufacturer");
        bmw.setCountry("Ukraine");
        manufacturerService.update(bmw);

        System.out.println(manufacturerService.get(bmw.getId()));

        System.out.println("Delete manufacturer bmw");
        manufacturerService.delete(bmw.getId());

        System.out.println("Get all manufacturers after delete");
        manufacturerService.getAll().forEach(System.out::println);

        //DriverService Test

        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);

        System.out.println("Create drivers: ");
        Driver misha = new Driver(null, "Mikhayl", "856512");
        driverService.create(misha);

        Driver andrew = new Driver(null, "Andrew", "85631321");
        driverService.create(andrew);

        System.out.println("Get all drivers");
        driverService.getAll().forEach(System.out::println);

        System.out.println("Set license_number to driver");
        andrew.setLicenseNumber("219546");
        driverService.update(andrew);

        System.out.println("Delete driver misha");
        driverService.delete(misha.getId());

        System.out.println("Get all drivers after delete");
        driverService.getAll().forEach(System.out::println);
    }
}
