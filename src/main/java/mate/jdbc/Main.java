package mate.jdbc;

import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.ManufacturerService;
import mate.jdbc.service.ManufacturerServiceImpl;

public class Main {
    public static void main(String[] args) {
        /*DriverService driverService = new DriverServiceImpl();
        Driver testDriver1 = new Driver(null, "Bob", "025164");
        Driver testDriver2 = new Driver(null, "Jon", "421548");
        Driver updateDriver1 = new Driver(5L,"Bob", "000666");
        //driverService.create(testDriver1);
        //driverService.create(testDriver2);
        //driverService.update(updateDriver1);
        //System.out.println(driverService.get(5L));
        driverService.delete(6L);
        driverService.getAll().forEach(System.out::println);
*/
        ManufacturerService manufacturerService = new ManufacturerServiceImpl();
        Manufacturer testManufacturer1 = new Manufacturer(null, "TOYOTA", "JAPAN");
        Manufacturer testManufacturer2 = new Manufacturer(null, "GMC", "USA");
        Manufacturer updateManufacturer = new Manufacturer(9L, "FORD", "USA");
        //manufacturerService.create(testManufacturer1);
        //manufacturerService.create(testManufacturer2);
        manufacturerService.update(updateManufacturer);
        //System.out.println(manufacturerService.get(12L));
        //manufacturerService.delete(12L);
        manufacturerService.getAll().forEach(System.out::println);

    }
}
