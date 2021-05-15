package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final ManufacturerService manufacturerService =
            (ManufacturerService) injector.getInstance(ManufacturerService.class);
    private static final DriverService driverService = (DriverService)
            injector.getInstance(DriverService.class);

    public static void main(String[] args) {
        Manufacturer porscheManufacturer = new Manufacturer();
        porscheManufacturer.setName("Porshe");
        porscheManufacturer.setCountry("Poland");
        Manufacturer appleManufacturer = new Manufacturer();
        appleManufacturer.setName("Apple");
        appleManufacturer.setCountry("USA");

        System.out.println(manufacturerService.create(porscheManufacturer));
        System.out.println(manufacturerService.create(appleManufacturer));
        System.out.println(manufacturerService.delete(porscheManufacturer.getId()));
        System.out.println(manufacturerService.getAll());
        appleManufacturer.setName("CoolerAppleName");
        System.out.println(manufacturerService.update(appleManufacturer));
        System.out.println(manufacturerService.get(appleManufacturer.getId()));

        Driver andrii = new Driver("Andrii", "123456");
        Driver pavlo = new Driver("Pavlo", "654321");

        System.out.println(driverService.create(andrii));
        System.out.println(driverService.create(pavlo));
        System.out.println(driverService.delete(andrii.getId()));
        System.out.println(driverService.getAll());
        pavlo.setLicenseNumber("123456");
        System.out.println(driverService.update(pavlo));
        System.out.println(driverService.get(pavlo.getId()));
    }
}
