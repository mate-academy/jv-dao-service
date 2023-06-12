package mate.jdbc;

import java.util.ArrayList;
import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        List<Driver> driversList = new ArrayList<>();
        driversList.add(new Driver("Oleksii", "AST 445823"));
        driversList.add(new Driver("Mykyta", "AST 778521"));
        driversList.add(new Driver("Ivan", "BXT 996993"));

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        driversList.forEach(driverService::create);
        System.out.println(driverService.getAll());

        Driver updateDriver = new Driver(3L,"Viktoriia", "TRE 121368");
        System.out.println("Driver with id: 3 before update = " + driverService.get(3L));
        driverService.update(updateDriver);
        System.out.println("Driver with id: " + updateDriver.getId() + " after update = "
                + driverService.get(3L));

        driverService.delete(3L);
        System.out.println("Drivers table after deletion driver with id 3 = "
                + driverService.getAll());

        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        List<Manufacturer> manufacturersList = new ArrayList<>();
        manufacturersList.add(new Manufacturer("Audi", "Germany"));
        manufacturersList.add(new Manufacturer("Volkswagen", "Germany"));
        manufacturersList.add(new Manufacturer("Fiat", "Italy"));
        manufacturersList.add(new Manufacturer("Toyota", "Japan"));
        manufacturersList.add(new Manufacturer("Volvo", "Sweden"));
        manufacturersList.add(new Manufacturer("Volvo", "USA"));
        manufacturersList.forEach(manufacturerService::create);
        System.out.println(manufacturerService.getAll());

        Manufacturer updateManufacturer = new Manufacturer(4L, "Renault", "France");
        System.out.println("Manufacturer with id: 4 before update = "
                + manufacturerService.get(4L));
        manufacturerService.update(updateManufacturer);
        System.out.println("Manufacturer with id: 4 after update = "
                + manufacturerService.get(4L));

        manufacturerService.delete(4L);
        System.out.println("Manufacturers table after deletion manufacturer with id 4 = "
                + driverService.getAll());
    }
}
