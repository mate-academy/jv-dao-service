package mate.jdbc;

import java.sql.SQLException;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate");

    public static void main(String[] args) throws SQLException {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer bmv = new Manufacturer("BMW", "Germany");
        Manufacturer toyota = new Manufacturer("Toyota", "France");
        Manufacturer hyundai = new Manufacturer("Hyundai", "USA");

        Manufacturer savedBmv = manufacturerService.create(bmv);
        Manufacturer savedToyota = manufacturerService.create(toyota);
        Manufacturer savedHyundai = manufacturerService.create(hyundai);

        savedToyota.setCountry("USA");
        Manufacturer updatedToyota = manufacturerService.update(savedToyota);
        Manufacturer bmvFromDB = manufacturerService.get(savedBmv.getId());
        manufacturerService.delete(savedHyundai.getId());

        System.out.println(manufacturerService.getAll());

        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver john = new Driver("John", "123456789");
        Driver maks = new Driver("Maks", "234567890");
        Driver bob = new Driver("Bob", "345678901");

        Driver savedJohn = driverService.create(john);
        Driver savedMaks = driverService.create(maks);
        Driver savedBob = driverService.create(bob);

        savedJohn.setLicenseNumber("112345678");
        Driver updatedJohn = driverService.update(savedJohn);
        Driver maksFromDB = driverService.get(savedMaks.getId());
        driverService.delete(savedBob.getId());

        System.out.println(driverService.getAll());
    }
}
