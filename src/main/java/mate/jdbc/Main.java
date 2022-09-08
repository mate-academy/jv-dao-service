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

//        System.out.println("ALL DATA BASE:");
//        manufacturerService.getAll().forEach(System.out::println);
//        System.out.println();
//        System.out.println("-------------------------------------------");
//        System.out.println();
//
//        Manufacturer mercedesBenz = new Manufacturer();
//        mercedesBenz.setName("Mercedes-Benz");
//        mercedesBenz.setCountry("Germany");
//        Manufacturer mercedesBenzToDataBase = manufacturerService.create(mercedesBenz);
//        System.out.println(mercedesBenzToDataBase + " was add to DB");
//        System.out.println();
//        System.out.println("-------------------------------------------");
//        System.out.println();
//
//        Manufacturer getMercedesBenz = manufacturerService.get(mercedesBenz.getId());
//        System.out.println("You need this item: " + getMercedesBenz);
//        System.out.println();
//        System.out.println("-------------------------------------------");
//        System.out.println();
//
//        mercedesBenz.setName("Mercedes-Benz C 220 d 4 MATIC");
//        mercedesBenz.setCountry("Germany, Stuttgart");
//        Manufacturer updatedMercedesBenz = manufacturerService.update(mercedesBenz);
//        System.out.println("You update this item: " + updatedMercedesBenz);
//        System.out.println();
//        System.out.println("-------------------------------------------");
//        System.out.println();
//
//        manufacturerService.delete(mercedesBenz.getId());
//        System.out.println("You delete this item: " + mercedesBenz);
//        System.out.println();
//        System.out.println("-------------------------------------------");
//        System.out.println();
//
//        System.out.println("All DB without " + mercedesBenz);
//        manufacturerService.getAll().forEach(System.out::println);
//        System.out.println();
//        System.out.println("-------------------------------------------");
//        System.out.println();

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        Driver driverBob = new Driver();
        driverBob.setName("Bob");
        driverBob.setLicenseNumber("495904");
        Driver createdDriverBob = driverService.create(driverBob);
        System.out.println(createdDriverBob + " was add to DB");
        System.out.println();
        System.out.println("-------------------------------------------");
        System.out.println();

        System.out.println("ALL DATA BASE:");
        driverService.getAll().forEach(System.out::println);
        System.out.println();
        System.out.println("-------------------------------------------");
        System.out.println();
    }
}
