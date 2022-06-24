package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer volvo = manufacturerService.create(Manufacturer.of(null,"Volvo", "Sweden"));
        Manufacturer bmw = manufacturerService.create(Manufacturer.of(null,"BMW", "Germany"));
        Manufacturer toyota = manufacturerService.create(Manufacturer.of(null,"Toyota", "Japan"));
        manufacturerService.delete(volvo.getId());
        System.out.println(manufacturerService.get(bmw.getId()));
        System.out.println(manufacturerService.getAll());
        bmw.setCountry("undefined");
        manufacturerService.update(bmw);

        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver alice = driverService.create(Driver.of(null,"Alice", "543818"));
        Driver john = driverService.create(Driver.of(null,"John", "175731"));
        driverService.delete(john.getId());
        alice.setLicenseNumber("793049");
        driverService.update(alice);
        Driver bob = driverService.create(Driver.of(null,"Bob", "154321"));
        System.out.println(driverService.get(bob.getId()));
        System.out.println(driverService.getAll());
    }
}
