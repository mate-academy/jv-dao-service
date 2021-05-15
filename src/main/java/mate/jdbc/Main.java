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

        Manufacturer fiat = new Manufacturer("Fiat", "France");
        Manufacturer ferrari = new Manufacturer("Ferrari", "Italy");

        System.out.println("Save Manufacturer:");
        Manufacturer savedFiat = manufacturerService.create(fiat);
        Manufacturer savedFerrari = manufacturerService.create(ferrari);
        System.out.println(savedFiat);
        System.out.println(savedFerrari);
        System.out.println();

        System.out.println("Update Manufacturer:");
        savedFiat.setCountry("Germany");
        savedFerrari.setCountry("Ukraine");
        Manufacturer updateFiat = manufacturerService.update(savedFiat);
        Manufacturer updateFerrari = manufacturerService.update(savedFerrari);
        System.out.println(updateFiat);
        System.out.println(updateFerrari);
        System.out.println();

        System.out.println("Delete Manufacturer:");
        System.out.println("All manufacturers");
        System.out.println(manufacturerService.getAll());
        System.out.println(manufacturerService.delete(savedFiat.getId()));
        System.out.println("All manufacturers after delete");
        System.out.println(manufacturerService.getAll());
        System.out.println();

        System.out.println("Get manufacturer");
        System.out.println(manufacturerService.get(savedFerrari.getId()));
        System.out.println();

        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);

        Driver vova = new Driver("Vova", "2354");

        System.out.println("Drivers");
        Driver savedVova = driverService.create(vova);
        System.out.println(savedVova);
        System.out.println();

        System.out.println("Update drivers");
        savedVova.setLicenseNumber("7777");
        Driver updateVova = driverService.update(savedVova);
        System.out.println(updateVova);
        System.out.println();

        System.out.println("Get driver by id");
        System.out.println(driverService.get(savedVova.getId()));
        System.out.println();

        System.out.println("Delete drivers");
        System.out.println(driverService.getAll());
        System.out.println(driverService.delete(savedVova.getId()));
        System.out.println(driverService.getAll());
        System.out.println();
    }
}
