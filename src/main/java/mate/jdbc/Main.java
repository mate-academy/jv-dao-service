package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);

        System.out.println("All: ");
        manufacturerService.getAll().forEach(System.out::println);
        // test method create()
        Manufacturer manufacturerRenault = new Manufacturer();
        manufacturerRenault.setName("Renault");
        manufacturerRenault.setCountry("France");
        manufacturerService.create(manufacturerRenault);
        System.out.println("After create:");
        manufacturerService.getAll().forEach(System.out::println);
        //test method get()
        System.out.println("Get:");
        System.out.println(manufacturerService.get(manufacturerRenault.getId()));
        // test method update()
        manufacturerRenault.setName("New Renault");
        manufacturerService.update(manufacturerRenault);
        System.out.println("After update:");
        manufacturerService.getAll().forEach(System.out::println);
        // test method delete()
        manufacturerService.delete(manufacturerRenault.getId());
        System.out.println("After delete:");
        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        System.out.println("All: ");
        driverService.getAll().forEach(System.out::println);
        // test method create()
        Driver driverBob = new Driver("Bob", "1234");
        driverService.create(driverBob);
        System.out.println("After create:");
        driverService.getAll().forEach(System.out::println);
        //test method get()
        System.out.println("Get:");
        System.out.println(driverService.get(driverBob.getId()));
        // test method update()
        driverBob.setLicenseNumber("56789");
        driverService.update(driverBob);
        System.out.println("After update:");
        driverService.getAll().forEach(System.out::println);
        // test method delete()
        driverService.delete(driverBob.getId());
        System.out.println("After delete:");
        driverService.getAll().forEach(System.out::println);
    }
}
