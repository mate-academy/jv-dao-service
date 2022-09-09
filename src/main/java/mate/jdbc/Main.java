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
        Manufacturer tatra = new Manufacturer();
        tatra.setName("Tatra");
        tatra.setCountry("Czech Republic");
        manufacturerService.create(tatra);

        Manufacturer volvo = new Manufacturer();
        volvo.setName("Volvo");
        volvo.setCountry("Sweden");
        manufacturerService.create(volvo);

        Manufacturer ferrari = new Manufacturer();
        ferrari.setName("Ferrari");
        ferrari.setCountry("Italy");
        manufacturerService.create(ferrari);

        Manufacturer bentley = new Manufacturer();
        bentley.setName("Bentley");
        bentley.setCountry("United Kingdom");
        manufacturerService.create(bentley);

        Manufacturer jaguar = new Manufacturer();
        jaguar.setName("Jaguar");
        jaguar.setCountry("United Kingdom");
        manufacturerService.create(jaguar);
        System.out.println("Added: tatra, volvo, ferrari, bentley, jaguar");

        List<Manufacturer> manufacturers = manufacturerService.getAll();
        manufacturers.forEach(System.out::println);
        System.out.println("All manufacturers from db");

        tatra.setName("Praga");
        tatra = manufacturerService.update(tatra);
        System.out.println("Tatra was changed to Praga");

        System.out.println(manufacturerService.get(tatra.getId()));
        System.out.println("Manufacturer id = " + tatra.getId());

        manufacturerService.delete(jaguar.getId());
        System.out.println("Jaguar was deleted");

        manufacturers = manufacturerService.getAll();
        System.out.println("All manufacturers from db:");
        manufacturers.forEach(System.out::println);
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        Driver pragaDriver = new Driver();
        pragaDriver.setName("Valdemar");
        pragaDriver.setLicenseNumber("A1-324-675-178-980");
        driverService.create(pragaDriver);

        Driver volvoDriver = new Driver();
        volvoDriver.setName("Anna");
        volvoDriver.setLicenseNumber("A1-354-664-179-180");
        driverService.create(volvoDriver);

        Driver ferrariDriver = new Driver();
        ferrariDriver.setName("Andrew");
        ferrariDriver.setLicenseNumber("A1-374-464-279-136");
        driverService.create(ferrariDriver);

        Driver bentleyDriver = new Driver();
        bentleyDriver.setName("Edward");
        bentleyDriver.setLicenseNumber("A1-974-264-779-132");
        driverService.create(bentleyDriver);
        
        System.out.println("Added: tatraDriver, volvoDriver, " + "ferrariDriver, bentleyDriver");

        List<Driver> drivers = driverService.getAll();
        System.out.println("All drivers from db:");
        drivers.forEach(System.out::println);

        pragaDriver.setName("Alice");
        pragaDriver = driverService.update(pragaDriver);
        System.out.println("tatraDriver name was changed to Alice");

        System.out.println(driverService.get(pragaDriver.getId()));
        System.out.println("Driver with id = " + pragaDriver.getId());
        driverService.delete(bentleyDriver.getId());
        System.out.println("bentleyDriver was deleted");

        drivers = driverService.getAll();
        System.out.println("All drivers from db:");
        drivers.forEach(System.out::println);
    }
}
