package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final String DRIVER_NAME_1 = "Bob";
    private static final String DRIVER_LICENSE_NUMBER_1 = "111 111 111";
    private static final String DRIVER_NAME_2 = "Alice";
    private static final String DRIVER_LICENSE_NUMBER_2 = "222 222 222";
    private static final String DRIVER_NAME_TO_UPDATE = "Alex";
    private static final String MANUFACTURER_NAME_1 = "BMW";
    private static final String MANUFACTURER_COUNTRY_1 = "Germany";
    private static final String MANUFACTURER_NAME_2 = "Volvo";
    private static final String MANUFACTURER_COUNTRY_2 = "Sweden";
    private static final String MANUFACTURER_NAME_TO_UPDATE = "Fiat";
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driver1 = new Driver(null, DRIVER_NAME_1, DRIVER_LICENSE_NUMBER_1);
        Driver driver2 = new Driver(null, DRIVER_NAME_2, DRIVER_LICENSE_NUMBER_2);
        driverService.create(driver1);
        driverService.create(driver2);
        driverService.getAll().forEach(System.out::println);
        System.out.println(driverService.get(1L));
        driver1.setName(DRIVER_NAME_TO_UPDATE);
        driverService.update(driver1);
        driverService.getAll().forEach(System.out::println);
        driverService.delete(2L);
        driverService.getAll().forEach(System.out::println);
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer1 =
                new Manufacturer(null, MANUFACTURER_NAME_1, MANUFACTURER_COUNTRY_1);
        Manufacturer manufacturer2 =
                new Manufacturer(null, MANUFACTURER_NAME_2, MANUFACTURER_COUNTRY_2);
        manufacturerService.create(manufacturer1);
        manufacturerService.create(manufacturer2);
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println(manufacturerService.get(1L));
        manufacturer1.setName(MANUFACTURER_NAME_TO_UPDATE);
        manufacturerService.update(manufacturer2);
        manufacturerService.getAll().forEach(System.out::println);
        manufacturerService.delete(2L);
        manufacturerService.getAll().forEach(System.out::println);
    }
}
