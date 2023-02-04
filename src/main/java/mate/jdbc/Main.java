package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    public static void main(String[] args) {
        Injector injector = Injector.getInstance("mate.jdbc");
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        ManufacturerService manufacturerService = 
                (ManufacturerService) injector.getInstance(ManufacturerService.class);

        System.out.println("Driver service test:");
        for (int i = 0; i < 2; i++) {
            driverService.create(new Driver(null, "driver" + (i + 1), "license" + (i + 1)));
        }
        System.out.println(driverService.get(1L));
        driverService.getAll().forEach(System.out::println);
        System.out.println(driverService.update(new Driver(2L, 
                "updatedDriver", "updatedLicense")));
        System.out.println(driverService.delete(1L));
        try {
            driverService.get(1L);
        } catch (RuntimeException e) {
            System.out.println("User not found exception should be here");
        }

        System.out.println("Manufacturer service test:");
        for (int i = 0; i < 2; i++) {
            manufacturerService.create(new Manufacturer(null, 
                    "manufacturer" + (i + 1), "country" + (i + 1)));
        }
        System.out.println(manufacturerService.get(1L));
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println(manufacturerService.update(new Manufacturer(2L, 
                "updatedManufacturer", "updatedCountry")));
        System.out.println(manufacturerService.delete(1L));
        try {
            manufacturerService.get(1L);
        } catch (RuntimeException e) {
            System.out.println("User not found exception should be here");
        }
    }
}
