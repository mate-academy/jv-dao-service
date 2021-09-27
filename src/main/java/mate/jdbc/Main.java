package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Manufacturer manufacturer = new Manufacturer("Ford", "USA");
        Manufacturer manufacturerOne = new Manufacturer("Volvo","Sweden");
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        manufacturer = manufacturerService.create(manufacturer);
        manufacturerOne = manufacturerService.create(manufacturerOne);
        System.out.println(manufacturerService.get(manufacturer.getId()));
        manufacturerOne.setName("Tesla");
        manufacturerOne.setCountry("USA");
        manufacturerService.update(manufacturerOne);
        System.out.println(manufacturerService.get(manufacturerOne.getId()));
        manufacturerService.delete(manufacturerOne.getId());
        manufacturerService.getAll().forEach(System.out::println);

        Driver driver = new Driver("Viktor", "01234");
        Driver driverOne = new Driver("Kyrylo", "56789");
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        driver = driverService.create(driver);
        driverOne = driverService.create(driverOne);
        System.out.println(driverService.get(driver.getId()));
        driver.setLicenseNumber("43210");
        driverService.update(driver);
        System.out.println(driverService.get(driver.getId()));
        driverService.delete(driver.getId());
        driverService.getAll().forEach(System.out::println);
    }
}
