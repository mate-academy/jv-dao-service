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
        final DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);
        final ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);

        // TESTING DRIVER CREATE METHOD
        Driver firstDriver = new Driver();
        firstDriver.setName("Alex");
        firstDriver.setLicenseNumber("1224");
        Driver driverAlex = driverService.create(firstDriver);
        Driver secondDriver = new Driver();
        secondDriver.setName("Alice");
        secondDriver.setLicenseNumber("1240");
        Driver driverAlice = driverService.create(secondDriver);
        Driver thirdDriver = new Driver();
        thirdDriver.setName("Bob");
        thirdDriver.setLicenseNumber("2902");
        Driver driverBob = driverService.create(thirdDriver);

        // TESTING MANUFACTURER CREATE METHOD
        Manufacturer firstManufacturer = new Manufacturer();
        firstManufacturer.setCountry("Ukraine");
        firstManufacturer.setName("first_name");
        Manufacturer manufacturerFromUkraine = manufacturerService.create(firstManufacturer);
        Manufacturer secondManufacturer = new Manufacturer();
        secondManufacturer.setCountry("Spain");
        secondManufacturer.setName("second_name");
        Manufacturer manufacturerFromSpain = manufacturerService.create(secondManufacturer);
        Manufacturer thirdManufacturer = new Manufacturer();
        thirdManufacturer.setCountry("Lithuania");
        thirdManufacturer.setName("third_name");
        Manufacturer manufacturerFromLithuania = manufacturerService.create(thirdManufacturer);

        // TESTING GET DRIVER METHOD
        Driver driverFromGet = driverService.get(3L);
        System.out.println("TESTING GET DRIVER METHOD");
        System.out.println(driverFromGet);

        // TESTING GET MANUFACTURER METHOD
        Manufacturer manufacturerFromGet = manufacturerService.get(3L);
        System.out.println("TESTING GET MANUFACTURER METHOD");
        System.out.println(manufacturerFromGet);

        // TESTING UPDATE DRIVER METHOD
        Driver updatedDriver = new Driver();
        updatedDriver.setName("Bobik");
        updatedDriver.setLicenseNumber("2022");
        updatedDriver.setId(3L);
        driverService.update(updatedDriver);

        // TESTING UPDATE MANUFACTURER METHOD
        Manufacturer updatedManufacturer = new Manufacturer();
        updatedManufacturer.setName("fourth_name");
        updatedManufacturer.setCountry("Italy");
        updatedManufacturer.setId(3L);
        manufacturerService.update(updatedManufacturer);

        // TESTING DELETE DRIVER METHOD
        driverService.delete(2L);

        // TESTING DELETE MANUFACTURER METHOD
        manufacturerService.delete(2L);

        // TESTING GET ALL DRIVERS METHOD
        List<Driver> allDrivers = driverService.getAll();
        System.out.println("TESTING GET ALL DRIVERS METHOD");
        allDrivers.forEach(System.out::println);

        // TESTING GET ALL MANUFACTURERS METHOD
        List<Manufacturer> allManufacturers = manufacturerService.getAll();
        System.out.println("TESTING GET ALL MANUFACTURERS METHOD");
        allManufacturers.forEach(System.out::println);
    }
}
