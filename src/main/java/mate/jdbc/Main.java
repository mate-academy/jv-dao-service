package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    public static void main(String[] args) {
        Injector injector = Injector.getInstance("mate.jdbc");
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);

        manufacturerService.create(new Manufacturer(null, "Mercedes", "Germany"));
        manufacturerService.create(new Manufacturer(null, "BMW", "Germany"));
        manufacturerService.create(new Manufacturer(null, "Alfa Romeo", "Italy"));
        manufacturerService.create(new Manufacturer(null, "Skoda", "Czech"));
        Manufacturer zazPlant =
                manufacturerService.create(new Manufacturer(null, "ZAZ", "Belarus"));
        printList(manufacturerService.getAll());

        Manufacturer zazPlantFromDB = manufacturerService.get(zazPlant.getId());
        System.out.println(zazPlantFromDB);
        System.out.println();

        zazPlant.setCountry("Ukraine");
        manufacturerService.update(zazPlant);
        printList(manufacturerService.getAll());

        manufacturerService.delete(zazPlant.getId());
        manufacturerService.getAll();
        printList(manufacturerService.getAll());

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        driverService.create(new Driver(null, "Mark", "100"));
        driverService.create(new Driver(null, "Daniel", "200"));
        driverService.create(new Driver(null, "Bill", "300"));
        driverService.create(new Driver(null, "Ben", "400"));
        Driver driver = driverService.create(new Driver(null, "Jack", "-100"));
        printList(driverService.getAll());

        Driver driverFromDB = driverService.get(driver.getId());
        System.out.println(driverFromDB);
        System.out.println();

        driver.setLicenseNumber("500");
        driverService.update(driver);
        printList(driverService.getAll());

        driverService.delete(driver.getId());
        driverService.getAll();
        printList(driverService.getAll());
    }

    private static <T> void printList(List<T> list) {
        for (T item: list) {
            System.out.println(item);
        }
        System.out.println();
    }
}
