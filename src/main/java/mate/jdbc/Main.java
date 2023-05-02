package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver driverJo = new Driver();
        driverJo.setName("Jo");
        driverJo.setLicenseNumber("10202");

        Driver driverHu = new Driver();
        driverHu.setName("Hu");
        driverHu.setLicenseNumber("58474");

        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);

        driverService.create(driverJo);
        driverService.create(driverHu);

        driverJo.setLicenseNumber("30392");
        driverService.update(driverJo);

        driverService.delete(2L);

        System.out.println(driverService.get(1L));
        driverService.getAll().forEach(System.out::println);

        Manufacturer manufacturerSonySA = new Manufacturer();
        manufacturerSonySA.setName("Jo");
        manufacturerSonySA.setCountry("SA");

        Manufacturer manufacturerNvidia = new Manufacturer();
        manufacturerNvidia.setName("Hu");
        manufacturerNvidia.setCountry("China");

        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);

        manufacturerService.create(manufacturerSonySA);
        manufacturerService.create(manufacturerNvidia);

        manufacturerSonySA.setCountry("Ukraine");
        manufacturerService.update(manufacturerSonySA);

        manufacturerService.delete(3L);

        System.out.println(manufacturerService.get(2L));
        manufacturerService.getAll().forEach(System.out::println);
    }
}
