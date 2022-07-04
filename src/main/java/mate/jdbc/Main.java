package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        //driverService.create() method check
        Driver ranjit = driverService.create(new Driver("Ranjit", "12345"));
        Driver semen = driverService.create(new Driver("Semen", "23456"));
        Driver michael = driverService.create(new Driver("Michael", "34567"));

        //driverService.update() method check
        driverService.update(new Driver(ranjit.getId(), "Umesh", "54321"));

        //driverService.delete() method check
        driverService.delete(semen.getId());

        //driverService.get() method check
        System.out.println(driverService.get(michael.getId()));
        System.out.println(driverService.get(ranjit.getId()));

        //driverService.getAll() method check
        driverService.getAll().forEach(System.out::println);

        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);

        //manufacturerService.create() method check
        Manufacturer lincoln = manufacturerService.create(new Manufacturer("Lincoln", "USA"));
        Manufacturer ford = manufacturerService.create(new Manufacturer("Ford", "USA"));
        Manufacturer audi = manufacturerService.create(new Manufacturer("Audi", "Germany"));

        //manufacturerService.update() method check
        manufacturerService.update(new Manufacturer(ford.getId(), "Porsche", "Germany"));

        //manufacturerService.delete() method check
        manufacturerService.delete(audi.getId());

        //manufacturerService.get() method check
        System.out.println(manufacturerService.get(lincoln.getId()));
        System.out.println(manufacturerService.get(ford.getId()));

        //manufacturerService.getAll() method check
        manufacturerService.getAll().forEach(System.out::println);
    }
}
