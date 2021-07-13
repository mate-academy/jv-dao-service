package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        //        Manufacturer lada = new Manufacturer("lada", "Russia");
        //        manufacturerService.create(lada);
        //        Manufacturer volga = new Manufacturer("volga", "Russia");
        //        volga.setId(1L);
        //        manufacturerService.update(volga);
        //        manufacturerService.delete(1L);
        //        System.out.println(manufacturerService.get(1L));
        //        manufacturerService.getAll().stream().forEach(System.out::println);

        //        Driver bob = new Driver("Bob", "123");
        //        driverService.create(bob);
        //        Driver alice = new Driver("Alice", "456");
        //        alice.setId(1L);
        //        driverService.update(alice);
        //        driverService.delete(1L);
        //        System.out.println(driverService.get(1L));
        //        driverService.getAll().stream().forEach(System.out::println);
    }
}
