package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final String PACKAGE = "mate.jdbc";
    private static final Injector injector = Injector.getInstance(PACKAGE);

    public static void main(String[] args) {
        /*MANUFACTURER*/
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);

        //manufacturer.create(Manufacturer manufacturer)
        Manufacturer corn = new Manufacturer("CornIndustry", "Ukraine");
        manufacturerService.create(corn);

        Manufacturer bavovna = new Manufacturer("BavovnaHimarsovna", "USA/Ukraine");
        manufacturerService.create(bavovna);

        //manufacturer.getAll()
        List<Manufacturer> listOfManufacturers = manufacturerService.getAll();
        listOfManufacturers.forEach(System.out::println);
        System.out.println();

        //manufacturer.delete(Long id)
        System.out.println("Corn manufacturer was safe-deleted");
        manufacturerService.delete(corn.getId());
        listOfManufacturers = manufacturerService.getAll();
        listOfManufacturers.forEach(System.out::println);
        System.out.println();

        //manufacturer.update(Manufacturer manufacturer)
        System.out.println("Bavovna country was updated");
        bavovna.setCountry("Ukraine");
        manufacturerService.update(bavovna);
        //manufacturer.get(Long id)
        System.out.println(manufacturerService.get(bavovna.getId()));
        System.out.println();

        /*DRIVER*/
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);

        //driver.create(Driver driver)
        Driver truckDriver = new Driver("Vasyl", "12345");
        driverService.create(truckDriver);

        Driver deliveryDriver = new Driver("Petro", "4v315");
        driverService.create(deliveryDriver);

        //driver.getAll()
        List<Driver> drivers = driverService.getAll();
        drivers.forEach(System.out::println);

        //driver.delete(Long id)
        System.out.println("truckDriver was safe-deleted");
        driverService.delete(truckDriver.getId());
        drivers.forEach(System.out::println);

        //driver.update(Driver driver)
        System.out.println("deliveryDriver license number was updated");
        deliveryDriver.setLicenceNumber("kkko228");
        System.out.println(driverService.update(deliveryDriver));

        //driver.getId(Long id)
        System.out.println("Getting deliveryDriver");
        System.out.println(driverService.get(deliveryDriver.getId()));
    }
}
