package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Manufacturer scoda = new Manufacturer();
        scoda.setName("Scoda");
        scoda.setCountry("Czech Republic");
        Manufacturer volkswagen = new Manufacturer();
        volkswagen.setName("Volkswagen");
        volkswagen.setCountry("Germany");
        Manufacturer bugatti = new Manufacturer();
        bugatti.setName("Bugatti");
        bugatti.setCountry("France");
        Manufacturer porsche = new Manufacturer();
        porsche.setName("Porsche");
        porsche.setCountry("Germany");
        Driver tom = new Driver();
        tom.setName("Tom");
        tom.setLicenseNumber("ABC123");
        Driver john = new Driver();
        john.setName("John");
        john.setLicenseNumber("DEFG45");
        Driver kate = new Driver();
        kate.setName("Kate");
        kate.setLicenseNumber("HJK678");
        Driver evelyne = new Driver();
        evelyne.setName("Evelyne");
        evelyne.setLicenseNumber("LMNO90");

        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        System.out.println("Testing is table empty");
        manufacturerService.getAll().forEach(System.out::println);
        driverService.getAll().forEach(System.out::println);
        System.out.println("_______________________________");

        manufacturerService.create(scoda);
        manufacturerService.create(volkswagen);
        manufacturerService.create(bugatti);
        manufacturerService.create(porsche);
        driverService.create(tom);
        driverService.create(john);
        driverService.create(kate);
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
