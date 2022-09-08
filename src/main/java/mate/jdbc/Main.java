package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Manufacturer zaz = new Manufacturer();
        zaz.setName("ZAZ");
        zaz.setCountry("Ukraine");
        Manufacturer audi = new Manufacturer();
        audi.setName("Audi");
        audi.setCountry("Germany");
        Manufacturer skoda = new Manufacturer();
        skoda.setName("Skoda");
        skoda.setCountry("Czech");
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);

        System.out.println("Test of creating manufacturer:");
        System.out.println(manufacturerService.create(zaz));
        System.out.println(manufacturerService.create(audi));
        System.out.println(manufacturerService.create(skoda));

        System.out.println("Test of getting manufacturer by id:");
        Manufacturer gottenManufacturer = manufacturerService.get(zaz.getId());
        System.out.println(gottenManufacturer);

        System.out.println("Test of updating manufacturer:");
        zaz.setName("LuAZ");
        System.out.println(manufacturerService.update(zaz));

        System.out.println("Test of deleting manufacturer:");
        boolean deletedManufacturer = manufacturerService.delete(zaz.getId());
        System.out.println(deletedManufacturer);

        System.out.println("Test of getting all manufacturers:");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println();

        Driver olha = new Driver();
        olha.setName("Olha");
        olha.setLicenseNumber("11111111");
        Driver valentyn = new Driver();
        valentyn.setName("Valentyn");
        valentyn.setLicenseNumber("22222222");
        Driver ivan = new Driver();
        ivan.setName("Ivan");
        ivan.setLicenseNumber("33333333");
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);

        System.out.println("Test of creating driver:");
        System.out.println(driverService.create(olha));
        System.out.println(driverService.create(valentyn));
        System.out.println(driverService.create(ivan));

        System.out.println("Test of getting driver by id:");
        Driver gottenDriver = driverService.get(olha.getId());
        System.out.println(gottenDriver);

        System.out.println("Test of updating driver:");
        olha.setLicenseNumber("88888888");
        System.out.println(driverService.update(olha));

        System.out.println("Test of deleting driver:");
        boolean deletedDriver = driverService.delete(olha.getId());
        System.out.println(deletedDriver);

        System.out.println("Test of getting all drivers:");
        driverService.getAll().forEach(System.out::println);
    }
}
