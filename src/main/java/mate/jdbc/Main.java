package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.interfaces.DriverService;
import mate.jdbc.service.interfaces.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);

        Manufacturer tefal = new Manufacturer("Tefal", "France");
        Manufacturer fagor = new Manufacturer("Fagor", "Spain");
        Manufacturer moulinex = new Manufacturer("Moulinex", "France");

        tefal = manufacturerService.create(tefal);
        fagor = manufacturerService.create(fagor);
        moulinex = manufacturerService.create(moulinex);
        Manufacturer getByIdManufacturer = manufacturerService.get(fagor.getId());
        List<Manufacturer> manufacturerList = manufacturerService.getAll();
        tefal.setCountry("Ukraine");
        manufacturerService.update(tefal);
        manufacturerService.delete(moulinex.getId());

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        Driver bob = new Driver("Bob", "#258654");
        Driver alice = new Driver("Alice", "#588964");
        Driver dmytro = new Driver("Dmytro", "#987412");

        bob = driverService.create(bob);
        alice = driverService.create(alice);
        dmytro = driverService.create(dmytro);
        Driver getByIdDriver = driverService.get(alice.getId());
        List<Driver> driverList = driverService.getAll();
        dmytro.setLicenseNumber("#258963");
        driverService.update(dmytro);
        driverService.delete(bob.getId());
    }
}
