package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);

        Manufacturer ferrari = new Manufacturer();
        ferrari.setCountry("Italy");
        ferrari.setName("Ferrari");
        manufacturerService.create(ferrari);

        Manufacturer lada = new Manufacturer();
        lada.setCountry("USSR");
        lada.setName("Lada");
        manufacturerService.create(lada);

        Manufacturer mercedes = new Manufacturer();
        mercedes.setCountry("Germany");
        mercedes.setName("Mercedes");
        manufacturerService.create(mercedes);

        System.out.println(manufacturerService.get(3L));
        manufacturerService.getAll().forEach(System.out::println);

        lada.setCountry("Ukraine");
        manufacturerService.update(lada);

        manufacturerService.getAll().forEach(System.out::println);

        manufacturerService.delete(2L);

        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        Driver paul = new Driver();
        paul.setName("Paul");
        paul.setLicenseNumber("1");
        driverService.create(paul);

        Driver andrew = new Driver();
        andrew.setName("Andrew");
        andrew.setLicenseNumber("2");
        driverService.create(andrew);

        Driver eugene = new Driver();
        eugene.setName("Eugene");
        eugene.setLicenseNumber("3");
        driverService.create(eugene);

        System.out.println(driverService.get(3L));
        driverService.getAll().forEach(System.out::println);

        eugene.setLicenseNumber("777");
        driverService.update(eugene);

        driverService.getAll().forEach(System.out::println);

        driverService.delete(3L);

        driverService.getAll().forEach(System.out::println);
    }
}
