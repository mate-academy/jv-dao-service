package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");
    
    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        
        for (int i = 0; i < 3; i++) {
            Manufacturer bmw = new Manufacturer();
            bmw.setName("BMW - " + i);
            bmw.setCountry("Germany");
            manufacturerService.create(bmw);
            
            Manufacturer audi = new Manufacturer();
            audi.setName("AUDI - " + i);
            audi.setCountry("Germany");
            manufacturerService.create(audi);
    
            Driver driverBmv = new Driver();
            driverBmv.setName("Bob - " + i);
            driverBmv.setLicenseNumber("1" + i + "2" + i * 3);
            driverService.create(driverBmv);
            
            Driver driverAudi = new Driver();
            driverAudi.setName("Alice - " + i);
            driverAudi.setLicenseNumber("1" + i * 5 + "7" + i * 9);
            driverService.create(driverAudi);
        }
    
        manufacturerService.delete(2L);
        driverService.delete(4L);
        
        Manufacturer wv = new Manufacturer(3L, "Volkswagen", "Germany");
        manufacturerService.update(wv);
        
        Driver driver = new Driver(5L, "John", "123456789");
        driverService.update(driver);
        
        manufacturerService.getAll().forEach(System.out::println);
        driverService.getAll().forEach(System.out::println);
    }
}
