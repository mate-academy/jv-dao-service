package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver intel = new Driver("Intel", "ABRACADABRA128500");
        System.out.println(driverService.create(intel));
        Driver amd = new Driver("AMD", "Unlimited2021");
        System.out.println(driverService.create(amd));
        System.out.println(driverService.get(intel.getId()));
        System.out.println(driverService.delete(amd.getId()));
        intel.setName("Intel Core");
        System.out.println(driverService.update(intel));
        System.out.println(driverService.getAll());

        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer astraZeneca = new Manufacturer("AstraZeneca", "UnitedKingdom");
        System.out.println(manufacturerService.create(astraZeneca));
        Manufacturer pfizer = new Manufacturer("Pfizer", "USA");
        System.out.println(manufacturerService.create(pfizer));
        System.out.println(manufacturerService.get(astraZeneca.getId()));
        System.out.println(manufacturerService.delete(pfizer.getId()));
        astraZeneca.setCountry("India");
        System.out.println(manufacturerService.update(astraZeneca));
        System.out.println(manufacturerService.getAll());
    }
}
