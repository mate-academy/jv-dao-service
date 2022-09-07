package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        final ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        System.out.println("ManufacturerService methods testing");
        System.out.println("create() method test");
        Manufacturer peugeot = new Manufacturer();
        peugeot.setName("Peugeot");
        peugeot.setCountry("France");
        System.out.println("Created manufacturer " + peugeot);
        System.out.println("The result of manufacturerService.create(peugeot) should be :");
        System.out.println("Manufacturer : name = \"Peugeot\", country = \"France\", id = 6");
        System.out.println("AND ACTUAL is : " + manufacturerService.create(peugeot));
        System.out.println("------------------------------------------");
        System.out.println("get() method test");
        System.out.println("The result of manufacturerService.get(peugeot.getId()) should be :");
        System.out.println("Manufacturer : name = \"Peugeot\", country = \"France\", id = 6");
        System.out.println("AND ACTUAL is : " + manufacturerService.get(peugeot.getId()));
        System.out.println("------------------------------------------");
        System.out.println("getAll() method test");
        System.out.println("The list-result of manufacturerService.getAll() should contain :");
        System.out.println("Manufacturer : name = \"Peugeot\", country = \"France\", id = 6");
        System.out.println("AND ACTUALlY : " + manufacturerService.getAll());
        System.out.println("------------------------------------------");
        System.out.println("update() method test");
        peugeot.setName("Ford");
        peugeot.setCountry("USA");
        System.out.println("Changed manufacturer params to " + peugeot);
        System.out.println("The result of manufacturerService.update(peugeot) should be :");
        System.out.println("Manufacturer : name = \"Ford\", country = \"USA\", id = 6");
        System.out.println("AND ACTUAL is : " + manufacturerService.update(peugeot));
        System.out.println("And also :");
        System.out.println("The result of manufacturerService.get(peugeot.getId()) method "
                + "after calling update() method");
        System.out.println("should be : "
                + "Manufacturer : name = \"Ford\", country = \"USA\", id = 6");
        System.out.println("AND ACTUAL is : " + manufacturerService.get(peugeot.getId()));
        System.out.println("------------------------------------------");
        System.out.println("delete() method test");
        System.out.println("Result of manufacturerService.delete(mercedes.getId()) "
                + "should be : TRUE");
        System.out.println("AND ACTUAL is : " + manufacturerService.delete(peugeot.getId()));
        System.out.println("And also :");
        System.out.println("The list-result of manufacturerService.getAll() method "
                + "after calling delete() method");
        System.out.println("should NOT contain " + peugeot);
        System.out.println("AND ACTUALYY : " + manufacturerService.getAll());
        System.out.println("------------------------------------------");
        System.out.println("TEST ManufacturerService finished");
        System.out.println("------------------------------------------");
        final DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        System.out.println("DriverService methods testing");
        System.out.println("create() method test");
        Driver alice = new Driver();
        alice.setName("Alice");
        alice.setLicenseNumber("2345");
        System.out.println("Created driver " + alice);
        System.out.println("The result of driverService.create(alice) should be :");
        System.out.println("Driver : name = \"Alice\", license_number = \"2345\", id = 3");
        System.out.println("AND ACTUAL is : " + driverService.create(alice));
        System.out.println("------------------------------------------");
        System.out.println("get() method test");
        System.out.println("The result of driverService.get(alice.getId()) should be :");
        System.out.println("Driver : name = \"Alice\", license_number = \"2345\", id = 3");
        System.out.println("AND ACTUAL is : " + driverService.get(alice.getId()));
        System.out.println("------------------------------------------");
        System.out.println("getAll() method test");
        System.out.println("The list-result of driverService.getAll() should contain :");
        System.out.println("Driver : name = \"Alice\", license_number = \"2345\", id = 3");
        System.out.println("AND ACTUALlY : " + driverService.getAll());
        System.out.println("------------------------------------------");
        System.out.println("update() method test");
        alice.setName("Johny");
        System.out.println("Changed driver params to " + alice);
        System.out.println("The result of driverService.update(alice) should be :");
        System.out.println("Driver : name = \"Johny\", license_number = \"2345\", id = 3");
        System.out.println("AND ACTUAL is : " + driverService.update(alice));
        System.out.println("And also :");
        System.out.println("The result of driverService.get(alice.getId()) method "
                + "after calling update() method");
        System.out.println("should be : "
                + "Driver : name = \"Johny\", license_number = \"2345\", id = 3");
        System.out.println("AND ACTUAL is : " + driverService.get(alice.getId()));
        System.out.println("------------------------------------------");
        System.out.println("delete() method test");
        System.out.println("Result of driverService.delete(alice.getId()) should be : TRUE");
        System.out.println("AND ACTUAL is : " + driverService.delete(alice.getId()));
        System.out.println("And also :");
        System.out.println("The list-result of driverService.getAll() method "
                + "after calling delete() method");
        System.out.println("should NOT contain " + alice);
        System.out.println("AND ACTUALYY : " + driverService.getAll());
        System.out.println("------------------------------------------");
        System.out.println("TEST DriverService finished");
    }
}
