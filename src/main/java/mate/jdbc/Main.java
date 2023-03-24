package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturedService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final ManufacturedService manufacturedService =
            (ManufacturedService) injector.getInstance(ManufacturedService.class);
    private static final DriverService driverService =
            (DriverService) injector.getInstance(DriverService.class);

    public static void main(String[] args) {
        Manufacturer firstManufacturer = new Manufacturer();
        firstManufacturer.setName("Goga");
        firstManufacturer.setCountry("Ukraine");
        Manufacturer secondManufacturer = new Manufacturer();
        secondManufacturer.setName("Goofy");
        secondManufacturer.setCountry("Gendalf");
        Driver firstDriver = new Driver();
        firstDriver.setName("Grisha");
        firstDriver.setLicenseNumber("12345467");
        Driver secondDriver = new Driver();
        secondDriver.setName("Susi");
        secondDriver.setLicenseNumber("2351234");
        manufacturedService.create(firstManufacturer);
        manufacturedService.create(secondManufacturer);
        driverService.create(firstDriver);
        driverService.create(secondDriver);
        List<Manufacturer> allManufacturersList = manufacturedService.getAll();
        for (Manufacturer manufacturer : allManufacturersList) {
            System.out.println(manufacturer);
        }
        List<Driver> allDriversList = driverService.getAll();
        for (Driver driver : allDriversList) {
            System.out.println(driver);
        }
        System.out.println(manufacturedService.get(firstManufacturer.getId()));
        secondManufacturer.setName("upadtedname");
        System.out.println(manufacturedService.update(secondManufacturer));
        System.out.println(manufacturedService.delete(firstManufacturer.getId()));;
        System.out.println(manufacturedService.getAll());
        System.out.println(driverService.get(firstDriver.getId()));
        secondDriver.setName("upadtedname");
        System.out.println(driverService.update(secondDriver));
        System.out.println(driverService.delete(firstDriver.getId()));;
        System.out.println(driverService.getAll());
    }
}
