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
        Manufacturer bmwManufacturer = new Manufacturer("BMW", "Germany");
        Manufacturer audiManufacturer = new Manufacturer("Audi", "Germany");
        Manufacturer volvoManufacturer = new Manufacturer("Volvo", "Sweden");
        manufacturerService.create(bmwManufacturer);
        manufacturerService.create(audiManufacturer);
        manufacturerService.create(volvoManufacturer);
        bmwManufacturer.setName("Bmw");
        manufacturerService.update(bmwManufacturer);
        manufacturerService.delete(audiManufacturer.getId());
        List<Manufacturer> allManufacturers = manufacturerService.getAll();
        allManufacturers.forEach(System.out::println);

        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        Driver robert = new Driver("Robert", "96485");
        driverService.create(robert);
        Driver olexiy = new Driver("Olexiy", "37465");
        driverService.create(olexiy);
        Driver patryk = new Driver("Patryk", "38950");
        driverService.create(patryk);
        olexiy.setLicenseNumber("65392");
        driverService.update(olexiy);
        driverService.delete(robert.getId());
        List<Driver> allDrivers = driverService.getAll();
        allDrivers.forEach(System.out::println);
    }
}
