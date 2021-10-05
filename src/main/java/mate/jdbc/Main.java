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
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        Driver sergii = new Driver("Sergii", "CAX 102210");
        Driver anatolii = new Driver("Anatolii", "CDF 154260");
        sergii = driverService.create(sergii);
        anatolii = driverService.create(anatolii);
        Manufacturer bmw = new Manufacturer("BMW", "Germany");
        Manufacturer ford = new Manufacturer("Ford", "USA");
        bmw = manufacturerService.create(bmw);
        ford = manufacturerService.create(ford);
        List<Driver> driverList = driverService.getAll();
        List<Manufacturer> manufacturerList = manufacturerService.getAll();
        driverList.forEach(System.out::println);
        manufacturerList.forEach(System.out::println);
        sergii.setLicenseNumber("FES 198889");
        driverService.update(sergii);
        driverService.delete(anatolii.getId());
        driverList.forEach(System.out::println);
    }
}
