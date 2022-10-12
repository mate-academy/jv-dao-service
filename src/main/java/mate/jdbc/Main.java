package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Volvo");
        manufacturer.setCountry("Austria");
        //Create
        manufacturerService.create(manufacturer);
        //read
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println(manufacturerService.get(1L));
        //update
        manufacturer.setCountry("Germany");
        manufacturer.setId(6L);
        manufacturerService.update(manufacturer);
        manufacturerService.getAll().forEach(System.out::println);
        //delete
        manufacturerService.delete(6L);
        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver();
        driver.setName("Maria");
        driver.setLicenseNumber("1301923");
        //create
        driverService.create(driver);
        //read
        driverService.getAll().forEach(System.out::println);
        System.out.println(driverService.get(1L));
        //update
        driver.setName("Artur");
        driver.setId(4L);
        driverService.getAll().forEach(System.out::println);
        //delete
        driverService.delete(3L);
        driverService.getAll().forEach(System.out::println);
    }
}
