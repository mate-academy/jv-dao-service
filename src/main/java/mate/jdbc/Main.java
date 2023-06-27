package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        Manufacturer audi = new Manufacturer("audi", "Italy");
        Manufacturer volvo = new Manufacturer("volvo", "Germany");
        Manufacturer reno = new Manufacturer("reno", "France");
        manufacturerService.create(audi);
        manufacturerService.create(volvo);
        manufacturerService.create(reno);
        System.out.println(manufacturerService.get(audi.getId()));
        manufacturerService.delete(audi.getId());
        Manufacturer manufacturerToUpdate = new Manufacturer(2L, "shkoda", "Japan");
        manufacturerService.update(manufacturerToUpdate);
        Manufacturer manufacturerWithIndex3 = manufacturerService.get(3L);
        Manufacturer manufacturerToCompare = new Manufacturer(3L, "reno", "France");
        boolean compareManufacturers = manufacturerWithIndex3.equals(manufacturerToCompare);
        System.out.println(compareManufacturers);
        List<Manufacturer> allManufacturers = manufacturerService.getAll();
        allManufacturers.forEach(System.out::println);
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver bob = new Driver("Bob", "12345678");
        Driver alice = new Driver("Alice", "2222");
        Driver john = new Driver("John", "848484834838");
        driverService.create(bob);
        driverService.create(alice);
        driverService.create(john);
        System.out.println(driverService.get(john.getId()));
        driverService.delete(john.getId());
        Driver updatedAlice = new Driver(2L,"NewAlice", "857820");
        driverService.update(updatedAlice);
        Driver driverWithIndex1 = driverService.get(1L);
        Driver driverToCompare = new Driver(1L, "Bob", "12345678");
        boolean compareDrivers = driverToCompare.equals(driverWithIndex1);
        System.out.println(compareDrivers);
        List<Driver> allDrivers = driverService.getAll();
        allDrivers.forEach(System.out::println);
    }
}
