package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        Manufacturer audi = new Manufacturer();
        audi.setName("Audi");
        audi.setCountry("Germany");
        manufacturerService.create(audi);
        Manufacturer peugeot = new Manufacturer();
        peugeot.setName("Peugeot");
        peugeot.setCountry("France");
        peugeot = manufacturerService.create(peugeot);
        Manufacturer renault = new Manufacturer(peugeot.getId(), "Renault", peugeot.getCountry());
        manufacturerService.update(renault);
        List<Manufacturer> allManufacturers = manufacturerService.getAll();
        allManufacturers.stream().forEach(System.out::println);
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        Driver firstDriver = new Driver();
        firstDriver.setName("SomeName");
        firstDriver.setLicenseNumber("12345");
        driverService.create(firstDriver);
        Driver secondDriver = new Driver();
        secondDriver.setName("NameSome");
        secondDriver.setLicenseNumber("67890");
        secondDriver = driverService.create(secondDriver);
        Driver driverToUpdate = new Driver(secondDriver.getId(),
                "42", secondDriver.getLicenseNumber());
        driverService.update(driverToUpdate);
        List<Driver> allDrivers = driverService.getAll();
        allDrivers.forEach(System.out::println);
    }
}
