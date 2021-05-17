package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final ManufacturerService manufacturerService =
            (ManufacturerService) injector.getInstance(ManufacturerService.class);
    private static final DriverService driverService =
            (DriverService) injector.getInstance(DriverService.class);

    public static void main(String[] args) {
        Manufacturer bmw = new Manufacturer("BMW", "Germany");
        Manufacturer mercedes = new Manufacturer("Mercedes", "Germany");
        Manufacturer ford = new Manufacturer("Ford", "USA");

        System.out.println("----SaveManufacturer----");
        Manufacturer savedBmw = manufacturerService.create(bmw);
        Manufacturer savedMercedes = manufacturerService.create(mercedes);
        Manufacturer savedFord = manufacturerService.create(ford);
        System.out.println(savedFord);
        System.out.println(savedBmw);
        System.out.println(savedMercedes);
        System.out.println();

        System.out.println("----Update----");
        System.out.println("Manufacturer before updating: " + savedBmw);
        savedBmw.setCountry("Ukraine");
        Manufacturer updatedBmw = manufacturerService.update(savedBmw);
        System.out.println(updatedBmw);
        System.out.println();

        System.out.println("---Delete----");
        System.out.println("DB before deleting manufacturer");
        System.out.println(manufacturerService.getAll());
        manufacturerService.delete(updatedBmw.getId());
        System.out.println("DB after deleting manufacturer BMW");
        System.out.println(manufacturerService.getAll());
        System.out.println();

        System.out.println("----Get----");
        System.out.println(manufacturerService.get(savedFord.getId()));

        Driver nick = new Driver("Nick", "12345");
        Driver john = new Driver("John", "54321");

        System.out.println("----Drivers----");
        System.out.println();
        System.out.println("----Save Drivers----");
        Driver savedNick = driverService.create(nick);
        Driver savedJohn = driverService.create(john);
        System.out.println(savedJohn);
        System.out.println(savedNick);
        System.out.println();

        System.out.println("----Update----");
        System.out.println("Driver John before updating" + savedJohn);
        savedJohn.setLicenseNumber("98765");
        Driver updatedJohn = driverService.update(savedJohn);
        System.out.println(updatedJohn);
        System.out.println();

        System.out.println("---Delete----");
        System.out.println("Drivers table before deleting John");
        System.out.println(driverService.getAll());
        driverService.delete(updatedJohn.getId());
        System.out.println("Drivers table after deleting John");
        System.out.println(driverService.getAll());
        System.out.println();

        System.out.println("----Get----");
        System.out.println(driverService.get(savedNick.getId()));
    }
}
