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

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Audi");
        manufacturer.setCountry("Germany");
        Manufacturer toyota = new Manufacturer(3L, "Toyota", "Japan");
        System.out.println(manufacturerService.create(manufacturer));
        System.out.println(manufacturerService.get(manufacturer.getId()));
        System.out.println(manufacturerService.delete(toyota.getId()));
        System.out.println(manufacturerService.update(new Manufacturer(3L, "BMW","Germany")));
        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        Driver driver1 = new Driver("Henry", "235674");
        Driver driver2 = new Driver("Franck", "8889989");
        System.out.println(driverService.create(driver1));
        System.out.println(driverService.create(driver2));
        System.out.println(driverService.get(driver2.getId()));
        System.out.println(driverService.delete(driver1.getId()));
        System.out.println(driverService.update(new Driver(2L,"Vlad","99A657")));
        driverService.getAll().forEach(System.out::println);
    }
}
