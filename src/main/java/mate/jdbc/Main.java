package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        Manufacturer saab = new Manufacturer("SAAB", "Sweden");
        Manufacturer jeep = new Manufacturer("Jeep", "USA");
        Manufacturer renault = new Manufacturer("Renault", "France");

        manufacturerService.create(saab);
        manufacturerService.create(jeep);
        manufacturerService.create(renault);
        System.out.println(manufacturerService.get(saab.getId()));
        saab.setName("Spyker");
        manufacturerService.update(saab);
        manufacturerService.delete(renault.getId());
        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);
        Driver morales = new Driver("Morales", "LIC-228");
        Driver toretto = new Driver("Toretto", "LIC-132");
        Driver okonnor = new Driver("O'Konnor", "LIC-911");

        driverService.create(morales);
        driverService.create(toretto);
        driverService.create(okonnor);
        driverService.get(morales.getId());
        toretto.setName("Diesel");
        driverService.update(toretto);
        driverService.delete(okonnor.getId());
        driverService.getAll().forEach(System.out::println);
    }
}
