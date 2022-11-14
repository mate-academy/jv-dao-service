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
        Manufacturer manufacturerAudi = new Manufacturer("Audi", "Germany");
        Manufacturer manufacturerBmw = new Manufacturer("BMW", "Germany");
        Manufacturer manufacturerMercedes = new Manufacturer("Mercedes", "Germany");
        final Manufacturer manufacturerVolvo = new Manufacturer("Volvo", "Switzerland");
        manufacturerService.create(manufacturerAudi);
        manufacturerService.create(manufacturerBmw);
        manufacturerService.create(manufacturerMercedes);
        System.out.println("Manufacturers from DB after creating: "
                + manufacturerService.getAll());
        System.out.println("Manufacturer Audi from DB: "
                + manufacturerService.get(manufacturerAudi.getId()));
        manufacturerVolvo.setId(manufacturerBmw.getId());
        manufacturerService.update(manufacturerVolvo);
        System.out.println("Manufacturers from DB after updating: "
                + manufacturerService.getAll());
        manufacturerService.delete(manufacturerMercedes.getId());
        System.out.println("Manufacturers from DB after deleting: "
                + manufacturerService.getAll());

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driverBob = new Driver("Bob", "BXP123456");
        Driver driverAlice = new Driver("Alice", "BXP654321");
        Driver driverBill = new Driver("Bill", "BXP122211");
        final Driver driverJohn = new Driver("John", "BXP000001");
        driverService.create(driverBob);
        driverService.create(driverAlice);
        driverService.create(driverBill);
        System.out.println("Drivers from DB after creating: " + driverService.getAll());
        System.out.println("Driver Bob from DB: " + driverService.get(driverBob.getId()));
        driverJohn.setId(driverAlice.getId());
        driverService.update(driverJohn);
        System.out.println("Drivers from DB after updating: " + driverService.getAll());
        driverService.delete(driverBill.getId());
        System.out.println("Drivers from DB after deleting: " + driverService.getAll());
    }
}
