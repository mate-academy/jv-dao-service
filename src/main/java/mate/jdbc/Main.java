package mate.jdbc;

import mate.jdbc.dao.DriverDao;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver kitti = new Driver();
        kitti.setName("Kate");
        kitti.setLicenseNumber("Q1W2E3");
        Driver bob = new Driver();
        bob.setName("Bob");
        bob.setLicenseNumber("4R5T6Y");

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        driverService.create(kitti);
        driverService.create(bob);
        kitti.setLicenseNumber("1Z2X3C");
        driverService.update(kitti);
        System.out.println(driverService.get(bob.getId()));
        driverService.delete(bob.getId());
        driverService.getAll().forEach(System.out::println);

        Manufacturer bmw = new Manufacturer();
        bmw.setName("BMW");
        bmw.setCountry("Germany");
        Manufacturer maserati = new Manufacturer();
        maserati.setName("Maserati");
        maserati.setCountry("Italy");

        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        manufacturerService.create(bmw);
        manufacturerService.create(maserati);
        maserati.setCountry("USA");
        manufacturerService.update(maserati);
        System.out.println(manufacturerService.get(bmw.getId()));
        manufacturerService.delete(bmw.getId());
        manufacturerService.getAll().forEach(System.out::println);
    }
}
