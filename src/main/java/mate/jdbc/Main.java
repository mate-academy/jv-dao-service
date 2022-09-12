package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.driverservice.DriverService;
import mate.jdbc.service.manufacturerservice.ManufacturerService;

public class Main {
    public static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        //Manufacturer service
        final ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);

        //**create Manufacturer
        Manufacturer manufacturerAudi = new Manufacturer();
        manufacturerAudi.setName("Audi");
        manufacturerAudi.setCountry("Germany");
        Manufacturer manufacturerBmv = new Manufacturer();
        manufacturerBmv.setName("BMW");
        manufacturerBmv.setCountry("Germany");
        Manufacturer manufacturerJaguar = new Manufacturer();
        manufacturerJaguar.setName("Jaguar");
        manufacturerJaguar.setCountry("England");
        Manufacturer manufacturerAudiCreated = manufacturerService.create(manufacturerAudi);
        Manufacturer manufacturerBmvCreated = manufacturerService.create(manufacturerBmv);
        Manufacturer manufacturerJaguarCreated = manufacturerService.create(manufacturerJaguar);
        System.out.println(manufacturerAudiCreated);
        System.out.println(manufacturerBmvCreated);
        System.out.println(manufacturerJaguarCreated);

        //**update Manufacturer
        Manufacturer manufacturerLexus = new Manufacturer();
        manufacturerLexus.setName("Lexus");
        manufacturerLexus.setCountry("Japan");
        manufacturerLexus.setId(3L);
        Manufacturer manufacturerUpdated = manufacturerService.update(manufacturerLexus);
        System.out.println(manufacturerUpdated);

        //**delete Manufacturer
        boolean isManufacturerDeleted = manufacturerService.delete(1L);
        System.out.println(isManufacturerDeleted);

        //**get Manufacturer
        Manufacturer manufacturerGot = manufacturerService.get(2L);
        System.out.println(manufacturerGot);

        //**get all Manufacturers
        List<Manufacturer> allManufacturers = manufacturerService.getAll();
        allManufacturers.forEach(System.out::println);

        //Driver service
        final DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);

        //**create Driver
        Driver driverBob = new Driver();
        driverBob.setName("Bob");
        driverBob.setLicenseNumber("b111");
        Driver driverTom = new Driver();
        driverTom.setName("Tom");
        driverTom.setLicenseNumber("t222");
        Driver driverAlex = new Driver();
        driverAlex.setName("Alex");
        driverAlex.setLicenseNumber("a333");
        Driver driverBobCreated = driverService.create(driverBob);
        Driver driverTomCreated = driverService.create(driverTom);
        Driver driverAlexCreated = driverService.create(driverAlex);
        System.out.println(driverBobCreated);
        System.out.println(driverTomCreated);
        System.out.println(driverAlexCreated);

        //**update Driver
        Driver driverMax = new Driver();
        driverMax.setName("Max");
        driverMax.setLicenseNumber("m444");
        driverMax.setId(3L);
        Driver driverUpdated = driverService.update(driverMax);
        System.out.println(driverUpdated);

        //**delete Driver
        boolean isDriverDeleted = driverService.delete(1L);
        System.out.println(isManufacturerDeleted);

        //**get Driver
        Driver driverGot = driverService.get(2L);
        System.out.println(driverGot);

        //**get all Drivers
        List<Driver> allDrivers = driverService.getAll();
        allDrivers.forEach(System.out::println);
    }
}
