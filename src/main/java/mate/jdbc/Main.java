package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);

        System.out.println("Manufactures DB testing");
        System.out.println("Adding new records: ");
        Manufacturer ferrariManufacturer = new Manufacturer("Ferrari", "Italy");
        manufacturerService.create(ferrariManufacturer);
        Manufacturer zazManufacturer = new Manufacturer("ZAZ", "Ukraine");
        manufacturerService.create(zazManufacturer);
        Manufacturer hondaManufacturer = new Manufacturer("Honda", "Japan");
        manufacturerService.create(hondaManufacturer);
        System.out.println(manufacturerService.getAll());

        System.out.println("Single record by ID: "
                + manufacturerService.get(ferrariManufacturer.getId()));

        System.out.println("Updating and deleting records: ");
        zazManufacturer.setName("ZAZ-Auto");
        manufacturerService.update(zazManufacturer);
        manufacturerService.delete(hondaManufacturer.getId());
        System.out.println(manufacturerService.getAll());

        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);

        System.out.println("Drivers DB testing");
        System.out.println("Adding new records: ");
        Driver bobDriver = new Driver("Bob", "1234");
        driverService.create(bobDriver);
        Driver aliceDriver = new Driver("Alice", "4567");
        driverService.create(aliceDriver);
        Driver johnDriver = new Driver("John", "7890");
        driverService.create(johnDriver);
        System.out.println(driverService.getAll());

        System.out.println("Single record by ID: "
                + driverService.get(aliceDriver.getId()));

        System.out.println("Updating and deleting records: ");
        bobDriver.setName("Robert");
        driverService.update(bobDriver);
        driverService.delete(johnDriver.getId());
        System.out.println(driverService.getAll());
    }
}
