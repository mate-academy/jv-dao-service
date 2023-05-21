package mate.jdbc;

import java.util.List;
import java.util.Objects;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector INJECTOR = Injector.getInstance("mate.jdbc");
    private static List<Manufacturer> manufacturers = List.of(
            new Manufacturer("Peugeot", "France"),
            new Manufacturer("Renault", "France"),
            new Manufacturer("Citroen", "France"),
            new Manufacturer("Opel", "Germany"),
            new Manufacturer("Volvo", "Sweden")
    );

    private static List<Driver> drivers = List.of(
            new Driver("Anzhelika Oliynyk", "0BLUEKXRP8YKYZZ"),
            new Driver("Zhanna Sokolov", "0J339FR7HZTZKZY"),
            new Driver("Volodymyr Shvets", "0HVCWSK83X46DZF"),
            new Driver("Serhii Kovalchuk", "0W9CT6B9Q5VC7ZK"),
            new Driver("Semen Holub", "0KM9PUX29Z85NZR")
    );

    public static void main(String[] args) {
        final DriverService driverService =
                (DriverService) INJECTOR.getInstance(DriverService.class);
        final ManufacturerService manufacturerService =
                (ManufacturerService) INJECTOR.getInstance(ManufacturerService.class);
        //Create
        for (Manufacturer manufacturer : manufacturers) {
            System.out.println("Created manufacturer record in DB: "
                    + manufacturerService.create(manufacturer));
        }
        for (Driver driver : drivers) {
            System.out.println("Created driver record in DB: "
                    + driverService.create(driver));
        }
        //Read all
        manufacturers = manufacturerService.getAll();
        System.out.println(System.lineSeparator() + "Manufacturer records in DB:");
        manufacturers.forEach(System.out::println);

        drivers = driverService.getAll();
        System.out.println(System.lineSeparator() + "Driver records in DB:");
        drivers.forEach(System.out::println);
        //Get by id manufacturer
        Long peugeotId = manufacturers.stream()
                .filter(m -> Objects.equals(m.getName(), "Peugeot"))
                .findFirst().get().getId();

        System.out.println(System.lineSeparator()
                + "Read manufacturer from DB by id: " + peugeotId);
        System.out.println(manufacturerService.get(peugeotId));
        //Get by id driver
        Long volodymyrShvetsId = drivers.stream()
                .filter(m -> Objects.equals(m.getName(), "Volodymyr Shvets"))
                .findFirst().get().getId();
        System.out.println(System.lineSeparator()
                + "Read driver from DB by id: " + volodymyrShvetsId);
        System.out.println(manufacturerService.get(volodymyrShvetsId));
        //Update manufacturer
        Manufacturer modifiedManufacturer = manufacturerService.get(peugeotId);
        modifiedManufacturer.setCountry("India");
        modifiedManufacturer.setName("TATA");
        System.out.println(System.lineSeparator() + "Updated manufacturer in DB: "
                + manufacturerService.update(modifiedManufacturer)
                + System.lineSeparator());
        //Update driver
        Driver modifiedDriver = driverService.get(volodymyrShvetsId);
        modifiedDriver.setName("Ihor Dudko");
        modifiedDriver.setLicenseNumber("0KM9PUX29X22NZR");
        System.out.println(System.lineSeparator() + "Updated driver in DB: "
                + driverService.update(modifiedDriver)
                + System.lineSeparator());
        //Delete manufacturers
        manufacturers = manufacturerService.getAll();
        for (Manufacturer manufacturer : manufacturers) {
            System.out.println("Deleted manufacturer record from DB: "
                    + manufacturerService.delete(manufacturer.getId()));
        }
        //Delete drivers
        drivers = driverService.getAll();
        for (Driver driver : drivers) {
            System.out.println("Deleted driver record from DB: "
                    + driverService.delete(driver.getId()));
        }
    }
}
