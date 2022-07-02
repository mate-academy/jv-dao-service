package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        
        Manufacturer daewoo = new Manufacturer(null, "Daewoo", "Ukraine");
        Manufacturer rangeRover = new Manufacturer(null, "Range_Rover", "USA");
        Manufacturer honda = new Manufacturer(null, "Honda", "Japan");
        
        manufacturerService.create(daewoo);
        manufacturerService.create(rangeRover);
        manufacturerService.create(honda);
        manufacturerService.getAll().forEach(System.out::println);
        
        rangeRover.setCountry("Canada");
        
        manufacturerService.update(rangeRover);
        System.out.println(manufacturerService.get(rangeRover.getId()));
        manufacturerService.getAll().forEach(System.out::println);
        
        manufacturerService.delete(rangeRover.getId());
        manufacturerService.getAll().forEach(System.out::println);
    
        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);
        
        Driver johnLuck = new Driver(null, "John Luck", "AA 11111");
        Driver harryOstapenko = new Driver(null, "Harry Ostapenko", "BB 22222");
        Driver pavloBogdan = new Driver(null, "Pavlo Bogdan", "CC 33333");
        
        driverService.create(johnLuck);
        driverService.create(harryOstapenko);
        driverService.create(pavloBogdan);
        driverService.getAll().forEach(System.out::println);
        
        johnLuck.setLicenseNumber("DD 12345");
        
        driverService.update(johnLuck);
        System.out.println(driverService.get(johnLuck.getId()));
        driverService.getAll().forEach(System.out::println);
        
        driverService.delete(harryOstapenko.getId());
        driverService.getAll().forEach(System.out::println);
    }
}
