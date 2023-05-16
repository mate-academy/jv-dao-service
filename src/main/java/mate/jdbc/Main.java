package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufactureService;

public class Main {
    public static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufactureService manufactureService = (ManufactureService) injector
                .getInstance(ManufactureService.class);

        /*
         * Bydemo vvajaty ci slavetni Ukrayinski mista
         * mekkoyu svitovoi automobilnoi industrii. ;-)
         */

        Manufacturer druchok = new Manufacturer("Druchok", "Bila Cerkva");
        Manufacturer drizdopal = new Manufacturer("Drizdopal", "Lohvycya");
        Manufacturer pepelac = new Manufacturer("Pepelac", "Rokytne");
        Manufacturer frankenstain = new Manufacturer("Frankenstain", "Berdychiv");

        manufactureService.create(druchok);
        manufactureService.create(drizdopal);
        manufactureService.create(pepelac);
        manufactureService.create(frankenstain);
        manufactureService.getAll().forEach(System.out::println);
        System.out.println("===========================");

        manufactureService.update(new Manufacturer(2L, "Shkarlypa", "Polonyna"));
        manufactureService.delete(3L);
        manufactureService.getAll().forEach(System.out::println);
        System.out.println("===========================");
        System.out.println(manufactureService.get(4L));

        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);
        Driver grysha = new Driver("Grysha", "qh23jcb");
        Driver mysha = new Driver("Mysha", "qwei14ww");
        Driver opanas = new Driver("Opanas", "khto88hh");

        driverService.create(grysha);
        driverService.create(mysha);
        driverService.create(opanas);
        driverService.getAll().forEach(System.out::println);
        System.out.println("===========================");

        driverService.update(new Driver(2L, "Tolya", "zxcv43gh"));
        driverService.delete(3L);
        driverService.getAll().forEach(System.out::println);
        System.out.println("===========================");

        System.out.println(driverService.get(1L));
    }
}
