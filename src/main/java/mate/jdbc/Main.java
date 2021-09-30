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

        System.out.println("Tests for manufacturerService" + System.lineSeparator());

        System.out.println(System.lineSeparator() + "Creation: ");
        Manufacturer bmw = manufacturerService
                .create(new Manufacturer("BMW", "Germany"));
        Manufacturer mercedes = manufacturerService
                .create(new Manufacturer("Mercedes", "Germany"));
        Manufacturer audi = manufacturerService
                .create(new Manufacturer("Audi", "Germany"));
        System.out.println(bmw);
        System.out.println(mercedes);
        System.out.println(audi);

        System.out.println(System.lineSeparator() + "Get all: ");
        System.out.println(manufacturerService.getAll());

        System.out.println(System.lineSeparator() + "Update: ");
        System.out.println("Before: " + bmw);
        bmw.setName("Bayerische Motoren Werke AG");
        manufacturerService.update(bmw);
        System.out.println("After: " + bmw);

        System.out.println(System.lineSeparator() + "Get by id: ");
        System.out.println(manufacturerService.get(bmw.getId()));
        System.out.println(manufacturerService.get(mercedes.getId()));

        System.out.println(System.lineSeparator() + "Delete: ");
        System.out.println("Manufacturer which is deleted: " + audi);
        manufacturerService.delete(audi.getId());
        System.out.println("After deleting:" + manufacturerService.getAll());

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        System.out.println("Tests for driverService" + System.lineSeparator());

        System.out.println(System.lineSeparator() + "Creation: ");
        Driver misha = driverService
                .create(new Driver("Misha", "Ukraine"));
        Driver joe = driverService
                .create(new Driver("Joe", "USA"));
        Driver hanz = driverService
                .create(new Driver("Hanz", "Germany"));
        System.out.println(misha);
        System.out.println(joe);
        System.out.println(hanz);

        System.out.println(System.lineSeparator() + "Get all: ");
        System.out.println(driverService.getAll());

        System.out.println(System.lineSeparator() + "Update: ");
        System.out.println("Before: " + misha);
        misha.setName("Zybenko Michail Petrovych");
        driverService.update(misha);
        System.out.println("After: " + misha);

        System.out.println(System.lineSeparator() + "Get by id: ");
        System.out.println(driverService.get(misha.getId()));
        System.out.println(driverService.get(joe.getId()));

        System.out.println(System.lineSeparator() + "Delete: ");
        System.out.println("Driver which is deleted: " + joe);
        driverService.delete(joe.getId());
        System.out.println("After deleting:" + driverService.getAll());
    }
}
