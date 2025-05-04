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
        Manufacturer manufacturer = new Manufacturer();

        manufacturer.setName("Mazda");
        manufacturer.setCountry("Japan");
        manufacturerService.create(manufacturer);
        manufacturer.setName("Honda");
        manufacturer.setCountry("Japan");
        manufacturerService.create(manufacturer);
        manufacturer.setName("Ford");
        manufacturer.setCountry("Germany");
        manufacturer = manufacturerService.create(manufacturer);
        System.out.println("Created:" + manufacturer.toString());

        manufacturer = manufacturerService.get(manufacturer.getId());
        System.out.println("Get by  id" + manufacturer.toString());

        manufacturer.setCountry("USA");
        manufacturer = manufacturerService.update(manufacturer);
        System.out.println("Updated" + manufacturer.toString());

        List<Manufacturer> manufacturerList = manufacturerService.getAll();
        for (Manufacturer manufacturerItem : manufacturerList) {
            System.out.println(manufacturerItem.toString());
        }
        manufacturerService.delete(manufacturerList.get(0).getId());

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver();

        driver.setName("John Smith");
        driver.setLicenseNumber("00CABCD");
        driverService.create(driver);

        driver.setName("Taras Koval");
        driver.setLicenseNumber("00CFE88");
        driver = driverService.create(driver);
        System.out.println("Created " + driver.toString());
        driver.setLicenseNumber("0001234");
        driver = driverService.update(driver);
        System.out.println("Updated " + driver.toString());

        List<Driver> driverList = driverService.getAll();
        for (Driver driverItem : driverList) {
            System.out.println(driverItem.toString());
        }
        driverService.delete(driverList.get(0).getId());
    }
}
