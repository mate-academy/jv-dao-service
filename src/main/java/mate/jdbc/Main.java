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
        Manufacturer mercedes = new Manufacturer(null, "Mercedes", "Germany");
        Manufacturer lada = new Manufacturer(null, "Lada", "Ukraine");
        Manufacturer mazda = new Manufacturer(null, "Mazda", "Japan");
        mercedes = manufacturerService.create(mercedes);
        lada = manufacturerService.create(lada);
        mazda = manufacturerService.create(mazda);
        System.out.println("Create 3 manufacturers");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("---");
        mazda.setName("Toyota");
        manufacturerService.update(mazda);
        System.out.println("Change manufacturer name Mazda to Toyota");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("---");
        manufacturerService.delete(mercedes.getId());
        System.out.println("Delete manufacturer mercedes from database");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("---");
        Manufacturer getManufacturer = manufacturerService.get(lada.getId());
        System.out.println("Get manufacturer Lada from database");
        System.out.println(getManufacturer);
        System.out.println("********");
        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);
        Driver yaroslav = new Driver(null, "Yaroslav", "666");
        Driver eugene = new Driver(null, "Eugene", "777");
        Driver volodimir = new Driver(null, "Volodimir", "888");
        yaroslav = driverService.create(yaroslav);
        eugene = driverService.create(eugene);
        volodimir = driverService.create(volodimir);
        System.out.println("Create 3 drivers");
        driverService.getAll().forEach(System.out::println);
        System.out.println("---");
        volodimir.setName("Stepan");
        driverService.update(volodimir);
        System.out.println("Change driver name Volodimir to Stepan");
        driverService.getAll().forEach(System.out::println);
        System.out.println("---");
        driverService.delete(yaroslav.getId());
        System.out.println("Delete driver yaroslav from drivers database");
        driverService.getAll().forEach(System.out::println);
        System.out.println("---");
        Driver getDriver = driverService.get(eugene.getId());
        System.out.println("Get driver Eugene from drivers database");
        System.out.println(getDriver);
    }
}
