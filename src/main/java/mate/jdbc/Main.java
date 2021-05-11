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

        Manufacturer audiManufacturer = new Manufacturer("Audi", "Germany");
        Manufacturer infinityManufacturer = new Manufacturer("Infinity", "Japan");
        Manufacturer teslaManufacturer = new Manufacturer("Tesla", "Tesla");

        System.out.println(manufacturerService.create(audiManufacturer) + System.lineSeparator()
                + manufacturerService.create(infinityManufacturer) + System.lineSeparator()
                + manufacturerService.create(teslaManufacturer) + System.lineSeparator());

        System.out.println(manufacturerService.get(16L) + System.lineSeparator()
                + manufacturerService.get(999L));

        infinityManufacturer.setName("Nissan");
        System.out.println(manufacturerService.update(infinityManufacturer));

        System.out.println(manufacturerService.delete(1L));
        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);

        Driver audiDriver = new Driver("Jhon Bridge", "111111111");
        Driver infinityDriver = new Driver("Ivan Sverlov", "2222222222");
        Driver teslaDriver = new Driver("Mike Trump", "33333333333");

        System.out.println(driverService.create(audiDriver) + System.lineSeparator()
                + driverService.create(infinityDriver) + System.lineSeparator()
                + driverService.create(teslaDriver) + System.lineSeparator());

        System.out.println(driverService.get(19L) + System.lineSeparator()
                + driverService.get(999L));

        infinityDriver.setName("Mykola Ivannenko");
        System.out.println(driverService.update(infinityDriver));

        System.out.println(driverService.delete(1L));
        driverService.getAll().forEach(System.out::println);
    }
}
