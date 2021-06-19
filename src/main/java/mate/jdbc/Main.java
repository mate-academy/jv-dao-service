package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        final ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        final DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        //manufacturerService testing
        Manufacturer colaManufacturer = new Manufacturer("John Stith Pemberton ", "USA");
        manufacturerService.create(colaManufacturer);
        System.out.println(manufacturerService.get(colaManufacturer.getId()));
        colaManufacturer.setName("Caleb Bradham ");
        manufacturerService.update(colaManufacturer);
        System.out.println(manufacturerService.getAll());
        manufacturerService.delete(colaManufacturer.getId());
        System.out.println(manufacturerService.getAll());
        //driverService testing
        Driver bestDriver = new Driver("Jason Statham", "VVB 113456");
        driverService.create(bestDriver);
        System.out.println(driverService.get(bestDriver.getId()));
        bestDriver.setLicenseNumber("Sport Pilot License without number");
        driverService.update(bestDriver);
        System.out.println(driverService.getAll());
        driverService.delete(bestDriver.getId());
        System.out.println(driverService.getAll());

    }
}
