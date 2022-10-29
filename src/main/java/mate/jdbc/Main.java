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

        Manufacturer audiManufacturer = new Manufacturer();
        audiManufacturer.setName("audi");
        audiManufacturer.setCountry("germany");
        manufacturerService.create(audiManufacturer);

        Manufacturer toyotaManufacturer = new Manufacturer();
        toyotaManufacturer.setName("toyota");
        toyotaManufacturer.setCountry("japan");
        manufacturerService.create(toyotaManufacturer);

        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);

        Driver bobDriver = new Driver();
        bobDriver.setName("bob");
        bobDriver.setLicenseNumber("1111");
        driverService.create(bobDriver);

        Driver pitDriver = new Driver();
        pitDriver.setName("pit");
        pitDriver.setLicenseNumber("2222");
        driverService.create(pitDriver);

        List<Manufacturer> allManufacturers = manufacturerService.getAll();
        allManufacturers.forEach(System.out::println);

        List<Driver> allDrivers = driverService.getAll();
        allDrivers.forEach(System.out::println);

        Manufacturer manufacturer = manufacturerService.get(2L);
        System.out.println(manufacturer);

        Driver driver = driverService.get(1L);
        System.out.println(driver);

        Manufacturer audiChinaManufacturer = new Manufacturer();
        audiChinaManufacturer.setId(16L);
        audiChinaManufacturer.setName("audi_china");
        audiChinaManufacturer.setCountry("china");
        manufacturerService.update(audiChinaManufacturer);

        Driver bobExDriver = new Driver();
        bobExDriver.setId(1L);
        bobExDriver.setName("bob_ex");
        bobExDriver.setLicenseNumber("1111_ex");
        driverService.update(bobExDriver);

        manufacturerService.delete(16L);
        driverService.delete(3L);
    }
}
