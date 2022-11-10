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
        final Manufacturer manufacturer1 = new Manufacturer();
        final Manufacturer manufacturer2 = new Manufacturer();
        final Manufacturer manufacturer3 = new Manufacturer();
        manufacturer1.setName("Audi");
        manufacturer1.setCountry("Germany");
        manufacturer2.setName("BMW");
        manufacturer2.setCountry("Germany");
        manufacturer3.setName("Renault");
        manufacturer3.setCountry("France");
        Manufacturer audi = manufacturerService.create(manufacturer1);
        Manufacturer bmw = manufacturerService.create(manufacturer2);
        Manufacturer renault = manufacturerService.create(manufacturer3);
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
