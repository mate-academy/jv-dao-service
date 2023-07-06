package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final ManufacturerService manufacturerService =
            (ManufacturerService) injector.getInstance(ManufacturerService.class);
    private static final DriverService driverService =
            (DriverService) injector.getInstance(DriverService.class);

    public static void main(String[] args) {
        Manufacturer manufacturer1 = new Manufacturer();
        manufacturer1.setName("bmw");
        manufacturer1.setCountry("germany");

        Manufacturer manufacturer2 = new Manufacturer();
        manufacturer2.setName("lexus");
        manufacturer2.setCountry("japan");

        Manufacturer manufacturer3 = new Manufacturer();
        manufacturer3.setName("ford");
        manufacturer3.setCountry("usa");

        manufacturerService.create(manufacturer1);
        manufacturerService.create(manufacturer2);
        manufacturerService.create(manufacturer3);

        manufacturerService.getAll().forEach(System.out::println);

        manufacturer1.setName("mercedes");
        manufacturerService.update(manufacturer1);
        manufacturerService.delete(manufacturer2.getId());

        manufacturerService.getAll().forEach(System.out::println);

        Driver driver1 = new Driver();
        driver1.setName("Damien");
        driver1.setLicenseNumber("666");

        Driver driver2 = new Driver();
        driver2.setName("Jim");
        driver2.setLicenseNumber("23");

        Driver driver3 = new Driver();
        driver3.setName("Vivec");
        driver3.setLicenseNumber("36");

        driverService.create(driver1);
        driverService.create(driver2);
        driverService.create(driver3);

        driverService.getAll().forEach(System.out::println);

        driver1.setName("Adam");
        driverService.update(driver1);
        driverService.delete(driver2.getId());

        driverService.getAll().forEach(System.out::println);
    }
}
