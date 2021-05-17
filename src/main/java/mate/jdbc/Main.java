package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        System.out.println("_______________________________"
                + '\n' + "Testing is table empty");
        manufacturerService.getAll().forEach(System.out::println);
        driverService.getAll().forEach(System.out::println);
        System.out.println();

        Manufacturer scoda = new Manufacturer("Scoda","Czech Republic");
        manufacturerService.create(scoda);
        Manufacturer volkswagen = new Manufacturer("Volkswagen", "Germany");
        manufacturerService.create(volkswagen);
        Manufacturer bugatti = new Manufacturer("Bugatti", "France");
        manufacturerService.create(bugatti);
        Manufacturer porsche = new Manufacturer("Porsche", "Germany");
        manufacturerService.create(porsche);

        Driver tom = new Driver("Tom", "ABC123");
        driverService.create(tom);
        Driver john = new Driver("John", "DEFG45");
        driverService.create(john);
        Driver kate = new Driver("Kate", "HJK678");
        driverService.create(kate);
        Driver evelyne = new Driver("Evelyne", "LMNO90");
        driverService.create(evelyne);

        System.out.println("_______________________________");
        System.out.println("Testing create and read (get by id)");
        System.out.println(manufacturerService.get(scoda.getId()));
        System.out.println(manufacturerService.get(volkswagen.getId()));
        System.out.println(manufacturerService.get(bugatti.getId()));
        System.out.println(manufacturerService.get(porsche.getId()));
        System.out.println(driverService.get(tom.getId()));
        System.out.println(driverService.get(john.getId()));
        System.out.println(driverService.get(kate.getId()));
        System.out.println(driverService.get(evelyne.getId()));

        bugatti.setName("Bugatti Automobiles");
        manufacturerService.update(bugatti);
        manufacturerService.delete(porsche.getId());
        kate.setLicenseNumber("NEW777");
        driverService.update(kate);
        driverService.delete(evelyne.getId());

        System.out.println("_______________________________");
        System.out.println("Testing read (get all), update and delete");
        manufacturerService.getAll().forEach(System.out::println);
        driverService.getAll().forEach(System.out::println);
    }
}
