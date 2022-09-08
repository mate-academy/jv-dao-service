package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufecturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);

        System.out.println();
        System.out.println("ALL DATA BASE:");
        System.out.println();
        manufecturerService.getAll().forEach(System.out::println);
        System.out.println();
        System.out.println("-------------------------------------------");
        System.out.println();

        Manufacturer mercedesBenz = new Manufacturer();
        mercedesBenz.setName("Mercedes-Benz");
        mercedesBenz.setCountry("Germany");
        Manufacturer mercedesBenzToDataBase = manufecturerService.create(mercedesBenz);
        System.out.println(mercedesBenz + " was add to DB");
        System.out.println();
        System.out.println("-------------------------------------------");
    }
}
