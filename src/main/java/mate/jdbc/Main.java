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

        Manufacturer autoZaz = new Manufacturer(null,"Daewoo", "Ukraine");
        Manufacturer dodge = new Manufacturer(null,"Range Rover", "USA");
        Manufacturer mazda = new Manufacturer(null,"Honda", "Japan");

        manufacturerService.create(autoZaz);
        manufacturerService.create(dodge);
        manufacturerService.create(mazda);
        System.out.println(manufacturerService.getAll());

        dodge.setCountry("Canada");

        manufacturerService.update(dodge);
        System.out.println(manufacturerService.get(dodge.getId()));
        System.out.println(manufacturerService.getAll());

        manufacturerService.delete(dodge.getId());
        System.out.println(manufacturerService.getAll());

        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);

        Driver petroVasylenko = new Driver(null, "John Lysenko", "AA 11111");
        Driver nazarKovalenko = new Driver(null, "Marichka Kononenko", "АВ 22222");
        Driver illiaDanchuk = new Driver(null, "Harry Shevchenco", "CA 33333");

        driverService.create(petroVasylenko);
        driverService.create(nazarKovalenko);
        driverService.create(illiaDanchuk);
        System.out.println(driverService.getAll());

        nazarKovalenko.setName("Nazar Nesterenko");

        driverService.update(nazarKovalenko);
        System.out.println(driverService.get(nazarKovalenko.getId()));
        System.out.println(driverService.getAll());

        driverService.delete(nazarKovalenko.getId());
        System.out.println(driverService.getAll());
    }
}
