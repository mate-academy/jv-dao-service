package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        // create
        DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);
        Driver driverDima = new Driver(null, "Dima", "12345");
        Driver driverOleg = new Driver(null, "Oleg", "56789");
        driverService.create(driverDima);
        driverService.create(driverOleg);
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer bmw = new Manufacturer(null, "BMW", "Germany");
        Manufacturer vw = new Manufacturer(null, "VW", "Germany");
        manufacturerService.create(bmw);
        manufacturerService.create(vw);
        // get all
        System.out.println("Get all:");
        driverService.getAll().stream().forEach(System.out::println);
        manufacturerService.getAll().stream().forEach(System.out::println);
        // get
        System.out.println("Get:");
        System.out.println(driverService.get(driverDima.getId()));
        System.out.println(manufacturerService.get(bmw.getId()));
        // update
        System.out.println("Update license_number and country");
        driverDima.setLicenseNumber("55555");
        bmw.setCountry("Ukraine");
        driverService.update(driverDima);
        manufacturerService.update(bmw);
        driverService.getAll().stream().forEach(System.out::println);
        manufacturerService.getAll().stream().forEach(System.out::println);
        // delete
        System.out.println("Delete Dima and BMW");
        driverService.delete(driverDima.getId());
        manufacturerService.delete(bmw.getId());
        driverService.getAll().stream().forEach(System.out::println);
        manufacturerService.getAll().stream().forEach(System.out::println);
    }
}
