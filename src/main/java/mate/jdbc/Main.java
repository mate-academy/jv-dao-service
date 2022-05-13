package mate.jdbc;

import mate.jdbc.comparator.DriverComparator;
import mate.jdbc.comparator.ManufacturerComparator;
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
        Manufacturer firstManufacturer = new Manufacturer(null, "Brabus", "Germany");
        Manufacturer secondManufacturer = new Manufacturer(null, "Audi", "Germany");
        Manufacturer thirdManufacturer = new Manufacturer(null, "Subaru", "Japan");
        manufacturerService.create(firstManufacturer);
        manufacturerService.create(secondManufacturer);
        manufacturerService.create(thirdManufacturer);
        firstManufacturer.setName("Mercedes-Benz");
        manufacturerService.update(firstManufacturer);
        manufacturerService.delete(secondManufacturer.getId());
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver firstDriver = new Driver(null, "Jacob Taylor", "52966");
        Driver secondDriver = new Driver(null, "Drew Torres", "52231");
        Driver thirdDriver = new Driver(null, "Dominic Holloway", "52006");
        Driver fourthDriver = new Driver(null, "Gordon Freeman", "52525");
        Driver fifthDriver = new Driver(null, "Nolan Browning", "52022");
        driverService.create(firstDriver);
        driverService.create(secondDriver);
        driverService.create(thirdDriver);
        driverService.create(fourthDriver);
        driverService.create(fifthDriver);
        driverService.delete(fifthDriver.getId());
        fourthDriver.setLicenseNumber("36887");
        driverService.update(fourthDriver);
        driverService.delete(firstDriver.getId());
        manufacturerService.getAll().stream()
                .sorted(new ManufacturerComparator())
                .forEach(System.out::println);
        System.out.println();
        driverService.getAll().stream()
                .sorted(new DriverComparator())
                .forEach(System.out::println);
    }
}
