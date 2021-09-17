package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        // test your code here
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        Manufacturer mercedes = new Manufacturer("Mercedes", "Germany");
        Manufacturer renault = new Manufacturer("Renault", "France");
        mercedes = manufacturerService.create(mercedes);
        renault = manufacturerService.create(renault);
        System.out.println(manufacturerService.getAll());
        renault.setCountry("Argentina");
        manufacturerService.update(renault);
        manufacturerService.delete(mercedes.getId());
        System.out.println(manufacturerService.get(renault.getId()));
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        Driver ivan = new Driver("Ivan", "d93je9e");
        Driver petro = new Driver("Petro", "dddj043");
        ivan = driverService.create(ivan);
        petro = driverService.create(petro);
        System.out.println(driverService.getAll());
        ivan.setLicenseNumber("dksgag");
        driverService.update(ivan);
        driverService.delete(petro.getId());
        System.out.println(driverService.get(ivan.getId()));
    }
}
