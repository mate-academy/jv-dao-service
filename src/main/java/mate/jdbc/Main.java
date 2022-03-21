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
        Manufacturer bmw = new Manufacturer();
        bmw.setName("BMW");
        bmw.setCountry("Germany");
        Manufacturer mercedes = new Manufacturer();
        mercedes.setName("Mercedes");
        mercedes.setCountry("Germany");
        Manufacturer porsche = new Manufacturer();
        porsche.setName("Porsche");
        porsche.setCountry("Germany");
        Manufacturer mitsubishi = new Manufacturer();
        mitsubishi.setName("Mitsubishi");
        mitsubishi.setCountry("Japan");
        Manufacturer lamborghini = new Manufacturer();
        lamborghini.setName("Lamborghini");
        lamborghini.setCountry("Italia");
        Driver bob = new Driver();
        bob.setName("Bob");
        bob.setLicenseNumber("124_312_3323");
        Driver alice = new Driver();
        alice.setName("Alice");
        alice.setLicenseNumber("354_324_7343");
        Driver john = new Driver();
        john.setName("John");
        john.setLicenseNumber("562_234_4562");
        Driver marta = new Driver();
        marta.setName("Marta");
        marta.setLicenseNumber("173_373_3236");
        Driver anton = new Driver();
        anton.setName("Anton");
        anton.setLicenseNumber("642_543_5425");
        /**
         * Loading columns in tables 'manufacturer' and 'drivers'
         * using methods 'create' in the services 'DriverService' And 'ManufacturedService'.
         */
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        manufacturerService.create(bmw);
        manufacturerService.create(mercedes);
        manufacturerService.create(porsche);
        manufacturerService.create(mitsubishi);
        DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);
        driverService.create(bob);
        driverService.create(alice);
        driverService.create(john);
        driverService.create(marta);
        /**
         * Check how the tables is filled, using the method 'getAll',
         * from 'DriverService' and 'ManufacturerService'.
         */
        System.out.println("All drivers in table 'drivers'");
        List<Driver> driversList = driverService.getAll();
        for (Driver driver: driversList) {
            System.out.println(driver);
        }
        System.out.println(System.lineSeparator());
        System.out.println("All manufacturer in table 'manufacturer'");
        List<Manufacturer> manufacturerList = manufacturerService.getAll();
        for (Manufacturer manufacturer: manufacturerList) {
            System.out.println(manufacturer);
        }
        System.out.println(System.lineSeparator());
        /**
         * We change the value in the tables by 'id' by the 'update' method,
         * from 'DriversService' and 'ManufacturerService'
         * and check the changes with the 'get' method from the same classes.
         */
        System.out.println("Are there any values for these id");
        System.out.println(manufacturerService.get(mercedes.getId()));
        System.out.println(driverService.get(alice.getId()));
        System.out.println(System.lineSeparator());
        lamborghini.setId(mercedes.getId());
        anton.setId(alice.getId());
        manufacturerService.update(lamborghini);
        driverService.update(anton);
        System.out.println("Are there any values for these id after 'update;");
        System.out.println(manufacturerService.get(mercedes.getId()));
        System.out.println(driverService.get(alice.getId()));
        System.out.println(System.lineSeparator());
        /**
         *Delete data from the table 'drivers' and 'manufacturers'
         * using the method 'delete' from 'DriversService' and 'ManufacturerService,
         * and check using the method 'getAll' by the same class.
         */
        System.out.println("Have the values by id been deleted?");
        System.out.println(manufacturerService.delete(porsche.getId()));
        System.out.println(driverService.delete(john.getId()));
        System.out.println(System.lineSeparator());
        manufacturerList = manufacturerService.getAll();
        driversList = driverService.getAll();
        System.out.println("What manufacturers left after 'delete'");
        for (Manufacturer manufacturer: manufacturerList) {
            System.out.println(manufacturer);
        }
        System.out.println(System.lineSeparator());
        System.out.println("What driver left after 'delete'");
        for (Driver driver: driversList) {
            System.out.println(driver);
        }
    }
}
