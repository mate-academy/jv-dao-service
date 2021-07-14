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

        System.out.println("Table of manufacturers: ");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("-----------------------------------");
        Manufacturer lada = new Manufacturer("Lada", "Ukraine");
        System.out.println(manufacturerService.create(lada) + " is added to DB");
        System.out.println(manufacturerService.get(4L)
                + " is deleted: " + manufacturerService.delete(4L));
        Manufacturer mercedes = manufacturerService.get(5L);
        mercedes.setCountry("Germany");
        System.out.println(manufacturerService.update(mercedes) + " is updated");
        System.out.println("-----------------------------------");
        System.out.println("Table of manufacturers: ");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("-----------------------------------");

        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);

        System.out.println("Table of drivers: ");
        driverService.getAll().forEach(System.out::println);
        System.out.println("-----------------------------------");
        Driver sofia = new Driver("Sofia", "HF3940184312042");
        System.out.println(driverService.create(sofia) + " is added to DB");
        System.out.println(driverService.get(3L)
                + " is deleted: " + driverService.delete(3L));
        Driver johny = driverService.get(2L);
        johny.setName("Johny");
        System.out.println(driverService.update(johny) + " is updated");
        System.out.println("-----------------------------------");
        System.out.println("Table of drivers: ");
        driverService.getAll().forEach(System.out::println);
        System.out.println("-----------------------------------");
    }
}
