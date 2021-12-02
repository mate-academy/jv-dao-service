package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        System.out.println("*Create 3 drivers");
        Driver driver1 = driverService.create(new Driver("Andrew","ee12345qq"));
        System.out.println("Driver 1 - " + driver1);
        Driver driver2 = driverService.create(new Driver("Bob","ee12344qw"));
        System.out.println("Driver 2 - " + driver2);
        Driver driver3 = driverService.create(new Driver("Nick","nn23345q"));
        System.out.println("Driver 3 - " + driver3);
        System.out.println(System.lineSeparator() + "*Get " + driver1 + " by id:"
                + System.lineSeparator() + driverService.get(driver1.getId()));
        System.out.println(System.lineSeparator() + "*Update license for" + driver2 + ":");
        driver2.setLicenseNumber("as33311fs");
        System.out.println(driverService.update(driver2));
        System.out.println(System.lineSeparator() + "*Delete driver " + driver1);
        driverService.delete(driver1.getId());
        System.out.println(System.lineSeparator() + "*Entries in data base ");
        driverService.getAll().forEach(System.out::println);
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        System.out.println("*Create 3 manufactures");
        Manufacturer manufacturer1 = manufacturerService
                .create(new Manufacturer("BMW","Germany"));
        System.out.println("Manufacturer 1 - " + manufacturer1);
        Manufacturer manufacturer2 = manufacturerService
                .create(new Manufacturer("Toyota","Japan"));
        System.out.println("Manufacturer 2 - " + manufacturer2);
        Manufacturer manufacturer3 = manufacturerService
                .create(new Manufacturer("Cherry","China"));
        System.out.println("Manufacturer 3 - " + manufacturer3);
        System.out.println(System.lineSeparator() + "*Get " + manufacturer1 + " by id:"
                + System.lineSeparator() + manufacturerService.get(manufacturer1.getId()));
        System.out.println(System.lineSeparator() + "*Update name for " + manufacturer2 + ":");
        manufacturer2.setName("ToYota");
        System.out.println(manufacturerService.update(manufacturer2));
        System.out.println(System.lineSeparator() + "*Delete manufacturer " + manufacturer1);
        manufacturerService.delete(manufacturer1.getId());
        System.out.println(System.lineSeparator() + "*Entries in data base ");
        manufacturerService.getAll().forEach(System.out::println);
    }
}
