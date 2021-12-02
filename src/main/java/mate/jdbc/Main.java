package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.servise.DriverService;
import mate.jdbc.servise.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        final ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        final DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);

        System.out.println("START TEST FOR MANUFACTURERS SERVICE:");
        Manufacturer manufacturerFord = new Manufacturer("Ford", "USA");
        Manufacturer manufacturerToyota = new Manufacturer("Toyota", "Japan");
        manufacturerService.create(manufacturerFord);
        manufacturerService.create(manufacturerToyota);
        System.out.println("TEST for get() manufacturerFord: "
                + manufacturerService.get(manufacturerFord.getId()));
        System.out.println("TEST for get() manufacturerToyota: "
                + manufacturerService.get(manufacturerToyota.getId()));
        System.out.println("TEST for getAll() manufacturers: "
                + manufacturerService.getAll());
        manufacturerFord.setCountry("Germany");
        manufacturerService.update(manufacturerFord);
        System.out.println("TEST for update() manufacturerFord: "
                + manufacturerService.get(manufacturerFord.getId()));
        boolean isDeletedManufacturer = manufacturerService.delete(manufacturerToyota.getId());
        System.out.println("TEST for delete() manufacturerToyota: "
                + isDeletedManufacturer);
        System.out.println("TEST for getAll() after work: "
                + manufacturerService.getAll());
        System.out.println("END MANUFACTURERS SERVICE TEST\n\n");

        System.out.println("START TEST FOR DRIVER SERVICE:");
        Driver driverJohn = new Driver("John", "JH5563G");
        Driver driverMark = new Driver("Mark", "TY999FG");
        driverService.create(driverJohn);
        driverService.create(driverMark);
        System.out.println("TEST for get() driverJohn: "
                + driverService.get(driverJohn.getId()));
        System.out.println("TEST for get() driverMark: "
                + driverService.get(driverMark.getId()));
        System.out.println("TEST for getAll() drivers: "
                + driverService.getAll());
        driverJohn.setName("Collins");
        driverService.update(driverJohn);
        System.out.println("TEST for update() driverJohn: "
                + driverService.get(driverJohn.getId()));
        boolean isDeletedDriver = driverService.delete(driverMark.getId());
        System.out.println("TEST for delete() driverMark: "
                + isDeletedDriver);
        System.out.println("TEST for getAll() after work: "
                + driverService.getAll());
        System.out.println("END DRIVER SERVICE TEST");
    }
}
