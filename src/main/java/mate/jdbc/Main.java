package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);

        Manufacturer tesla = new Manufacturer("Tesla", "USA");
        Manufacturer mercedes = new Manufacturer("Mercedes-Benz", "Germany");
        Manufacturer generalMotors = new Manufacturer("General Motors", "USA");

        manufacturerService.create(tesla);
        manufacturerService.create(mercedes);
        manufacturerService.create(generalMotors);
        manufacturerService.getAll().forEach(System.out::println);

        mercedes.setName("Mercedes");
        manufacturerService.update(mercedes);
        manufacturerService.getAll().forEach(System.out::println);

        System.out.println(manufacturerService.get(tesla.getId()));

        manufacturerService.delete(generalMotors.getId());
        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);

        Driver maria = new Driver("Maria", "87654356789");
        Driver ivan = new Driver("Ivan", "346572222");
        Driver mikhail = new Driver("Mikhail", "8763567987");
        Driver anna = new Driver("Anna", "098765345678");

        driverService.create(maria);
        driverService.create(ivan);
        driverService.create(mikhail);
        driverService.create(anna);
        driverService.getAll().forEach(System.out::println);

        mikhail.setLicenseNumber("765456789");
        driverService.update(mikhail);

        System.out.println(driverService.get(mikhail.getId()));

        driverService.delete(ivan.getId());
        driverService.getAll().forEach(System.out::println);
    }
}
