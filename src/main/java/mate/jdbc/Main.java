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
        Manufacturer manufacturerCreate = new Manufacturer();
        manufacturerCreate.setName("Toyota");
        manufacturerCreate.setCountry("Germany");
        System.out.println(manufacturerService.create(manufacturerCreate));
        //get
        System.out.println("Get a manufacturer");
        System.out.println(manufacturerService.get(2L));
        //getAll
        System.out.println("Get all manufacturers");
        System.out.println(manufacturerService.getAll());
        //update
        System.out.println("Update a manufacturer");
        Manufacturer manufacturerUpdate = new Manufacturer();
        manufacturerUpdate.setName("Volvo");
        manufacturerUpdate.setCountry("Italy");
        manufacturerUpdate.setId(1L);
        System.out.println(manufacturerService.update(manufacturerUpdate));
        //delete
        System.out.println("Delete a manufacturer");
        System.out.println(manufacturerService.delete(4L));

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        //create
        Driver driverCreate = new Driver();
        driverCreate.setName("Peter");
        driverCreate.setLicenseNumber("Y6479");
        System.out.println(driverService.create(driverCreate));
        //get
        System.out.println("Get a driver");
        System.out.println(driverService.get(4L));
        //getAll
        System.out.println("Get all drivers");
        System.out.println(driverService.getAll());
        //update
        System.out.println("Update a driver");
        Driver driverUpdate = new Driver();
        driverUpdate.setName("Jack");
        driverUpdate.setLicenseNumber("Y1111");
        driverUpdate.setId(1L);
        System.out.println(driverService.update(driverUpdate));
        //delete
        System.out.println("Delete a driver");
        System.out.println(driverService.delete(2L));
    }
}
