package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final Driver DRIVER_A = new Driver("Vovan", "AE0001KM");
    private static final Driver DRIVER_B = new Driver("Salli", "AA6666AA");
    private static final Manufacturer MANUFACTURER_A = new Manufacturer("CADILLAC", "USA");
    private static final Manufacturer MANUFACTURER_B = new Manufacturer("LINCOLN", "USA");
    
    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        driverService.create(DRIVER_A);
        driverService.create(DRIVER_B);
        driverService.getAll().forEach(System.out::println);
        DRIVER_A.setName("Valentin");
        DRIVER_A.setLicenseNumber("AX1673MN");
        driverService.update(DRIVER_A);
        System.out.println(driverService.get(DRIVER_A.getId()));
        System.out.println(driverService.delete(DRIVER_A.getId()));
        driverService.getAll().forEach(System.out::println);
        
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        manufacturerService.create(MANUFACTURER_A);
        manufacturerService.create(MANUFACTURER_B);
        manufacturerService.getAll().forEach(System.out::println);
        MANUFACTURER_B.setCountry("UK");
        MANUFACTURER_B.setName("Range Rover");
        manufacturerService.update(MANUFACTURER_B);
        System.out.println(manufacturerService.get(MANUFACTURER_B.getId()));
        System.out.println(manufacturerService.delete(MANUFACTURER_B.getId()));
        manufacturerService.getAll().forEach(System.out::println);
    }
}
