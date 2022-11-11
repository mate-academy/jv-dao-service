package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        final DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        final ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        final Manufacturer audi = new Manufacturer();
        final Manufacturer bmw = new Manufacturer();
        final Manufacturer renault = new Manufacturer();
        audi.setName("Audi");
        audi.setCountry("Germany");
        bmw.setName("BMW");
        bmw.setCountry("Germany");
        renault.setName("Renault");
        renault.setCountry("France");
        Manufacturer audiWithId = manufacturerService.create(audi);
        Manufacturer bmwWithId = manufacturerService.create(bmw);
        Manufacturer renaultWithId = manufacturerService.create(renault);
        manufacturerService.delete(renault.getId());
        bmw.setName("Mercedes");
        manufacturerService.update(bmw);
        manufacturerService.getAll().forEach(System.out::println);
        final Driver driver1 = new Driver();
        final Driver driver2 = new Driver();
        final Driver driver3 = new Driver();
        driver1.setName("Ibrahim");
        driver1.setLicenseNumber("1");
        driver2.setName("Vasyl");
        driver2.setLicenseNumber("2");
        driver3.setName("Bob");
        driver3.setLicenseNumber("3");
        Driver ibrahim = driverService.create(driver1);
        Driver vasyl = driverService.create(driver2);
        Driver bob = driverService.create(driver3);
        driverService.delete(ibrahim.getId());
        driverService.getAll().forEach(System.out::println);
        vasyl.setName("Vasya");
        Driver vasya = driverService.update(vasyl);
    }
}
