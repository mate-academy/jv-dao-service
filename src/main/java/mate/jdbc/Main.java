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
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);

        Manufacturer manufacturerAudi = createRecordManufacturer(
                manufacturerService, "Audi", "Germany");
        Manufacturer manufacturerChrysler = createRecordManufacturer(
                manufacturerService, "Chrysler", "USA");

        System.out.println(manufacturerChrysler);

        manufacturerAudi.setName("Buick");
        manufacturerAudi.setCountry("USA");
        Manufacturer manufacturerBuick = manufacturerService.update(manufacturerAudi);
        System.out.println(manufacturerBuick);

        Manufacturer manufacturerVW = createRecordManufacturer(
                manufacturerService, "Volkswagen", "Germany");
        Manufacturer copyManufacturerVW = manufacturerService.get(manufacturerVW.getId());
        System.out.println(copyManufacturerVW);

        Manufacturer manufacturerRenault = createRecordManufacturer(
                manufacturerService, "Renault", "France");
        manufacturerService.delete(manufacturerRenault.getId());

        List<Manufacturer> manufacturerList = manufacturerService.getAll();
        System.out.println(manufacturerList);

        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);

        Driver driverBob = createRecordDriver(
                driverService, "Bob", "123456");
        Driver driverAlice = createRecordDriver(
                driverService, "Alice", "765432");

        System.out.println(driverAlice);

        driverBob.setName("Andriy");
        driverBob.setLicenseNumber("777666");
        Driver driverAndriy = driverService.update(driverBob);
        System.out.println(driverAndriy);

        Driver driverNick = createRecordDriver(
                driverService, "Nick", "356894");
        Driver copyDriverNick = driverService.get(driverNick.getId());
        System.out.println(copyDriverNick);

        Driver driverNancy = createRecordDriver(
                driverService, "Nancy", "987562");
        driverService.delete(driverNancy.getId());

        List<Driver> driverList = driverService.getAll();
        System.out.println(manufacturerList);

    }

    private static Manufacturer createRecordManufacturer(
            ManufacturerService manufacturerService, String name, String country) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName(name);
        manufacturer.setCountry(country);
        return manufacturerService.create(manufacturer);
    }

    private static Driver createRecordDriver(
            DriverService driverService, String name, String licenseNumber) {
        Driver driver = new Driver();
        driver.setName(name);
        driver.setLicenseNumber(licenseNumber);
        return driverService.create(driver);
    }
}
