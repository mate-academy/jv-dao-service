package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        /**
        * // check ManufacturerService methods work
        */
        //add manufacturer1
        Manufacturer bmw = new Manufacturer();
        bmw.setName("BMW");
        bmw.setCountry("Germany");
        //add manufacturer2
        Manufacturer dodge = new Manufacturer();
        dodge.setName("Dodge");
        dodge.setCountry("USA");
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        // check 'create' method work
        manufacturerService.create(bmw);
        System.out.println("Add manufacturer1 success");
        manufacturerService.create(dodge);
        System.out.println("Add manufacturer2 success");
        // check 'get' method work
        System.out.println(manufacturerService.get(bmw.getId()));
        // check 'update' method work
        bmw.setName("BMW_GT");
        bmw.setCountry("Germany");
        manufacturerService.update(bmw);
        // check 'delete' method work
        manufacturerService.delete(dodge.getId());
        System.out.println("Delete manufacturer2 success");
        // check 'getAll' method work
        System.out.println(manufacturerService.getAll());
        /**
         * // check DriverService methods work
         */
        Driver bob = new Driver();
        bob.setName("Bob");
        bob.setLicenseNumber("1234578zxc");
        Driver john = new Driver();
        john.setName("John");
        john.setLicenseNumber("1789zxcas");
        Driver bruce = new Driver();
        bruce.setName("Bruce");
        bruce.setLicenseNumber("145tys5658");
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        // check 'create' method work
        System.out.println(driverService.create(bob));
        System.out.println(driverService.create(john));
        System.out.println(driverService.create(bruce));
        // check 'get' method work
        System.out.println(driverService.get(bob.getId()));
        // check 'update' method work
        bruce.setLicenseNumber("newLicenceNumber");
        System.out.println(driverService.update(bruce));
        // check 'delete' method work
        driverService.delete(john.getId());
        // check 'getAll' method work
        System.out.println(driverService.getAll());
    }
}
