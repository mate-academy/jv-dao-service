package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driverBob = new Driver("Bob", "1234");
        Driver driverAlice = new Driver("Alice", "4567");
        Driver driverBill = new Driver("Bill", "7890");
        driverService.create(driverAlice);
        driverService.create(driverBill);
        driverService.create(driverBob);
        System.out.println(driverService.get(driverAlice.getId()));
        System.out.println("-------------------------------------------------");
        System.out.println(driverService.getAll());
        System.out.println("-------------------------------------------------");
        driverService.delete(driverAlice.getId());
        System.out.println(driverService.getAll());
        System.out.println("-------------------------------------------------");
        driverBob.setLicenseNumber("0001");
        System.out.println(driverService.update(driverBob));
        System.out.println("-------------------------------------------------");
        System.out.println("-------------------------------------------------");
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturerAudi = new Manufacturer("AUDI", "Germany");
        Manufacturer manufacturerRenault = new Manufacturer("Renault", "France");
        Manufacturer manufacturerToyota = new Manufacturer("Toyota", "Japan");
        manufacturerService.create(manufacturerAudi);
        manufacturerService.create(manufacturerToyota);
        manufacturerService.create(manufacturerRenault);
        System.out.println(manufacturerService.get(manufacturerAudi.getId()));
        System.out.println("-------------------------------------------------");
        System.out.println(manufacturerService.getAll());
        System.out.println("-------------------------------------------------");
        manufacturerService.delete(manufacturerAudi.getId());
        System.out.println(manufacturerService.getAll());
        System.out.println("-------------------------------------------------");
        manufacturerRenault.setCountry("Ukraine");
        System.out.println(manufacturerService.update(manufacturerRenault));
    }
}
