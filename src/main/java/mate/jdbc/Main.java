package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.services.DriverService;
import mate.jdbc.services.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        //create
        Manufacturer toyotaManufacturer = new Manufacturer();
        toyotaManufacturer.setName("Toyota");
        toyotaManufacturer.setCountry("Germany");
        System.out.println(manufacturerService.create(toyotaManufacturer));
        //get
        System.out.println("Get a manufacturer");
        System.out.println(manufacturerService.get(toyotaManufacturer.getId()));
        //getAll
        System.out.println("Get all manufacturers");
        manufacturerService.getAll().forEach(System.out::println);
        //update
        System.out.println("Update a manufacturer");
        toyotaManufacturer.setName("Jeely");
        toyotaManufacturer.setCountry("China");
        toyotaManufacturer.setId(1L);
        System.out.println(manufacturerService.update(toyotaManufacturer));
        //delete
        System.out.println("Delete a manufacturer");
        System.out.println(manufacturerService.delete(4L));

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        //create
        Driver peterDriver = new Driver();
        peterDriver.setName("Peter");
        peterDriver.setLicenseNumber("Y6479");
        System.out.println(driverService.create(peterDriver));
        //get
        System.out.println("Get a driver");
        System.out.println(driverService.get(peterDriver.getId()));
        //getAll
        System.out.println("Get all drivers");
        driverService.getAll().forEach(System.out::println);
        //update
        System.out.println("Update a driver");
        peterDriver.setName("Jack");
        peterDriver.setLicenseNumber("Y1111");
        peterDriver.setId(1L);
        System.out.println(driverService.update(peterDriver));
        //delete
        System.out.println("Delete a driver");
        System.out.println(driverService.delete(2L));
    }
}
