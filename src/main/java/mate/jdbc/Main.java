package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        /////create/////
        Manufacturer toyota = manufacturerService
                .create(new Manufacturer(null, "Toyota", "Japa"));
        System.out.println("savedManufacturer = " + toyota);
        /////get/////
        Manufacturer manufacturerToyota = manufacturerService.get(toyota.getId());
        System.out.println("manufacturerToyota = " + manufacturerToyota);
        /////update/////
        Manufacturer updateToyota = new Manufacturer(toyota.getId(), "Toyota", "Japan");
        Manufacturer update = manufacturerService.update(updateToyota);
        System.out.println("update = " + update);
        /////delete/////
        boolean isDeletedToyota = manufacturerService.delete(toyota.getId());
        System.out.println("deleteToyota = " + isDeletedToyota);
        /////getAll/////
        List<Manufacturer> manufacturers = manufacturerService.getAll();
        manufacturers.forEach(System.out::println);

        /////////////Driver////////////
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        /////create/////
        Driver bohdan = driverService
                .create(new Driver(null, "Bohdan", "321654987"));
        System.out.println("savedDriver = " + bohdan);
        /////get/////
        Driver driverBohdan = driverService.get(bohdan.getId());
        System.out.println("driverBohdan = " + driverBohdan);
        /////update/////
        Driver updateBohdan = new Driver(bohdan.getId(), "Bohdan", "951753654");
        Driver updatedDriver = driverService.update(updateBohdan);
        System.out.println("updatedDriver = " + updatedDriver);
        /////delete/////
        boolean isDeletedDriver = driverService.delete(bohdan.getId());
        System.out.println("deleteDriver = " + isDeletedDriver);
        /////getAll/////
        List<Driver> drivers = driverService.getAll();
        drivers.forEach(System.out::println);
    }
}
