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
        Manufacturer manufacturerMers =
                new Manufacturer(null, "Mercedes", "Germany");
        Manufacturer manufacturerBmv =
                new Manufacturer(null, "Bmv", "Germany");
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer1 = manufacturerService.create(manufacturerMers);
        Manufacturer manufacturer2 = manufacturerService.create(manufacturerBmv);
        System.out.println(manufacturer1);
        System.out.println(manufacturer2);

        List<Manufacturer> all = manufacturerService.getAll();
        System.out.println(all);

        Manufacturer manufacturerIndex = manufacturerService.get(2L);
        System.out.println(manufacturerIndex);

        manufacturerBmv.setName("Opel");
        Manufacturer manufacturer2Update = manufacturerService.update(manufacturerBmv);
        System.out.println(manufacturer2Update);

        boolean delete = manufacturerService.delete(manufacturer1.getId());
        System.out.println(delete);
        System.out.println(manufacturerService.getAll());
        Driver driverMers = new Driver(null, "Shumaher", "777");
        Driver driverBmv = new Driver(null, "Davidich", "000");
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver driver1 = driverService.create(driverMers);
        Driver driver2 = driverService.create(driverBmv);
        System.out.println(driver1);
        System.out.println(driver2);

        List<Driver> driverAll = driverService.getAll();
        System.out.println(driverAll);

        Driver driverIndex = driverService.get(2L);
        System.out.println(driverIndex);

        driverBmv.setName("Brodyaga");
        Driver driver2Update = driverService.update(driverBmv);
        System.out.println(driver2Update);

        boolean delete1 = driverService.delete(driver1.getId());
        System.out.println(delete1);
        System.out.println(driverService.getAll());
    }
}
