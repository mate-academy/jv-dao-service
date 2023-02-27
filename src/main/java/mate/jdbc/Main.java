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
        System.out.println("\t\tManufacturerService test methods");
        manufacturerService.getAll().forEach(System.out::println);
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Koller");
        manufacturer.setCountry("Argentina");
        System.out.println("Create: " + manufacturerService.create(manufacturer));
        System.out.println("Get: " + manufacturerService.get(2L));
        manufacturer.setName("Ford");
        manufacturer.setId(3L);
        manufacturer.setCountry("United States");
        System.out.println("Update: " + manufacturerService.update(manufacturer));
        System.out.println("Delete: " + manufacturerService.delete(manufacturer.getId()));
        System.out.println("\t\tDriverService test methods");
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver andreaDriver = new Driver();
        andreaDriver.setName("Andrea Adkins");
        andreaDriver.setLicenseNumber("M7421392");
        System.out.println("Create: " + driverService.create(andreaDriver));
        System.out.println("Get: " + driverService.get(3L));
        System.out.println("Create with the same license: " + driverService.create(andreaDriver));
        driverService.delete(4L);
        Driver updateDriver = driverService.get(5L);
        updateDriver.setName("Kian Jarvis");
        System.out.println("Update: " + driverService.update(updateDriver));
        System.out.println("Delete: " + driverService.delete(3L));
        driverService.getAll().forEach(System.out::println);
    }
}
