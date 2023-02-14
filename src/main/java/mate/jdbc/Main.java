package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.servise.DriverService;
import mate.jdbc.servise.ManufacturerService;

public class Main {
    private static final Injector injector =
            Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        //added driver to DB
        Driver driverRita = new Driver("Rita", "B1111");
        Driver driverOscar = new Driver("Oscar", "C1112");
        Driver driverMoony = new Driver("Moony", "A01");
        Driver driverGalo = new Driver("Galo", "D07");
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        driverService.create(driverRita);
        driverService.create(driverOscar);
        driverService.create(driverMoony);
        driverService.create(driverGalo);
        System.out.println("Added data to driver table:");
        List<Driver> driverList = driverService.getAll();
        driverList.forEach(System.out::println);
        //get driver by id and update it
        System.out.println("Get driver from DB by id = " + driverGalo.getId()
                + " and update info.");
        driverGalo.setLicenseNumber("B007");
        Driver updateDriverFirst = driverService.update(driverGalo);
        System.out.println(updateDriverFirst);
        //soft delete driver by id
        System.out.println("Data from DB after deleted drive by id = "
                + updateDriverFirst.getId());
        driverService.delete(updateDriverFirst.getId());
        driverService.getAll().forEach(System.out::println);
        //added manufacturers to DB
        System.out.println("Added manufacturers to DB:");
        Manufacturer manufacturerLincoln = new Manufacturer("Lincoln", "USA");
        Manufacturer manufacturerZaz = new Manufacturer("ZAZ", "Ukraine");
        Manufacturer manufacturerJeep = new Manufacturer("WrongName", "USA");
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        manufacturerService.create(manufacturerLincoln);
        manufacturerService.create(manufacturerZaz);
        manufacturerService.create(manufacturerJeep);
        manufacturerService.getAll().forEach(System.out::println);
        //get manufacturer from DB by id
        System.out.println("Get manufacturer from DB with id = "
                + manufacturerJeep.getId() + " and update its name");
        Manufacturer manufacturer = manufacturerService.get(manufacturerJeep.getId());
        manufacturer.setName("Jeep");
        System.out.println(manufacturerService.update(manufacturer));
        // soft delete manufacture from DB
        manufacturerService.delete(manufacturerZaz.getId());
        System.out.println("Data from DB without deleted manufacture id = "
                + manufacturerZaz.getId());
        manufacturerService.getAll().forEach(System.out::println);
    }
}
