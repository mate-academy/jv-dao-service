package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.interfaces.DriverService;
import mate.jdbc.service.interfaces.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final ManufacturerService manufacturerService =
            (ManufacturerService) injector.getInstance(ManufacturerService.class);
    private static final DriverService driverService =
            (DriverService) injector.getInstance(DriverService.class);

    public static void main(String[] args) {
        Manufacturer amd = new Manufacturer("AMD", "USA");
        Manufacturer nvidia = new Manufacturer("Nvidia", "USA");
        Manufacturer intel = new Manufacturer("Intel", "USA");

        //Create
        manufacturerService.create(amd);

        //Delete
        manufacturerService.delete(amd.getId());

        //Create
        manufacturerService.create(nvidia);
        manufacturerService.create(intel);

        //Read
        System.out.println("Get Nvidia " + manufacturerService
                .get(nvidia.getId()));

        //Update
        nvidia.setCountry("Ukraine");
        manufacturerService.update(nvidia);
        System.out.println("Updated Nvidia " + nvidia);

        //Update
        intel.setCountry("Ukraine");
        manufacturerService.update(intel);
        System.out.println("Updated Intel " + intel);

        //Read
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("Get Nvidia " + manufacturerService.get(nvidia.getId()));

        Driver david = new Driver("David Pearson", "L-355M");
        Driver sebastian = new Driver("Sebastian Vettel", "L-892N");
        Driver danica = new Driver("Danica Patrick", "L-845P");

        //Create
        driverService.create(david);

        //Delete
        driverService.delete(david.getId());

        //Create
        driverService.create(sebastian);
        driverService.create(danica);

        //Read
        System.out.println("Get Sebastian " + driverService
                .get(sebastian.getId()));

        //Update
        david.setLicenseNumber("8484486");
        driverService.update(david);
        System.out.println("Updated David " + david);

        //Update
        danica.setLicenseNumber("V-3534");
        driverService.update(danica);
        System.out.println("Updated Danica " + danica);

        //Read
        driverService.getAll().forEach(System.out::println);
        System.out.println("Get Danica " + driverService.get(danica.getId()));
    }
}
