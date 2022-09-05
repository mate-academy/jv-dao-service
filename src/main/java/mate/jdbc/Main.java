package mate.jdbc;

import java.util.Arrays;
import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver petro = new Driver("Petro", "BAH 123456");
        Driver taras = new Driver("Taras", "DAH 654321");
        Driver maxim = new Driver("Maxim", "SAT 546782");
        Driver max = new Driver("Max", "SAT 123456");
        List<Driver> drivers = Arrays.asList(petro, taras, maxim, max);
        for (Driver driver: drivers) {
            driverService.create(driver);
        }
        drivers.forEach(System.out::println);
        driverService.getAll().forEach(System.out::println);
        maxim.setLicenseNumber("SAT 546785");
        driverService.update(maxim);
        driverService.delete(max.getId());
        driverService.getAll().forEach(System.out::println);
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        Manufacturer renault = new Manufacturer("Renault", "France");
        Manufacturer volkswagen = new Manufacturer("Volkswagen", "Germany");
        Manufacturer audi = new Manufacturer("Audi", "Germany");
        Manufacturer bmw = new Manufacturer("bmw", "GERMANY");
        Manufacturer opel = new Manufacturer("Opel", "Germany");
        Manufacturer opel2 = new Manufacturer("Opel", "Germany");
        List<Manufacturer> manufacturers = Arrays.asList(
                renault, volkswagen, audi, bmw, opel, opel2);
        for (Manufacturer manufacturer: manufacturers) {
            manufacturerService.create(manufacturer);
        }
        manufacturers.forEach(System.out::println);
        manufacturerService.getAll().forEach(System.out::println);
        bmw.setName("BMW");
        bmw.setName("Germany");
        manufacturerService.update(bmw);
        manufacturerService.delete(opel2.getId());
        manufacturerService.getAll().forEach(System.out::println);
    }
}
