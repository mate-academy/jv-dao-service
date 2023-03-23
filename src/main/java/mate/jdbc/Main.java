package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final ManufacturerService manufacturerService =
            (ManufacturerService) injector.getInstance(ManufacturerService.class);
    private static final DriverService driverService =
            (DriverService) injector.getInstance(DriverService.class);

    public static void main(String[] args) {
        testDriverService();
        testManufacturerService();
    }

    private static void testManufacturerService() {
        // Create new manufacturers
        Manufacturer toyota = new Manufacturer(null,"Toyota", "Japan");
        Manufacturer kia = new Manufacturer(null,"KIA", "South Korea");
        // Test: Write manufacturers to DB
        System.out.println("Create toyota in DB : " + manufacturerService.create(toyota));
        System.out.println("Create KIA in DB : " + manufacturerService.create(kia));
        // Test: Read manufacturers which wrote previously
        System.out.println("Get from db Toyota : " + manufacturerService.get(toyota.getId()));
        System.out.println("Get from db KIA : " + manufacturerService.get(kia.getId()));
        // Test: Read all manufacturers from db
        System.out.println("getAll : " + manufacturerService.getAll());
        //Change name and country in manufacturer
        kia.setCountry("USA");
        kia.setName("kia");
        toyota.setCountry("Ukraine");
        toyota.setName("TOYOTA");
        //Update data in DB
        System.out.println("Update country and name in KIA : "
                + manufacturerService.update(kia));
        System.out.println("Update country and name in TOYOTA : "
                + manufacturerService.update(toyota));
        // Test: Read all manufacturers from db with new name and country
        System.out.println("getAll : " + manufacturerService.getAll());
        // Test: Delete data from DB
        System.out.println("delete kia from db : " + manufacturerService.delete(kia.getId()));
        System.out.println("delete TOYOTA from db : " + manufacturerService.delete(toyota.getId()));
        // Test: Read all manufacturers from db after deleted
        System.out.println("getAll after delete: " + manufacturerService.getAll());
        //Change name and country in manufacturer
        kia.setCountry("SOUTH KOREA");
        kia.setName("KIA");
        toyota.setCountry("JAPAN");
        toyota.setName("toyota");
        //Test: Update after delete
        System.out.println("Update after delete KIA from DB : "
                + manufacturerService.update(kia));
        System.out.println("Update after delete TOYOTA from DB : "
                + manufacturerService.update(toyota));
        // Test: Read all manufacturers from db after deleted and tried update
        System.out.println("getAll after delete: " + manufacturerService.getAll());
    }

    private static void testDriverService() {
        // Create new manufacturers
        Driver bob = new Driver(null,"bob", "1111");
        Driver sem = new Driver(null,"sem", "2222");
        // Test: Write manufacturers to DB
        System.out.println("Create toyota in DB : " + driverService.create(bob));
        System.out.println("Create KIA in DB : " + driverService.create(sem));
        // Test: Read manufacturers which wrote previously
        System.out.println("Get from db Toyota : " + driverService.get(bob.getId()));
        System.out.println("Get from db KIA : " + driverService.get(sem.getId()));
        // Test: Read all manufacturers from db
        System.out.println("getAll : " + driverService.getAll());
        //Change name and country in manufacturer
        bob.setLicenseNumber("1");
        bob.setName("BOB");
        sem.setLicenseNumber("2");
        sem.setName("SEM");
        //Update data in DB
        System.out.println("Update country and name in KIA : " + driverService.update(bob));
        System.out.println("Update country and name in TOYOTA : " + driverService.update(sem));
        // Test: Read all manufacturers from db with new name and country
        System.out.println("getAll : " + driverService.getAll());
        // Test: Delete data from DB
        System.out.println("delete kia from db : " + driverService.delete(bob.getId()));
        System.out.println("delete TOYOTA from db : " + driverService.delete(sem.getId()));
        // Test: Read all manufacturers from db after deleted
        System.out.println("getAll after delete: " + driverService.getAll());
        //Change name and country in manufacturer
        bob.setLicenseNumber("1111");
        bob.setName("bob");
        sem.setLicenseNumber("2222");
        sem.setName("sem");
        //Test: Update after delete
        System.out.println("Update after delete KIA from DB : "
                + driverService.update(bob));
        System.out.println("Update after delete TOYOTA from DB : "
                + driverService.update(sem));
        // Test: Read all manufacturers from db after deleted and tried update
        System.out.println("getAll after delete: " + driverService.getAll());
    }
}
