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

        Manufacturer autoZaz = new Manufacturer(null,"Zaz", "Ukraine");
        Manufacturer dodge = new Manufacturer(null,"Dodge", "USA");
        Manufacturer mazda = new Manufacturer(null,"Mazda", "Japan");

        manufacturerService.create(autoZaz);
        manufacturerService.create(dodge);
        manufacturerService.create(mazda);
        System.out.println(manufacturerService.getAll());
        System.out.println("__________________________________________________________________");

        dodge.setCountry("Canada");

        manufacturerService.update(dodge);
        System.out.println(manufacturerService.get(dodge.getId()));
        System.out.println(manufacturerService.getAll());
        System.out.println("__________________________________________________________________");

        manufacturerService.delete(dodge.getId());
        System.out.println(manufacturerService.getAll());
        System.out.println("__________________________________________________________________");

        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);

        Driver petroVasylenko = new Driver(null, "Petro Vasylenko", "AAA 11111");
        Driver nazarKovalenko = new Driver(null, "Nazar Kovalenko", "BBB 22222");
        Driver illiaDanchuk = new Driver(null, "Illia Danchuk", "CCC 33333");

        driverService.create(petroVasylenko);
        driverService.create(nazarKovalenko);
        driverService.create(illiaDanchuk);
        System.out.println(driverService.getAll());
        System.out.println("__________________________________________________________________");

        nazarKovalenko.setName("Nazar Samchuk");

        driverService.update(nazarKovalenko);
        System.out.println(driverService.get(nazarKovalenko.getId()));
        System.out.println(driverService.getAll());
        System.out.println("__________________________________________________________________");

        driverService.delete(nazarKovalenko.getId());
        System.out.println(driverService.getAll());
        System.out.println("__________________________________________________________________");
    }
}
