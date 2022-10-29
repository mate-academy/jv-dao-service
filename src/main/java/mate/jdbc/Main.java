package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;
import mate.jdbc.service.impl.ManufactureServiceImpl;

public class Main {

    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver driver1 = new Driver();
        driver1.setName("Kate");
        driver1.setLicenseNumber("3k1hl4kj32h41kl2j");
        Driver driver1Update = new Driver();
        driver1Update.setName("Roma");
        driver1Update.setLicenseNumber("UpdateLicenseNumber123");
        Driver driver2 = new Driver();
        driver2.setName("Bob");
        driver2.setLicenseNumber("423j5hkljdsahl");
        Driver driver3 = new Driver();
        driver3.setName("John");
        driver3.setLicenseNumber("hdsaf9ahdflkas");

        Manufacturer manufacturer1 = new Manufacturer();
        manufacturer1.setCountry("USA");
        manufacturer1.setName("Ford");
        Manufacturer manufacturer2 = new Manufacturer();
        manufacturer2.setCountry("Japan");
        manufacturer2.setName("Toyota");
        Manufacturer manufacturer3 = new Manufacturer();
        manufacturer3.setCountry("Britain");
        manufacturer3.setName("Jaguar");
        ManufacturerService manufacturerService = new ManufactureServiceImpl();
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        System.out.println("Creating drivers...");
        System.out.println(driverService.create(driver1));
        System.out.println(driverService.create(driver2));
        System.out.println(driverService.create(driver3));
        System.out.println("All drivers successfully created" + System.lineSeparator());

        System.out.println("Getting drivers...");
        System.out.println("Driver with id = 1 " + driverService.get(1L));
        System.out.println("Driver with id = 3 " + driverService.get(3L));
        System.out.println("Drivers with id = 1 AND 3 were getted successfully"
                + System.lineSeparator());

        System.out.println("Getting all drivers...");
        List<Driver> driverList = driverService.getAll();
        System.out.println("All drivers");
        for (Driver driver: driverList) {
            System.out.println(driver);
        }
        System.out.println("All drivers were successfully getted" + System.lineSeparator());

        System.out.println("Updating driver1...");
        driver1Update.setId(driver1.getId());
        System.out.println(driverService.update(driver1Update));
        System.out.println("Driver1 successfully updated" + System.lineSeparator());

        System.out.println("Deleting driver2");
        System.out.println(driverService.delete(driver2.getId()));
        System.out.println("Driver2 successfully deleted" + System.lineSeparator());

        System.out.println("All remain drivers" + driverService.getAll());
    }
}
