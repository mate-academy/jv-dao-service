package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver petrenkoPP = new Driver(1L, "Petrenko P.P.", "KIA000001");
        Driver ivanenkoII = new Driver(2L, "Ivanenko I.I.", "KIB000001");
        driverService.create(petrenkoPP);
        driverService.create(ivanenkoII);
        System.out.println(driverService.get(petrenkoPP.getId()));
        ivanenkoII.setLicenseNumber("KIB000001");
        System.out.println(driverService.get(ivanenkoII.getId()));
        System.out.println("Driver before update: " + driverService.get(ivanenkoII.getId()));
        driverService.update(ivanenkoII);
        System.out.println("Driver after update " + driverService.get(ivanenkoII.getId()));
        System.out.println("Drivers before delete: ");
        driverService.getAll().forEach(System.out::println);
        driverService.delete(ivanenkoII.getId());
        System.out.println("Drivers after delete: ");
        driverService.getAll().forEach(System.out::println);
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer lanosManufacturer = new Manufacturer("Lanos", "Ukraine");
        Manufacturer volvoManufacturer = new Manufacturer("Volvo", "China");
        manufacturerService.create(lanosManufacturer);
        manufacturerService.create(volvoManufacturer);
        System.out.println(manufacturerService.get(lanosManufacturer.getId()));
        volvoManufacturer.setName("Volvo");
        manufacturerService.update(volvoManufacturer);
        System.out.println(manufacturerService.getAll());
        manufacturerService.delete(lanosManufacturer.getId());
        System.out.println(manufacturerService.getAll());
    }
}
