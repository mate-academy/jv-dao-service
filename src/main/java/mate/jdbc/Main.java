package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Manufacturer manufacturer1 = new Manufacturer("BMW", "Germany");
        Manufacturer manufacturer2 = new Manufacturer("Toyota", "Japan");
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        System.out.println("Create : " + manufacturerService.create(manufacturer1));
        System.out.println("Create : " + manufacturerService.create(manufacturer2));
        System.out.println("Get all: ");
        List<Manufacturer> manufacturers = manufacturerService.getAll();
        manufacturers.forEach(System.out::println);
        manufacturer1 = manufacturers.get(0);
        System.out.println("Get first : " + manufacturerService.get(manufacturer1.getId()));
        manufacturer1.setName("KIA");
        manufacturer1.setCountry("Korea");
        System.out.println("Update : " + manufacturerService.update(manufacturer1));
        System.out.println("Delete success: " + manufacturerService.delete(manufacturer1.getId()));
        System.out.println("Table after delete:");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("-------------------------------------------");
        Driver driver1 = new Driver("Ivan", "AA7777XA");
        Driver driver2 = new Driver("Petro", "BC1715CE");
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        System.out.println("Create : " + driverService.create(driver1));
        System.out.println("Create : " + driverService.create(driver2));
        System.out.println("Get all:");
        List<Driver> drivers = driverService.getAll();
        drivers.forEach(System.out::println);
        driver1 = drivers.get(0);
        System.out.println("Get first : " + driverService.get(driver1.getId()));
        driver1.setName("Petro");
        driver1.setLicenseNumber("AO1221BB");
        System.out.println("Update " + driverService.update(driver1));
        System.out.println("Delete success : " + driverService.delete(driver1.getId()));
        System.out.println("Table after delete:");
        driverService.getAll().forEach(System.out::println);
    }
}
