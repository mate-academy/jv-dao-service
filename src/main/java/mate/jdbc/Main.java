package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        final DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        final ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);

        //check DriverService
        Driver alex = new Driver(null, "Alex", "AA7555HI");
        Driver dmytro = new Driver(null, "Dmytro", "AA1234TA");
        Driver sergiy = new Driver(null, "Sergiy", "WW23342");
        Driver ivan = new Driver(null, "Ivan", "AX1234AX");

        //create
        driverService.create(alex);
        driverService.create(dmytro);
        driverService.create(sergiy);
        driverService.create(ivan);

        //read all
        driverService.getAll().forEach(System.out::println);

        //read by id
        Driver driverAlex = driverService.getAll().stream()
                .filter(driver -> driver.getName().equals("Alex"))
                .findFirst()
                .get();
        System.out.println(driverService.get(driverAlex.getId()).equals(driverAlex));

        //update read
        driverAlex.setName("Mykola");
        System.out.println(driverService.update(driverAlex));

        //delete
        System.out.println(driverService.delete(driverAlex.getId()));
        driverService.getAll().forEach(System.out::println);

        //check ManufacturerService
        Manufacturer audi = new Manufacturer(null, "Audi", "Germany");
        Manufacturer bmw = new Manufacturer(null, "BMW", "Germany");
        Manufacturer porsche = new Manufacturer(null, "Porsche", "Germany");
        Manufacturer zaz = new Manufacturer(null, "ZAZ", "Ukraine");

        //create
        manufacturerService.create(audi);
        manufacturerService.create(bmw);
        manufacturerService.create(porsche);
        manufacturerService.create(zaz);

        //read all
        manufacturerService.getAll().forEach(System.out::println);

        //read by id
        Manufacturer manufacturerAudi = manufacturerService.getAll().stream()
                .filter(manufacturer -> manufacturer.getName().equals("Audi"))
                .findFirst()
                .get();
        System.out.println(manufacturerService.get(manufacturerAudi.getId())
                .equals(manufacturerAudi));

        //update
        manufacturerAudi.setCountry("Ukraine");
        System.out.println(manufacturerService.update(manufacturerAudi));

        //delete
        System.out.println(manufacturerService.delete(manufacturerAudi.getId()));
        manufacturerService.getAll().forEach(System.out::println);
    }
}
