package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    
    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver vova = new Driver("Vova", "12345");
        Driver denis = new Driver("Denis", "67890");
        driverService.create(vova);
        driverService.create(denis);
        driverService.get(vova.getId());
        vova.setLicenseNumber("22222");
        driverService.update(vova);
        driverService.delete(denis.getId());
        System.out.println(driverService.getAll());
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        Manufacturer mercedes = new Manufacturer("Mercedes", "Germany");
        Manufacturer bentley = new Manufacturer("Bentley", "United Kingdom");
        manufacturerService.create(mercedes);
        manufacturerService.create(bentley);
        mercedes.setCountry("Ukraine");
        manufacturerService.update(mercedes);
        manufacturerService.delete(bentley.getId());
        System.out.println(manufacturerService.getAll());
    }
}
