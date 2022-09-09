package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        // test your code here
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        System.out.println("Test create manufacturer");
        Manufacturer ford = new Manufacturer("FORD", "USA");
        ford = manufacturerService.create(ford);
        Manufacturer audi = new Manufacturer("AUDI", "Germany");
        audi = manufacturerService.create(audi);
        Manufacturer lanos = new Manufacturer("LANOS", "UKRAINE");
        lanos = manufacturerService.create(lanos);
        System.out.println("Test getAll manufacturer");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("Test update. Changed name in lanos variable to tesla");
        lanos.setName("tesla");
        manufacturerService.update(lanos);
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("Test get manufacturer");
        System.out.println(manufacturerService.get(lanos.getId()));
        System.out.println("Test delete manufacturer");
        manufacturerService.delete(audi.getId());
        System.out.println("================================");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println(ford.getId());

        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);
        System.out.println("Test create driver");
        Driver bob = new Driver("Bob", "AS4356QQ");
        bob = driverService.create(bob);
        Driver alice = new Driver("Alice", "FR5748IO");
        alice = driverService.create(alice);
        Driver jonh = new Driver("Jonh", "GF6534TY");
        jonh = driverService.create(jonh);
        System.out.println("Test getAll driver");
        driverService.getAll().forEach(System.out::println);
        System.out.println("Test update. Changed name in Bob variable to Ivan");
        bob.setName("Ivan");
        driverService.update(bob);
        driverService.getAll().forEach(System.out::println);
        System.out.println("Test get driver");
        System.out.println(driverService.get(bob.getId()));
        System.out.println("Test delete driver");
        driverService.delete(alice.getId());
        driverService.getAll().forEach(System.out::println);
    }
}
