package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final String MAIN_PACKAGE_NAME = "mate.jdbc";
    private static final Injector injector = Injector.getInstance(MAIN_PACKAGE_NAME);

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer micro = new Manufacturer();
        micro.setName("Micro car");
        micro.setCountry("France");
        manufacturerService.create(micro);

        Manufacturer ferrari = new Manufacturer();
        ferrari.setName("Ferrari");
        ferrari.setCountry("Italy");
        manufacturerService.create(ferrari);

        Manufacturer bentley = new Manufacturer();
        bentley.setName("Bentley");
        bentley.setCountry("United Kingdom");
        manufacturerService.create(bentley);

        System.out.println("Added: micro, ferrari");

        List<Manufacturer> manufacturers = manufacturerService.getAll();
        manufacturers.forEach(System.out::println);
        System.out.println("All manufacturers from db");

        micro.setName("Praga");
        micro = manufacturerService.update(micro);
        System.out.println("Micro car was changed to Praga");

        System.out.println(manufacturerService.get(micro.getId()));
        System.out.println("Manufacturer id = " + micro.getId());

        manufacturerService.delete(ferrari.getId());
        System.out.println("Ferrari was deleted");

        manufacturers = manufacturerService.getAll();
        System.out.println("All manufacturers from db:");
        manufacturers.forEach(System.out::println);
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        Driver pragaDriver = new Driver();
        pragaDriver.setName("Aang");
        pragaDriver.setLicenseNumber("1-111");
        driverService.create(pragaDriver);

        Driver microDriver = new Driver();
        microDriver.setName("Zuko");
        microDriver.setLicenseNumber("1-222");
        driverService.create(microDriver);

        Driver bentleyDriver = new Driver();
        bentleyDriver.setName("Sokka");
        bentleyDriver.setLicenseNumber("1-333");
        driverService.create(bentleyDriver);

        System.out.println("Added: pragaDriver, microDriver, bentleyDriver");

        List<Driver> drivers = driverService.getAll();
        System.out.println("All drivers from db:");
        drivers.forEach(System.out::println);

        pragaDriver.setName("Katara");
        pragaDriver = driverService.update(pragaDriver);
        System.out.println("tatraDriver name was changed to Katara");

        System.out.println(driverService.get(pragaDriver.getId()));
        System.out.println("Driver with id = " + pragaDriver.getId());
        driverService.delete(bentleyDriver.getId());
        System.out.println("bentleyDriver was deleted");

        drivers = driverService.getAll();
        System.out.println("All drivers from db:");
        drivers.forEach(System.out::println);
    }
}
