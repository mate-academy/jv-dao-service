package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.DriverServiceImpl;
import mate.jdbc.service.ManufacturerService;
import mate.jdbc.service.ManufacturerServiceImpl;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerServiceImpl manufacturerService =
                (ManufacturerServiceImpl) injector.getInstance(ManufacturerService.class);

        System.out.println("MANUFACTURER TEST:" + System.lineSeparator());
        //test create
        System.out.println(System.lineSeparator() + "create:");
        Manufacturer manufacturer = new Manufacturer("SKODA", "Czech Republic");
        System.out.println(manufacturerService.create(manufacturer));
        List<Manufacturer> listWithNewElement = manufacturerService.getAll();
        listWithNewElement.forEach(System.out::println);
        //test delete
        System.out.println(System.lineSeparator() + "delete:");
        System.out.println(manufacturerService.delete(manufacturer.getId()));
        List<Manufacturer> listWithoutNewElement = manufacturerService.getAll();
        listWithoutNewElement.forEach(System.out::println);
        //test update
        System.out.println(System.lineSeparator() + "update:");
        Manufacturer manufacturerUpdate = new Manufacturer(13L, "BMW", "Germany");
        manufacturerService.update(manufacturerUpdate);
        List<Manufacturer> listWithUpdateElement = manufacturerService.getAll();
        listWithUpdateElement.forEach(System.out::println);
        //test get
        System.out.println(System.lineSeparator() + "get:");
        System.out.println(manufacturerService.get(5L));
        //test getAll
        System.out.println("getAll:");
        List<Manufacturer> allManufacturer = manufacturerService.getAll();
        allManufacturer.forEach(System.out::println);
        //------------------------------------------------------------
        DriverServiceImpl driverService =
                (DriverServiceImpl) injector.getInstance(DriverService.class);

        System.out.println(System.lineSeparator() + "DRIVER TEST:" + System.lineSeparator());
        //test create
        System.out.println(System.lineSeparator() + "create:");
        Driver driver = new Driver("Pavlo", "1235789");
        System.out.println(driverService.create(driver));
        List<Driver> listWithNewDriver = driverService.getAll();
        listWithNewDriver.forEach(System.out::println);
        //test delete
        System.out.println(System.lineSeparator() + "delete:");
        System.out.println(driverService.delete(driver.getId()));
        List<Driver> listWithoutNewDriver = driverService.getAll();
        listWithoutNewDriver.forEach(System.out::println);
        //test update
        System.out.println(System.lineSeparator() + "update:");
        Driver driverUpdate = new Driver(3L, "Bob", "98765");
        driverService.update(driverUpdate);
        List<Driver> listWithUpdateDriver = driverService.getAll();
        listWithUpdateDriver.forEach(System.out::println);
        //test get
        System.out.println(System.lineSeparator() + "get:");
        System.out.println(driverService.get(5L));
        //test getAll
        System.out.println("getAll:");
        List<Driver> allDriver = driverService.getAll();
        allDriver.forEach(System.out::println);
    }
}
