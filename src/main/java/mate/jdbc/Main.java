package mate.jdbc;

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
        //create
        Manufacturer createManufacturer = new Manufacturer();
        createManufacturer.setName("Kia");
        createManufacturer.setCountry("South Korea");
        createManufacturer = manufacturerService.create(createManufacturer);
        System.out.println("create"
                + System.lineSeparator() + createManufacturer + System.lineSeparator());
        //get
        Manufacturer testManufacturer = manufacturerService.get(5L);
        System.out.println("get"
                + System.lineSeparator() + testManufacturer + System.lineSeparator());
        //getAll
        System.out.println("getAll");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println(System.lineSeparator());
        //update
        Manufacturer updateManufacturer = new Manufacturer();
        updateManufacturer.setName("Fiat");
        updateManufacturer.setCountry("Italy");
        updateManufacturer.setId(12L);
        manufacturerService.update(updateManufacturer);
        System.out.println("update" + System.lineSeparator() + manufacturerService.get(5L));
        //delete
        System.out.println("delete");
        manufacturerService.delete(4L);
        manufacturerService.getAll().forEach(System.out::println);
        //create
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver createDriver = new Driver();
        createDriver.setName("Volodymyr");
        createDriver.setLicenseNumber("567");
        createDriver = driverService.create(createDriver);
        System.out.println("create"
                + System.lineSeparator() + createDriver + System.lineSeparator());
        //get
        Driver testDriver = driverService.get(2L);
        System.out.println("get" + System.lineSeparator() + testDriver + System.lineSeparator());
        //getAll
        System.out.println("getAll");
        driverService.getAll().forEach(System.out::println);
        //update
        Driver updateDriver = new Driver();
        updateDriver.setName("Oleksandra");
        updateDriver.setLicenseNumber("456");
        updateDriver.setId(2L);
        driverService.update(updateDriver);
        System.out.println("update" + System.lineSeparator() + driverService.get(2L));
        //delete
        System.out.println("delete");
        driverService.delete(2L);
        driverService.getAll().forEach(System.out::println);
    }
}
