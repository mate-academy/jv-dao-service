package mate.jdbc;

import mate.jdbc.dao.DriverDao;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;
import mate.jdbc.service.impl.DriverServiceImpl;
import mate.jdbc.service.impl.ManufacturerServiceImpl;

import java.util.Optional;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

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

        Driver firstDriver = new Driver();
        firstDriver.setName("Mark");
        firstDriver.setLicenseNumber("71777");
        Driver driverMark = driverService.create(firstDriver);
        Driver secondDriver = new Driver();
        secondDriver.setName("Bibbity");
        secondManufecturer.setCountry("New Zeeland");
        Driver driverBibbity = driverService.create(secondDriver);
        driverService.getAll().forEach(System.out::println);
        driverService.delete(driverMark.getId());
        secondDriver.setName("Bilbo");
        driverService.update(secondDriver);



    }
}
