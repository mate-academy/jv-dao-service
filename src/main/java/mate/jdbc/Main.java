package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final ManufacturerService manufacturerService = (ManufacturerService)
            injector.getInstance(ManufacturerService.class);
    private static final DriverService driverService = (DriverService)
            injector.getInstance(DriverService.class);

    public static void main(String[] args) {
        //Test driver

        // Update driver
        Driver driver = new Driver();
        driver.setId(22L);
        driver.setName("Bill");
        driver.setLicenceNumber("TG666666");
        driverService.update(driver);
        System.out.println(driver);

        //Create driver
        driver.setName("Bob");
        driver.setLicenceNumber("TR131313");
        driverService.create(driver);

        //Delete driver
        driverService.delete(23L);

        // Get driver
        driverService.get(21L);

        //Get all drivers
        driverService.getAll().forEach(System.out::println);

        //Test Manufacturer

        //Created Manufacturer
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("BMW");
        manufacturer.setCountry("Germany");
        manufacturerService.create(manufacturer);

        //Update manufacture
        manufacturer.setId(1L);
        manufacturer.setName("Renault");
        manufacturer.setCountry("France");
        manufacturerService.update(manufacturer);

        //Get manufacturer
        System.out.println(manufacturerService.get(2L));

        //Get all manufacturer
        manufacturerService.getAll().forEach(System.out::println);

        //Deleted manufacturer
        manufacturerService.delete(3L);
    }
}
