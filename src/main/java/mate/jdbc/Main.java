package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector ingector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        final ManufacturerService manufacturerService = (ManufacturerService) ingector
                .getInstance(ManufacturerService.class);
        DriverService driverService = (DriverService) ingector.getInstance(DriverService.class);

        Driver driver = new Driver();
        driver.setName("Vadym");
        driver.setLicenseNumber("AB223211");

        driverService.create(driver);
        System.out.println(driverService.get(2L));
        driverService.getAll().forEach(System.out::println);

        Driver driver1 = new Driver(4L, "Tanya", "T34");
        driverService.update(driver1);
        driverService.delete(1L);

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("M1");
        manufacturer.setCountry("Ukraine");

        manufacturerService.create(manufacturer);
        manufacturerService.get(1L);
        manufacturerService.getAll().forEach(System.out::println);

        Manufacturer manufacturer1 = new Manufacturer(2L, "BWM", "Germany");

        manufacturerService.update(manufacturer1);
        manufacturerService.delete(1L);
    }
}
