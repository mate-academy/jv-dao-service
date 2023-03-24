package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
    private static final DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);

    public static void main(String[] args) {
        manufacturerService.create(new Manufacturer("Porsche","Germany"));
        manufacturerService.create(new Manufacturer("BMW","Germany"));
        manufacturerService.create(new Manufacturer("Hyundai", "South Korea"));
        driverService.create(new Driver("Petro","QW123456"));
        driverService.create(new Driver("Vika","QS123656"));
        driverService.create(new Driver("Bob","MW125456"));
        System.out.println(driverService.get(1L));
        System.out.println(driverService.get(2L));
        System.out.println(driverService.get(3L));
        System.out.println(manufacturerService.get(1L));
        System.out.println(manufacturerService.get(2L));
        System.out.println(manufacturerService.get(3L));
        manufacturerService.delete(2L);
        manufacturerService.update(new Manufacturer(3L,"Peugeot","France"));
        driverService.delete(3L);
        driverService.update(new Driver(2L,"Viktor","QS123657"));
        manufacturerService.getAll().forEach(System.out::println);
        driverService.getAll().forEach(System.out::println);
    }
}
