package mate.jdbc;

import mate.jdbc.dao.DriverDaoImpl;
import mate.jdbc.dao.ManufacturerDaoImpl;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.DriverServiceImpl;
import mate.jdbc.service.ManufacturerService;
import mate.jdbc.service.ManufacturerServiceImpl;

public class Main {
    private static final Injector injector
            = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Manufacturer manufacturerPeugeot = new Manufacturer();
        manufacturerPeugeot.setName("Peugeot");
        manufacturerPeugeot.setCountry("France");

        Manufacturer manufacturerVolkswagen = new Manufacturer();
        manufacturerVolkswagen.setName("Volkswagen");
        manufacturerVolkswagen.setCountry("German");

        Manufacturer manufacturerFord = new Manufacturer();
        manufacturerFord.setName("Ford");
        manufacturerFord.setCountry("USA");

        ManufacturerService manufacturerService
                = new ManufacturerServiceImpl(new ManufacturerDaoImpl());
        manufacturerService.create(manufacturerPeugeot);
        manufacturerService.create(manufacturerVolkswagen);
        manufacturerService.create(manufacturerFord);
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println(manufacturerService.get(manufacturerFord.getId()));
        manufacturerService.delete(manufacturerFord.getId());
        manufacturerPeugeot.setName("Toyota");
        manufacturerPeugeot.setCountry("Japan");
        manufacturerService.update(manufacturerPeugeot);
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println(System.lineSeparator());

        Driver driverLeo = new Driver();
        driverLeo.setName("Leo");
        driverLeo.setLicenseNumber("12-23-42");

        Driver driverDave = new Driver();
        driverDave.setName("Dave");
        driverDave.setLicenseNumber("22-33-44");

        DriverService driverService
                = new DriverServiceImpl(new DriverDaoImpl());
        driverService.create(driverLeo);
        driverService.create(driverDave);
        driverService.getAll().forEach(System.out::println);
        System.out.println(driverService.get(driverLeo.getId()));
        driverService.delete(driverDave.getId());
        driverLeo.setName("John");
        driverLeo.setLicenseNumber("55-12-32");
        driverService.update(driverLeo);
        driverService.getAll().forEach(System.out::println);
    }
}
