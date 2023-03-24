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
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);

        driverService.create(new Driver("Oleksiy", "34523452344"));
        driverService.create(new Driver("Valeriy", "45634566345"));
        driverService.create(new Driver("Oleksandr", "96784565855"));
        System.out.println(driverService.get(2L));
        driverService.delete(1L);
        for (Driver driver: driverService.getAll()) {
            System.out.println(driver);
        }
        List<Manufacturer> manufacturers = List.of(
                new Manufacturer("Porsche","Germany"),
                new Manufacturer("Volkswagen","Germany"),
                new Manufacturer("Renault", "France"),
                new Manufacturer("Lamborghini", "Italy")
        );

        for (Manufacturer manufacturer : manufacturers) {
            System.out.println("Before: " + manufacturer);
            manufacturer = manufacturerService.create(manufacturer);
            System.out.println("After: " + manufacturer);
        }

        for (Manufacturer manufacturer: manufacturerService.getAll()) {
            System.out.println("get all test" + manufacturer);
        }

        Long id = 1L;
        System.out.println("test get by id" + manufacturerService.get(id));
        Manufacturer manufacturerUpdate = new Manufacturer(1L, "Mercedes-Benz", "Germany");
        System.out.println("update before:" + manufacturerUpdate);
        manufacturerUpdate = manufacturerService.update(manufacturerUpdate);
        System.out.println("update after:" + manufacturerUpdate);
        Long idDelete = 2L;
        manufacturerService.delete(idDelete);

        for (Manufacturer manufacturer : manufacturerService.getAll()) {
            System.out.println(manufacturer);
        }
    }
}
