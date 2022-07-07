package mate.jdbc;

import mate.jdbc.dao.DriverDao;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

import java.util.Optional;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc.service.impl");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService) injector.getInstance((ManufacturerService.class));
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);


        Manufacturer firstManufacturer = new Manufacturer();
        firstManufacturer.setName("Bob");
        firstManufacturer.setCountry("Moon");
        Manufacturer manufacturerBob = manufacturerService.create(firstManufacturer);
        Manufacturer secondManufecturer = new Manufacturer();
        secondManufecturer.setName("Jimmy");
        secondManufecturer.setCountry("Australia");
        Manufacturer manufacturerJimmy = manufacturerService.create(secondManufecturer);
        manufacturerService.getAll().forEach(System.out::println);
        manufacturerService.delete(manufacturerBob.getId());
        secondManufecturer.setName("Bilbo");
        manufacturerService.update(secondManufecturer);



    }
}
