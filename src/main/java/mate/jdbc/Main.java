package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.sevice.DriverService;
import mate.jdbc.sevice.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final ManufacturerService manufacturerService
            = (ManufacturerService) injector.getInstance(ManufacturerService.class);
    private static final DriverService driverService
            = (DriverService) injector.getInstance(DriverService.class);

    public static void main(String[] args) {
        Manufacturer manufacturer1 = new Manufacturer("bmv", "germany");
        Manufacturer manufacturer2 = new Manufacturer("honda", "japan");
        manufacturerService.create(manufacturer1);
        manufacturerService.create(manufacturer2);
        manufacturer1.setCountry("Ukraine");
        manufacturerService.update(manufacturer1);
        System.out.println(manufacturerService.get(1L));
        manufacturerService.delete(1L);
        System.out.println(manufacturerService.getAll());

        Driver driver1 = new Driver("Oleg", "aa1234bb");
        Driver driver2 = new Driver("Petro", "bb4344cc");
        driverService.create(driver1);
        driverService.create(driver2);
        driver1.setLicenceNumber("newNumber");
        driverService.update(driver1);
        System.out.println(driverService.get(1L));
        driverService.delete(1L);
        System.out.println(driverService.getAll());
    }
}
