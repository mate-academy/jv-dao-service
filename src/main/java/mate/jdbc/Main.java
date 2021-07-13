package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final ManufacturerService manufacturerService = (ManufacturerService)
            injector.getInstance(ManufacturerService.class);
    private static final DriverService driverService = (DriverService)
            injector.getInstance(DriverService.class);

    public static void main(String[] args) {
        Manufacturer volkswagen = new Manufacturer();
        volkswagen.setName("Volkswagen");
        volkswagen.setCountry("Germany");
        manufacturerService.create(volkswagen);
        Manufacturer volvo = new Manufacturer();
        volvo.setName("Volvo");
        volvo.setCountry("Sweden");
        manufacturerService.create(volvo);
        Manufacturer tesla = new Manufacturer();
        tesla.setName("Tesla");
        tesla.setCountry("USA");
        manufacturerService.create(tesla);

        Driver bob = new Driver();
        bob.setName("Bob");
        bob.setLicenseNumber("SDF2215");
        driverService.create(bob);
        Driver linda = new Driver();
        linda.setName("Linda");
        linda.setLicenseNumber("DFG6581");
        driverService.create(linda);
        Driver tom = new Driver();
        tom.setName("Tom");
        tom.setLicenseNumber("YUI1544");
        driverService.create(tom);

        manufacturerService.getAll().forEach(System.out::println);
        driverService.getAll().forEach(System.out::println);

        linda.setLicenseNumber("HJK1145");
        driverService.update(linda);
        System.out.println(driverService.get(linda.getId()));
    }
}
