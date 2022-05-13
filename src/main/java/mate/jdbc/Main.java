package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);
        Driver driver1 = new Driver(null, "Dima", "11111");
        Driver driver2 = new Driver(null, "Ivan", "22222");
        driverService.create(driver1);
        driverService.create(driver2);
        driver1.setName("Denis");
        driverService.update(driver1);
        System.out.println(driverService.get(driver2.getId()));
        driverService.delete(driver2.getId());
        driverService.getAll().forEach(System.out::println);
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer1 = new Manufacturer(null, "Volkswagen", "Germany");
        Manufacturer manufacturer2 = new Manufacturer(null, "Kia", "South Korea");
        manufacturerService.create(manufacturer1);
        manufacturerService.create(manufacturer2);
        manufacturer2.setName("KIA");
        manufacturerService.update(manufacturer2);
        System.out.println(manufacturerService.get(manufacturer1.getId()));
        manufacturerService.delete(manufacturer1.getId());
        manufacturerService.getAll().forEach(System.out::println);
    }
}
