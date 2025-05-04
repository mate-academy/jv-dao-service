package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        testDriver();
        testManufacturer();
    }

    private static void testManufacturer() {
        Manufacturer firstManufacturer = new Manufacturer();
        firstManufacturer.setName("Dodge");
        firstManufacturer.setCountry("USA");
        Manufacturer secondManufacturer = new Manufacturer();
        secondManufacturer.setName("Tavria");
        secondManufacturer.setCountry("Ukraine");
        Manufacturer thirdManufacturer = new Manufacturer();
        thirdManufacturer.setName("Toyota");
        thirdManufacturer.setCountry("Japan");

        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);

        //create
        System.out.println(manufacturerService.create(firstManufacturer));
        System.out.println(manufacturerService.create(secondManufacturer));
        System.out.println(manufacturerService.create(thirdManufacturer));

        //get
        System.out.println("--------------------------------------");
        System.out.println(manufacturerService.get(firstManufacturer.getId()));

        //update
        System.out.println("--------------------------------------");
        secondManufacturer.setName(null);
        System.out.println(manufacturerService.update(secondManufacturer));

        //delete
        System.out.println("--------------------------------------");
        System.out.println(manufacturerService.delete(thirdManufacturer.getId()));

        //getAll
        injector.getInstance(ManufacturerService.class);
        manufacturerService.getAll().forEach(System.out::println);
    }

    private static void testDriver() {
        Driver firstDriver = new Driver();
        firstDriver.setName("Roman");
        firstDriver.setLicenseNumber("94869359");

        Driver secondDriver = new Driver();
        secondDriver.setName("Paul");
        secondDriver.setLicenseNumber("unlimited");

        Driver thirdDriver = new Driver();
        thirdDriver.setName("Zuhra");
        thirdDriver.setLicenseNumber(null);

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        //create
        injector.getInstance(DriverService.class);
        System.out.println(driverService.create(firstDriver));
        System.out.println(driverService.create(secondDriver));
        System.out.println(driverService.create(thirdDriver));

        //get
        System.out.println("--------------------------------------");
        System.out.println(driverService.get(secondDriver.getId()));

        //delete
        System.out.println("--------------------------------------");
        System.out.println(driverService.delete(firstDriver.getId()));
        driverService.getAll().forEach(System.out::println);

        //getAll
        System.out.println("--------------------------------------");
        driverService.getAll().forEach(System.out::println);

        //update
        System.out.println("--------------------------------------");
        thirdDriver.setLicenseNumber("1");
        System.out.println(driverService.update(thirdDriver));
    }
}
