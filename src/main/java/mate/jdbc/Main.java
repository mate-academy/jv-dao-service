package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final long INDEX_NOT_OK = 999L;

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);

        Manufacturer audiManufacturer = new Manufacturer("Audi", "Germany");
        Manufacturer infinityManufacturer = new Manufacturer("Infinity", "Japan");
        Manufacturer teslaManufacturer = new Manufacturer("Tesla", "Tesla");

        System.out.println(manufacturerService.create(audiManufacturer));
        System.out.println(manufacturerService.create(infinityManufacturer));
        System.out.println(manufacturerService.create(teslaManufacturer));

        final long INDEX_OK = audiManufacturer.getId();
        System.out.println(manufacturerService.get(INDEX_OK).getId());
        //System.out.println(manufacturerService.get(INDEX_NOT_OK).getId());

        infinityManufacturer.setName("Nissan");
        System.out.println(manufacturerService.update(infinityManufacturer));

        System.out.println(manufacturerService.delete(INDEX_OK));
        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);

        Driver audiDriver = new Driver("Jhon Bridge", "111111111");
        Driver infinityDriver = new Driver("Ivan Sverlov", "2222222222");
        Driver teslaDriver = new Driver("Mike Trump", "33333333333");

        System.out.println(driverService.create(audiDriver));
        System.out.println(driverService.create(infinityDriver));
        System.out.println(driverService.create(teslaDriver));

        System.out.println(driverService.get(INDEX_OK));

        infinityDriver.setName("Mykola Ivannenko");
        System.out.println(driverService.update(infinityDriver));

        System.out.println(driverService.delete(1L));
        driverService.getAll().forEach(System.out::println);
    }
}
