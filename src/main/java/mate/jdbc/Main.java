package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        System.out.println("---------- ManufacturerService Test ----------");
        manufacturerServiceTest();
        System.out.println("------------- DriverService Test -------------");
        driverServiceTest();
    }

    private static void manufacturerServiceTest() {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        manufacturerService.create(new Manufacturer("Audi", "Germany"));
        manufacturerService.create(new Manufacturer("Lamborghini", "Italy"));
        List<Manufacturer> data = manufacturerService.getAll();
        Manufacturer audi = data.stream()
                .filter(e -> e.getName().equals("Audi"))
                .findFirst()
                .orElseThrow();
        audi.setCountry("USA");
        manufacturerService.update(audi);
        Manufacturer lamborghini = data.stream()
                .filter(x -> x.getName().equals("Lamborghini"))
                .findFirst()
                .orElseThrow();
        Manufacturer manufacturerAudi = manufacturerService.get(audi.getId());
        System.out.println(manufacturerAudi);
        Manufacturer manufacturerLamborghini = manufacturerService.get(lamborghini.getId());
        System.out.println(manufacturerLamborghini);
        manufacturerService.delete(lamborghini.getId());
        manufacturerService.getAll().forEach(System.out::println);
    }

    private static void driverServiceTest() {
        DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);
        driverService.create(new Driver("Bob", "1023049412"));
        driverService.create(new Driver("Alice", "8617034781"));
        List<Driver> data = driverService.getAll();
        Driver bob = data.stream()
                .filter(e -> e.getName().equals("Bob"))
                .findFirst()
                .orElseThrow();
        bob.setLicenseNumber("7777777777");
        driverService.update(bob);
        Driver alice = data.stream()
                .filter(x -> x.getName().equals("Alice"))
                .findFirst()
                .orElseThrow();
        Driver driverBob = driverService.get(bob.getId());
        System.out.println(driverBob);
        Driver driverAlice = driverService.get(alice.getId());
        System.out.println(driverAlice);
        driverService.delete(alice.getId());
        driverService.getAll().forEach(System.out::println);
    }
}
