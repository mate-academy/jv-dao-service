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
        Manufacturer manufacturer1 = new Manufacturer("Volvo","Sweden");
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        manufacturer = manufacturerService.create(manufacturer);
        manufacturer1 = manufacturerService.create(manufacturer1);
        System.out.println(manufacturerService.get(manufacturer.getId()));
        manufacturer1.setName("Tesla");
        manufacturer1.setCountry("USA");
        manufacturerService.update(manufacturer1);
        System.out.println(manufacturerService.get(manufacturer1.getId()));
        manufacturerService.delete(manufacturer1.getId());
        manufacturerService.getAll().forEach(System.out::println);

        Driver driver = new Driver("Viktor", "01234");
        Driver driver1 = new Driver("Kyrylo", "56789");
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        driver = driverService.create(driver);
        driver1 = driverService.create(driver1);
        System.out.println(driverService.get(driver.getId()));
        driver.setLicenseNumber("43210");
        driverService.update(driver);
        System.out.println(driverService.get(driver.getId()));
        driverService.delete(driver.getId());
        driverService.getAll().forEach(System.out::println);
    }
}
