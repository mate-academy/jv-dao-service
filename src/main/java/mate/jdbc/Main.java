package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    public static void main(String[] args) {
        Manufacturer manufacturer = new Manufacturer();
        Driver driver = new Driver();
        final Injector injector = Injector.getInstance("mate.jdbc");

        /* Create Manufacture / Driver */
        manufacturer.setName("Tavria Nova");
        manufacturer.setCountry("Ukraine");
        driver.setName("Arystarh");
        driver.setLicenseNumber("if_you_will_see_him_call_911");
        DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        System.out.println("Create Manufacture: "
                + manufacturerService.create(manufacturer));
        System.out.println("Create Driver: "
                + driverService.create(driver));
        System.out.println("------------------------------------");

        /* Update manufacture / Driver */
        manufacturer.setName("Zaporozhets");
        driver.setName("Salvador");
        System.out.println("Update manufacture: "
                + manufacturerService.update(manufacturer));
        System.out.println("Update driver: "
                + driverService.update(driver));
        System.out.println("------------------------------------");

        /* Delete Manufacture / Driver */
        System.out.println("Delete Manufacture: "
                + manufacturerService.delete(manufacturer.getId()));
        System.out.println("Delete Driver: "
                + driverService.delete(driver.getId()));
        System.out.println("------------------------------------");

        /* All Manufacturers / Drivers */
        manufacturerService.getAll().stream().forEach(System.out::println);
        System.out.println("------------------------------------");
        driverService.getAll().stream().forEach(System.out::println);
    }
}
