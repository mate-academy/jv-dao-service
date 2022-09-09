package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Manufacturer audi = new Manufacturer();
        audi.setName("Audi");
        audi.setCountry("Germany");
        Manufacturer tesla = new Manufacturer();
        tesla.setName("Tesla");
        tesla.setCountry("USA");
        Manufacturer toyota = new Manufacturer();
        toyota.setName("Toyota");
        toyota.setCountry("Japan");
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        System.out.println("Creating manufacturers: ");
        System.out.println(manufacturerService.create(audi));
        System.out.println(manufacturerService.create(tesla));
        System.out.println(manufacturerService.create(toyota));

        System.out.println("Get Toyota from DB: ");
        System.out.println(manufacturerService.get(toyota.getId()));

        System.out.println("Updating Tesla country to Ukraine");
        tesla.setCountry("Ukraine");
        System.out.println(manufacturerService.update(tesla));

        System.out.println("Deleting Audi from DB: ");
        System.out.println(manufacturerService.delete(audi.getId()));

        System.out.println("Get all manufacturers from DB: ");
        System.out.println(manufacturerService.getAll());

        Driver vlad = new Driver();
        vlad.setName("Vlad");
        vlad.setLicenseNumber("321421");
        Driver bob = new Driver();
        bob.setName("Bob");
        bob.setLicenseNumber("321456");
        Driver alice = new Driver();
        alice.setName("Alice");
        alice.setLicenseNumber("4586782");
        DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);
        System.out.println("Creating drivers: ");
        System.out.println(driverService.create(vlad));
        System.out.println(driverService.create(bob));
        System.out.println(driverService.create(alice));

        System.out.println("Get Vlad from DB: ");
        System.out.println(driverService.get(vlad.getId()));

        System.out.println("Updating Bob`s drivers license to 123321");
        bob.setLicenseNumber("123321");
        System.out.println(driverService.update(bob));

        System.out.println("Deleting Alice from DB: ");
        System.out.println(driverService.delete(alice.getId()));

        System.out.println("Get all drivers from DB: ");
        System.out.println(driverService.getAll());
    }
}
