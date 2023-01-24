package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Manufacturer citroen = new Manufacturer();
        citroen.setCountry("France");
        citroen.setName("Citroen");
        Manufacturer alfaRomeo = new Manufacturer();
        alfaRomeo.setName("Alfa Romeo");
        alfaRomeo.setCountry("China");
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        manufacturerService.create(citroen);
        manufacturerService.create(alfaRomeo);
        alfaRomeo.setCountry("Italy");
        System.out.println(manufacturerService.update(alfaRomeo));
        System.out.println(manufacturerService.getAll());

        Driver sebastienLoeb = new Driver();
        sebastienLoeb.setName("Sebastien Loeb");
        sebastienLoeb.setLicenseNumber("2332");
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        driverService.create(sebastienLoeb);
        System.out.println(driverService.getAll());
    }
}
