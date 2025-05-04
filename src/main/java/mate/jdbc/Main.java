package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        Manufacturer firstCar = initializeManufacturer("BMW", "Germany");
        Manufacturer secondCar = initializeManufacturer("Ferrari", "Japan");
        Manufacturer thirdCar = initializeManufacturer("Opel", "USA");
        Manufacturer fourthCar = initializeManufacturer("Kamaz", "Russian");
        manufacturerService.create(firstCar);
        manufacturerService.create(secondCar);
        manufacturerService.create(thirdCar);
        manufacturerService.create(fourthCar);
        System.out.println("Create our manufacturers. List of all cars : "
                + manufacturerService.getAll());
        firstCar.setName("Mercedes");
        fourthCar.setCountry("Ukraine");
        manufacturerService.update(firstCar);
        manufacturerService.update(fourthCar);
        System.out.println("Update first and fourth car. List of all cars : "
                + manufacturerService.getAll());
        manufacturerService.delete(firstCar.getId());
        manufacturerService.delete(secondCar.getId());
        manufacturerService.delete(thirdCar.getId());
        manufacturerService.delete(fourthCar.getId());
        System.out.println("get all after deletion"
                + manufacturerService.getAll());
        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);
        Driver driverFirst = initializeDriver("Petro","5544");
        Driver driverSecond = initializeDriver("Olga","0987");
        Driver driverThird = initializeDriver("Bogdan","7777");
        driverService.create(driverFirst);
        driverService.create(driverSecond);
        driverService.create(driverThird);
        System.out.println("Create our drivers. List of all drivers : "
                + driverService.getAll());
        driverFirst.setName("Misha");
        driverSecond.setLicenseNumber("0000");
        driverService.update(driverFirst);
        driverService.update(driverSecond);
        System.out.println("Update first and third drivers. List of all drivers : "
                + driverService.getAll());
        driverService.delete(driverFirst.getId());
        driverService.delete(driverSecond.getId());
        driverService.delete(driverThird.getId());
        System.out.println("get all after deletion"
                + driverService.getAll());
    }

    private static Driver initializeDriver(String name, String licenseNumber) {
        Driver driver = new Driver();
        driver.setName(name);
        driver.setLicenseNumber(licenseNumber);
        return driver;
    }

    private static Manufacturer initializeManufacturer(String name, String country) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName(name);
        manufacturer.setCountry(country);
        return manufacturer;
    }
}
