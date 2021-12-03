package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.servise.DriverService;
import mate.jdbc.servise.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);

        manufacturerService.create(new Manufacturer("Lada", "Russsia"));
        manufacturerService.create(new Manufacturer("Pegout", "France"));
        Manufacturer manufacturerTest = new Manufacturer("Honda", "Japan");
        manufacturerService.create(manufacturerTest);
        System.out.println(manufacturerService.get(1L));
        System.out.println(manufacturerService.getAll());

        manufacturerTest.setName("Mitsubishi");
        manufacturerService.update(manufacturerTest);
        manufacturerService.delete(2L);
        System.out.println(manufacturerService.getAll());

        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);

        driverService.create(new Driver("Oleh", "123"));
        driverService.create(new Driver("Ihor", "456"));
        Driver driverTest = new Driver("Ivan", "789");
        driverService.create(driverTest);
        System.out.println(driverService.get(2L));
        System.out.println(driverService.getAll());

        driverTest.setLicenseNumber("007");
        driverService.update(driverTest);
        System.out.println(driverService.getAll());

        driverService.delete(1L);
        System.out.println(driverService.getAll());
    }
}
