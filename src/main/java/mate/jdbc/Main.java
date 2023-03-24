package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.services.DriverService;
import mate.jdbc.services.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final ManufacturerService manufacturerService = (ManufacturerService) injector
            .getInstance(ManufacturerService.class);
    public static final DriverService driverService = (DriverService) injector
            .getInstance(DriverService.class);

    public static void main(String[] args) {
        Manufacturer audi = new Manufacturer("Audi", "Germany");
        Manufacturer mercedes = new Manufacturer("mercedes", "Germany");
        manufacturerService.create(mercedes);
        manufacturerService.create(audi);
        manufacturerService.getAll().forEach(System.out::println);
        Manufacturer car = manufacturerService.get(audi.getId()).get();
        System.out.println(car);
        mercedes.setCountry("Canada");
        manufacturerService.update(mercedes);
        manufacturerService.delete(mercedes.getId());

        Driver driver = new Driver("Alona", "ТТ1234");
        driverService.create(driver);
        driverService.getAll().forEach(System.out::println);
        driver.setName("Aloha");
        driverService.update(driver);
        Driver newAlona = driverService.get(driver.getId());
        System.out.println(newAlona);
        driverService.delete(driver.getId());
    }
}
