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

        Manufacturer ford = new Manufacturer("Ford", "USA");
        Manufacturer audi = new Manufacturer("Audi", "Germany");
        Manufacturer vw = new Manufacturer("VW", "Germany");
        Manufacturer lada = new Manufacturer("Lada", "Russia");

        manufacturerService.create(ford);
        manufacturerService.create(audi);
        manufacturerService.create(vw);
        manufacturerService.create(lada);
        manufacturerService.getAll().forEach(System.out::println);

        manufacturerService.delete(7L);
        manufacturerService.getAll().forEach(System.out::println);

        System.out.println(manufacturerService.get(8L));

        Manufacturer newLada = new Manufacturer("Lada", "Nowhere");
        newLada.setId(4L);
        manufacturerService.update(newLada);
        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);

        Driver sergey = new Driver("Sergey", "12345");
        Driver mike = new Driver("Mike", "54321");
        Driver oleg = new Driver("Oleg", "67890");
        Driver vazgen = new Driver("Vazgen", "777");

        driverService.create(sergey);
        driverService.create(mike);
        driverService.create(oleg);
        driverService.create(vazgen);
        driverService.getAll().forEach(System.out::println);

        driverService.delete(2L);
        driverService.getAll().forEach(System.out::println);

        System.out.println(driverService.get(3L));

        Driver newVazgen = new Driver("Vazgen", "404");
        newVazgen.setId(7L);
        driverService.update(newVazgen);
        driverService.getAll().forEach(System.out::println);
    }
}
