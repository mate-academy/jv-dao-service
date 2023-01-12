package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Manufacturer manufacturer1 = new Manufacturer();
        Manufacturer manufacturer2 = new Manufacturer();
        manufacturer1.setCountry("Ukraine");
        manufacturer1.setName("VEPR");
        manufacturer2.setCountry("USA");
        manufacturer2.setName("HIMARS");
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        manufacturerService.create(manufacturer1);
        manufacturerService.create(manufacturer2);
        System.out.println(manufacturerService.getAll());
        manufacturerService.update(manufacturer2);
        System.out.println(manufacturerService.getAll());
        Driver driver1 = new Driver();
        Driver driver2 = new Driver();
        driver1.setName("Johnny Depp");
        driver1.setLicenseNumber("30944208");
        driver2.setName("Johnny Cash");
        driver2.setLicenseNumber("30944207");
        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);
        driverService.create(driver1);
        driverService.create(driver2);
        System.out.println(driverService.get(1L));
        System.out.println(driverService.getAll());
        driverService.delete(2L);
        System.out.println(driverService.getAll());
    }
}
