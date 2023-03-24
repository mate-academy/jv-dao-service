package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;
import mate.jdbc.service.impl.DriverServiceImpl;
import mate.jdbc.service.impl.ManufacturerServiceImpl;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final ManufacturerService manufacturerService
            = (ManufacturerServiceImpl) injector.getInstance(ManufacturerService.class);
    private static final DriverService driverService
            = (DriverServiceImpl) injector.getInstance(DriverService.class);

    public static void main(String[] args) {

        Manufacturer manufacturer1 = new Manufacturer();
        manufacturer1.setName("bmw");
        manufacturer1.setCountry("germany");

        Manufacturer manufacturer2 = new Manufacturer();
        manufacturer2.setName("audi");
        manufacturer2.setCountry("germany");

        Manufacturer manufacturer3 = new Manufacturer();
        manufacturer3.setName("porsche");
        manufacturer3.setCountry("germany");

        Driver driver1 = new Driver();
        driver1.setName("David");
        driver1.setLicenceNumber("GU777333111");

        Driver driver2 = new Driver();
        driver2.setName("Bill");
        driver2.setLicenceNumber("USA999222111");

        manufacturerService.create(manufacturer1);
        manufacturerService.create(manufacturer2);
        manufacturerService.create(manufacturer3);
        System.out.println(manufacturerService.getAll());

        driverService.create(driver1);
        driverService.create(driver2);
        System.out.println(driverService.getAll());

        manufacturer2.setName("ferrari");
        manufacturer2.setCountry("italy");
        manufacturerService.update(manufacturer2);
        System.out.println(manufacturerService.get(manufacturer2.getId()));

        driver1.setName("Vitaliy");
        driver1.setLicenceNumber("UA888999333");
        driverService.update(driver1);
        System.out.println(driverService.get(driver1.getId()));

        driverService.delete(driver2.getId());
        System.out.println(driverService.getAll());

        manufacturerService.delete(manufacturer1.getId());
        System.out.println(manufacturerService.getAll());
    }
}
