package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static ManufacturerService manufacturerService;
    private static DriverService driverService;

    public static void main(String[] args) {
        manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        driverService = (DriverService) injector
                .getInstance(DriverService.class);

        addDefaultManufacturersToDb();

        System.out.println("------Get all Manufacturers-----");
        List<Manufacturer> allManufacturers = manufacturerService.getAll();
        printAll(allManufacturers);

        System.out.println("------Get Manufacturer by id 3-----");
        System.out.println(manufacturerService.get(3L));

        System.out.println("------Update Manufacturer by ID 2-----");
        Manufacturer secondManufacturerUpdate = manufacturerService.get(2L);
        secondManufacturerUpdate.setName("second Update");
        manufacturerService.update(secondManufacturerUpdate);
        printAll(manufacturerService.getAll());

        System.out.println("------Soft Deleting Manufacturers ID 1 and 3-----");
        manufacturerService.delete(1L);
        manufacturerService.delete(3L);
        printAll(manufacturerService.getAll());

        addDefaultDriversToDb();

        System.out.println("------Get all Drivers-----");
        List<Driver> allDrivers = driverService.getAll();
        printAll(allDrivers);

        System.out.println("------Get Driver by id 3-----");
        System.out.println(driverService.get(3L));

        System.out.println("------Update Driver by ID 2-----");
        Driver secondDriverUpdate = driverService.get(2L);
        secondDriverUpdate.setName("Nick Jonson");
        secondDriverUpdate.setLicenseNumber("22-33-33-22US");
        driverService.update(secondDriverUpdate);
        printAll(driverService.getAll());

        System.out.println("------Soft Deleting Drivers ID 1 and 3-----");
        driverService.delete(1L);
        driverService.delete(3L);
        printAll(driverService.getAll());
    }

    private static void addDefaultManufacturersToDb() {
        Manufacturer firstManufacturer = new Manufacturer(null, "first", "Ukraine");
        Manufacturer secondManufacturer = new Manufacturer(null, "second", "Italy");
        Manufacturer thirdManufacturer = new Manufacturer(null, "third", "Spain");

        List<Manufacturer> listManufacturers = List.of(firstManufacturer,
                secondManufacturer, thirdManufacturer);

        listManufacturers.forEach(l -> manufacturerService.create(l));

    }

    private static void addDefaultDriversToDb() {
        Driver firstDriver = new Driver(null, "Bob", "qwert");
        Driver secondDriver = new Driver(null, "Nick", "asdfg");
        Driver thirdDriver = new Driver(null, "Rob", "zxcvb");

        List<Driver> driversList = List.of(firstDriver,
                secondDriver, thirdDriver);

        driversList.forEach(l -> driverService.create(l));
    }

    private static <T> void printAll(List<T> data) {
        data.forEach(System.out::println);
    }
}
