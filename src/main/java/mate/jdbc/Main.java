package mate.jdbc;

import java.util.List;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;
import mate.jdbc.service.impl.DriverServiceImpl;

public class Main {
    public static void main(String[] args) {
        Injector injector = Injector.getInstance("mate.jdbc");
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driverOleg = new Driver("Oleg", "GH851678");
        Driver driverJhon = new Driver("Jhon", "FI841687");
        //driverService.create(driverOleg);
        //driverService.create(driverJhon);
        List<Driver> listOfDrivers = driverService.getAll();
        System.out.println(listOfDrivers);
        listOfDrivers.get(0);
        ManufacturerService manufacturerService = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        System.out.println(manufacturerService.get(listOfDrivers.get(0).getId()));
        List<Manufacturer> listOfManufaturers = manufacturerService.getAll();
        System.out.println(listOfManufaturers);
        //manufacturerService.delete(13L);
        //manufacturerService.delete(12L);
        //manufacturerService.delete(11L);
        //manufacturerService.delete(10L);
        //manufacturerService.delete(9L);
        //manufacturerService.delete(8L);
        List<Manufacturer> listOfManufacturersAfter = manufacturerService.getAll();
        System.out.println(listOfManufacturersAfter);
    }
}
