package mate.jdbc;

import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.DriverServiceImpl;
import mate.jdbc.service.ManufacturerService;
import mate.jdbc.service.ManufacturerServiceImpl;
import mate.jdbc.util.Injector;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufactureService =
                (ManufacturerServiceImpl) injector.getInstance(ManufacturerService.class);

        System.out.println("new volvo adding...");
        Manufacturer newVolvoFromDB = manufactureService.create(
                new Manufacturer(null, "volvo", "Sweden"));
        System.out.println("new volvo added to db: " + newVolvoFromDB.getId());
        Manufacturer strangeVolvo = manufactureService.create(
                new Manufacturer(null, "volvo", "Finnland"));
        System.out.println("and strange Volvo added to db: " + strangeVolvo.getId());
        System.out.println("here is WITH strange volvo from Finnland");
        manufactureService.getAll().forEach(System.out::println);
        manufactureService.delete(Long.valueOf(strangeVolvo.getId()));
        System.out.println("here is no strange volvo from Finnland");
        manufactureService.getAll().forEach(System.out::println);
        Manufacturer firstVolvo = manufactureService.get(Long.valueOf(1));
        firstVolvo.setCountry("Africa");
        System.out.println("normal Volvo to even stranger!");
        manufactureService.update(firstVolvo);
        manufactureService.getAll().forEach(System.out::println);
        System.out.println("enough with volvos, lets gettin rumble with drivers");

        DriverService driverService =
                (DriverServiceImpl) injector.getInstance(DriverService.class);

        Driver firstDriver = driverService.create(new Driver(null, "alex", "123"));
        driverService.getAll().forEach(System.out::println);
        driverService.delete(firstDriver.getId());
        driverService.getAll().forEach(System.out::println);
        Driver another = driverService.get(Long.valueOf(1));
        another.setName("Yuliia");
        driverService.update(another);
        driverService.getAll().forEach(System.out::println);
    }
}
