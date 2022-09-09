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
        Manufacturer bugatti = new Manufacturer(null,"Bugatti", "France");
        Manufacturer rollsRoyce = new Manufacturer(null,"Rolls-Royce", "England");
        Manufacturer ford = new Manufacturer(null,"Ford", "USA");
        bugatti = manufacturerService.create(bugatti);
        rollsRoyce = manufacturerService.create(rollsRoyce);
        ford = manufacturerService.create(ford);
        System.out.println("*************************************************");
        System.out.println("*             Create 3 manufacturers            *");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("*************************************************");
        System.out.println("*   Change name manufacturer Ford to Cadillac   *");
        ford.setName("Cadillac");
        manufacturerService.update(ford);
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("*************************************************");
        System.out.println("* Delete manufacturer Rolls-Royce from database *");
        manufacturerService.delete(rollsRoyce.getId());
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("*************************************************");
        System.out.println("*      Get manufacturer Bugatti from database      *");
        Manufacturer getManufacturer = manufacturerService.get(bugatti.getId());
        System.out.println(getManufacturer);
        System.out.println("-------------------------------------");

        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver yarik = new Driver(null, "Yarik", "JV7777777JV");
        Driver oleg = new Driver(null, "Oleg", "QQ1111111HT");
        driverService.create(yarik);
        driverService.create(oleg);
        System.out.println("***** Added 2 drivers *****");
        driverService.getAll().forEach(System.out::println);
        System.out.println("***********************************");
        oleg.setLicenseNumber("WW0000000DB");
        driverService.update(oleg);
        System.out.println("***** Updated Oleg driver *****");
        System.out.println(driverService.get(oleg.getId()));
        System.out.println("***********************************");
        driverService.delete(yarik.getId());
        System.out.println("***** Deleted Yarik driver *****");
        driverService.getAll().forEach(System.out::println);
    }
}
