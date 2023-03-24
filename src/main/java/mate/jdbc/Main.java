package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.sevice.impl.DriverServiceImpl;
import mate.jdbc.sevice.impl.ManufacturerServiceImpl;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        final ManufacturerServiceImpl manufacturerService
                = (ManufacturerServiceImpl) injector.getInstance(ManufacturerServiceImpl.class);
        final DriverServiceImpl driverService
                = (DriverServiceImpl) injector.getInstance(DriverServiceImpl.class);
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
