package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);

        Manufacturer mercedes = new Manufacturer("Mercedes", "Germany");
        Manufacturer ferraris = new Manufacturer("Ferraris", "France");
        Manufacturer lada = new Manufacturer("Lada", "USSR");

        manufacturerService.create(mercedes);
        manufacturerService.create(ferraris);
        manufacturerService.create(lada);
        manufacturerService.getAll().forEach(System.out::println);

        Manufacturer ferrari = manufacturerService.get(ferraris.getId());
        ferrari.setName("Ferrari");
        ferrari.setCountry("Italy");
        manufacturerService.update(ferrari);
        System.out.println("updated" + manufacturerService.get(ferrari.getId()));
        manufacturerService.getAll().forEach(manufacturer -> manufacturerService
                .delete(manufacturer.getId()));
        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);

        Driver bob = new Driver("Bob", "123455");
        Driver john = new Driver("John", "678909");
        Driver alice = new Driver("ALice", "777777");

        driverService.create(bob);
        driverService.create(john);
        driverService.create(alice);
        driverService.getAll().forEach(System.out::println);

        Driver johan = driverService.get(john.getId());
        johan.setName("Johan");
        johan.setLicenseNumber("999999");
        driverService.update(johan);
        System.out.println("updated" + driverService.get(johan.getId()));

        driverService.getAll().forEach(driver -> driverService
                .delete(driver.getId()));
        driverService.getAll().forEach(System.out::println);
    }

}
